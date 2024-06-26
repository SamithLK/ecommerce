package com.mypackage.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.mypackage.dao.UserDao;
import com.mypackage.model.Message;
import com.mypackage.model.User;
import com.mypackage.connection.DbCon;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			
			try {
				
				String operation = request.getParameter("operation");
				HttpSession session = request.getSession();
				User oldUser = (User) session.getAttribute("activeUser");
				UserDao userDao = new UserDao(DbCon.getConnection());

				if (operation.trim().equals("changeAddress")) {
					try {
						String userAddress = request.getParameter("user_address");
						String userCity = request.getParameter("city");
						String userPincode = request.getParameter("pincode");
						String userState = request.getParameter("state");

						User user = new User();
						user.setUserId(oldUser.getUserId());
						user.setUserName(oldUser.getUserName());
						user.setUserEmail(oldUser.getUserEmail());
						user.setUserPassword(oldUser.getUserPassword());
						user.setUserPhone(oldUser.getUserPhone());
						user.setUserGender(oldUser.getUserGender());
						user.setDateTime(oldUser.getDateTime());
						user.setUserAddress(userAddress);
						user.setUserCity(userCity);
						user.setUserPincode(userPincode);
						user.setUserState(userState);

						userDao.updateUserAddress(user);
						session.setAttribute("activeUser", user);
						response.sendRedirect("checkout.jsp");

					} catch (Exception e) {
						e.printStackTrace();
					}
				
			
			
			} else if (operation.trim().equals("updateUser")) {
				try {
					String userName = request.getParameter("name");
					String userEmail = request.getParameter("email");
					String userPhone = request.getParameter("mobile_no");
					String userGender = request.getParameter("gender");
					String userAddress = request.getParameter("address");
					String userCity = request.getParameter("city");
					String userPincode = request.getParameter("pincode");
					String userState = request.getParameter("state");

					User user = new User(userName, userEmail, userPhone, userGender, userAddress, userCity, userPincode,
							userState);
					user.setUserId(oldUser.getUserId());
					user.setUserPassword(oldUser.getUserPassword());
					user.setDateTime(oldUser.getDateTime());

					userDao.updateUser(user);
					session.setAttribute("activeUser", user);
					Message message = new Message("User information updated successfully!!", "success", "alert-success");
					session.setAttribute("message", message);
					response.sendRedirect("profile.jsp");

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (operation.trim().equals("deleteUser")) {
				int uid = Integer.parseInt(request.getParameter("uid"));
				userDao.deleteUser(uid);
				Message message = new Message("User Kickout from the Database!!", "success", "alert-success");
				session.setAttribute("message", message);
				response.sendRedirect("admin-users.jsp");}
			
		
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}