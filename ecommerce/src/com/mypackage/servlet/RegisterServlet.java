package com.mypackage.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypackage.connection.DbCon;
import com.mypackage.dao.UserDao;
import com.mypackage.model.Message;
import com.mypackage.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String userName = request.getParameter("user_name");
			String userEmail = request.getParameter("user_email");
			String userPassword = request.getParameter("user_password");
			String userPhone = request.getParameter("user_mobile_no");
			String userGender = request.getParameter("gender");
			String userAddress = request.getParameter("user_address");
			String userCity = request.getParameter("city");
			String userPincode = request.getParameter("pincode");
			String userState = request.getParameter("state");

			User user = new User(userName, userEmail, userPassword, userPhone, userGender, userAddress, userCity,userPincode, userState);
			UserDao userdao = new UserDao(DbCon.getConnection());
			boolean flag = userdao.saveUser(user);
			
			if(flag) {
				Message message = null;
				message = new Message("User Account Created Successfully!!", "success", "alert-success");
			
				HttpSession session = request.getSession();
				session.setAttribute("message", message);
				response.sendRedirect("login.jsp");
			}
			
			else {
				System.out.println("Error saving Registration Data....");
			}

			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
