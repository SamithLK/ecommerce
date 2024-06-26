package com.mypackage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypackage.connection.DbCon;
import com.mypackage.dao.AdminDao;
import com.mypackage.dao.UserDao;
import com.mypackage.model.Admin;
import com.mypackage.model.Message;
import com.mypackage.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		if (login.trim().equals("user")) {
			try {
				String userEmail = request.getParameter("user_email");
				String userPassword = request.getParameter("user_password");

				
				UserDao userDao = new UserDao(DbCon.getConnection());
				User user = userDao.getUserByEmailPassword(userEmail, userPassword);

				HttpSession session = request.getSession();
				if (user != null) {
					session.setAttribute("activeUser", user);
					response.sendRedirect("index.jsp");
				} else {
					Message message = new Message("Invalid Credintials! Try again!!", "error", "alert-danger");
					session.setAttribute("message", message);
					response.sendRedirect("login.jsp");
					return;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (login.trim().equals("admin")) {
			try {
				String userName = request.getParameter("email");
				String password = request.getParameter("password");

				AdminDao adminDao = new AdminDao(DbCon.getConnection());
				Admin admin = adminDao.getAdminByEmailPassword(userName, password);

				HttpSession session = request.getSession();
				if (admin != null) {
					session.setAttribute("activeAdmin", admin);
					response.sendRedirect("Admin.jsp");
					System.out.println("Active admin logged in..");
				} else {
					Message message = new Message("Invalid Credintials! Try again!!", "error", "alert-danger");
					session.setAttribute("message", message);
					System.out.println("Active admin not logged in..");
					response.sendRedirect("LogAdmin.jsp");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
