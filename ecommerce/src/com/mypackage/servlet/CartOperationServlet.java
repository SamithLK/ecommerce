package com.mypackage.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.mypackage.dao.CartDao;
import com.mypackage.dao.ProductDao;
import com.mypackage.model.Message;
import com.mypackage.connection.DbCon;

@WebServlet("/CartOperationServlet")
public class CartOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			CartDao cartDao = new CartDao(DbCon.getConnection());
			ProductDao productDao = new ProductDao(DbCon.getConnection());
			int cid =Integer.parseInt(request.getParameter("cid"));
			int opt =Integer.parseInt(request.getParameter("opt"));
			
			int qty = cartDao.getQuantityById(cid);
			int pid = cartDao.getProductId(cid);
			int quantity = productDao.getProductQuantityById(pid);	
			
			if(opt == 1) {
				if(quantity > 0) {
					cartDao.updateQuantity(cid, qty+1);
					//updating(decreasing) quantity of product in database
					productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) - 1);
					response.sendRedirect("cart.jsp");
					
				}else {
					HttpSession session = request.getSession();
					Message message = new Message("Product out of stock!", "error", "alert-danger");
					session.setAttribute("message", message);
					response.sendRedirect("cart.jsp");
				}
				
			}else if(opt == 2) {
				cartDao.updateQuantity(cid, qty-1);
				
				//updating(increasing) quantity of product in database
				productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) + 1);
				response.sendRedirect("cart.jsp");
				
			}else if(opt == 3) {
				cartDao.removeProduct(cid);
				HttpSession session = request.getSession();
				Message message = new Message("Product removed from cart!", "success", "alert-success");
				session.setAttribute("message", message);
				
				//updating quantity of product in database
				//adding all the product qty back to database
				productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) + qty);
				response.sendRedirect("cart.jsp");
			}
			
		}catch (SQLException e) {
		    // Handle SQL exceptions (e.g., database connection issues, syntax errors)
		    e.printStackTrace();  // For debugging
		    System.out.println("An error occurred while connecting to the database!");
		    
		} catch (ClassNotFoundException e) {
		    // Handle ClassNotFoundException (e.g., missing JDBC driver)
		    e.printStackTrace();  // For debugging
		    System.out.println("The database driver might be missing!");
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}