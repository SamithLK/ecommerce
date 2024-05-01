package com.mypackage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypackage.model.Message;



@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user =request.getParameter("user");
		HttpSession session=request.getSession();
		
		if (user.trim().equals(user)) {
			session.removeAttribute("activeUser");
			Message message=new Message("Succefully Logout from the Website..!!","success","alert-success");
			session.setAttribute("message", message);
			System.out.println(message.toString());
			response.sendRedirect("login.jsp");
			
		}
		
	}

}