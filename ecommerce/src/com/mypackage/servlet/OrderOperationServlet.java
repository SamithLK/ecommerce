package com.mypackage.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import com.mypackage.dao.CartDao;
import com.mypackage.dao.OrderDao;
import com.mypackage.dao.OrderedProductDao;
import com.mypackage.dao.ProductDao;
import com.mypackage.model.Cart;
import com.mypackage.model.Order;
import com.mypackage.model.OrderedProduct;
import com.mypackage.model.Product;
import com.mypackage.model.User;
import com.mypackage.connection.DbCon;

import com.mypackage.connection.OrderIdMethod;


@WebServlet("/OrderOperationServlet")
public class OrderOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String from = (String) session.getAttribute("from");
		String paymentType = request.getParameter("paymentMode");
		User user = (User) session.getAttribute("activeUser");
		String orderId = OrderIdMethod.getOrderId();
		String status = "Order Placed";

		if (from.trim().equals("cart")) {
			try {

				Order order = new Order(orderId, status, paymentType, user.getUserId());
				OrderDao orderDao = new OrderDao(DbCon.getConnection());
				int id = orderDao.insertOrder(order);

				CartDao cartDao = new CartDao(DbCon.getConnection());
				List<Cart> listOfCart = cartDao.getCartListByUserId(user.getUserId());
				OrderedProductDao orderedProductDao = new OrderedProductDao(DbCon.getConnection());
				ProductDao productDao = new ProductDao(DbCon.getConnection());
				for (Cart item : listOfCart) {

					Product prod = productDao.getProductsByProductId(item.getProductId());
					String prodName = prod.getProductName();
					int prodQty = item.getQuantity();
					float price = prod.getProductPriceAfterDiscount();
					String image = prod.getProductImages();

					OrderedProduct orderedProduct = new OrderedProduct(prodName, prodQty, price, image, id);
					orderedProductDao.insertOrderedProduct(orderedProduct);
				}
				session.removeAttribute("from");
				session.removeAttribute("totalPrice");
				
				//removing all product from cart after successful order
				cartDao.removeAllProduct();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (from.trim().equals("buy")) {

			try {

				int pid = (int) session.getAttribute("pid");
				Order order = new Order(orderId, status, paymentType, user.getUserId());
				OrderDao orderDao = new OrderDao(DbCon.getConnection());
				int id = orderDao.insertOrder(order);
				OrderedProductDao orderedProductDao = new OrderedProductDao(DbCon.getConnection());
				ProductDao productDao = new ProductDao(DbCon.getConnection());

				Product prod = productDao.getProductsByProductId(pid);
				String prodName = prod.getProductName();
				int prodQty = 1;
				float price = prod.getProductPriceAfterDiscount();
				String image = prod.getProductImages();

				OrderedProduct orderedProduct = new OrderedProduct(prodName, prodQty, price, image, id);
				orderedProductDao.insertOrderedProduct(orderedProduct);
				
				//updating(decreasing) quantity of product in database
				productDao.updateQuantity(pid, productDao.getProductQuantityById(pid) - 1);
				
				session.removeAttribute("from");
				session.removeAttribute("pid");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    session.setAttribute("order", "success");
	    response.sendRedirect("index.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}