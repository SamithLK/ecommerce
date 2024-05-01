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
import com.mypackage.model.Cart;
import com.mypackage.model.Message;
import com.mypackage.connection.DbCon;


@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uid = Integer.parseInt(req.getParameter("uid"));
		int pid = Integer.parseInt(req.getParameter("pid"));

		try {
			
			CartDao cartDao = new CartDao(DbCon.getConnection());
			
			int qty = cartDao.getQuantity(uid, pid);
			HttpSession session = req.getSession();
			Message message = null;
			
			if (qty == 0) {
				Cart cart = new Cart(uid, pid, qty + 1);
				cartDao.addToCart(cart);
				message = new Message("Product is added to cart successfully!", "success", "alert-success");
				
			}else {
				int cid = cartDao.getIdByUserIdAndProductId(uid, pid);
				cartDao.updateQuantity(cid, qty+1);
				message = new Message("Product quantity is increased!", "success", "alert-success");
			}
			//updating quantity of product in database
			ProductDao productDao = new ProductDao(DbCon.getConnection());
			productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) - 1);
			session.setAttribute("message", message);
			resp.sendRedirect("viewProduct.jsp?pid="+pid);
			
			
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

}