package com.mypackage.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mypackage.connection.DbCon;
import com.mypackage.dao.CategoryDao;
import com.mypackage.dao.OrderDao;
import com.mypackage.dao.OrderedProductDao;
import com.mypackage.dao.ProductDao;
import com.mypackage.model.Category;
import com.mypackage.model.Message;
import com.mypackage.model.Product;

@MultipartConfig
@WebServlet("/AdminUpdateProducts")
public class AdminUpdateProducts extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			try {
				
				String operation = request.getParameter("operation");
				CategoryDao catDao = new CategoryDao(DbCon.getConnection());
				ProductDao pdao = new ProductDao(DbCon.getConnection());
				HttpSession session = request.getSession();
				Message message = null;

				if (operation.trim().equals("addCategory")) {

					String categoryName = request.getParameter("category_name");
					Part part = request.getPart("category_img");
					Category category = new Category(categoryName, part.getSubmittedFileName());
					boolean flag = catDao.saveCategory(category);

					String path = request.getServletContext().getRealPath("/") + "product-images" + File.separator
							+ part.getSubmittedFileName();

					try {
						FileOutputStream fos = new FileOutputStream(path);
						InputStream is = part.getInputStream();
						byte[] data = new byte[is.available()];
						is.read(data);
						fos.write(data);
						fos.flush();
						fos.close();

					} catch (Exception e) {
						e.printStackTrace();
					}

					if (flag) {
						message = new Message("Category added successfully!!", "success", "alert-success");
					} else {
						message = new Message("Something went wrong! Try again!!", "error", "alert-danger");
					}
					session.setAttribute("message", message);
					response.sendRedirect("Admin.jsp");

				} else if (operation.trim().equals("addProduct")) {

					// add product to database
					String pName = request.getParameter("name");
					String pDesc = request.getParameter("description");
					int pPrice = Integer.parseInt(request.getParameter("price"));
					int pDiscount = Integer.parseInt(request.getParameter("discount"));
					if (pDiscount < 0 || pDiscount > 100) {
						pDiscount = 0;
					}
					int pQuantity = Integer.parseInt(request.getParameter("quantity"));
					Part part = request.getPart("photo");
					int categoryType = Integer.parseInt(request.getParameter("categoryType"));

					Product product = new Product(pName, pDesc, pPrice, pDiscount, pQuantity, part.getSubmittedFileName(),
							categoryType);
					boolean flag = pdao.saveProduct(product);

					String path = request.getServletContext().getRealPath("/") + "product-images" + File.separator
							+ part.getSubmittedFileName();
					try {
						FileOutputStream fos = new FileOutputStream(path);
						InputStream is = part.getInputStream();
						byte[] data = new byte[is.available()];
						is.read(data);
						fos.write(data);
						fos.flush();
						fos.close();

					} catch (Exception e) {
						e.printStackTrace();
					}
					if (flag) {
						message = new Message("Product added successfully!!", "success", "alert-success");
						System.out.println("Product added");
					} else {
						message = new Message("Something went wrong! Try again!!", "error", "alert-danger");
						System.out.println("Product not added");
						
					}
					session.setAttribute("message", message);
					response.sendRedirect("Admin.jsp");
					
				} else if (operation.trim().equals("updateCategory")) {

					int cid = Integer.parseInt(request.getParameter("cid"));
					String name = request.getParameter("category_name");
					Part part = request.getPart("category_img");
					if (part.getSubmittedFileName().isEmpty()) {
						String image = request.getParameter("image");
						Category category = new Category(cid, name, image);
						catDao.updateCategory(category);
					} else {
						Category category = new Category(cid, name, part.getSubmittedFileName());
						catDao.updateCategory(category);
						String path = request.getServletContext().getRealPath("/") + "product-images" + File.separator
								+ part.getSubmittedFileName();
						try {
							FileOutputStream fos = new FileOutputStream(path);
							InputStream is = part.getInputStream();
							byte[] data = new byte[is.available()];
							is.read(data);
							fos.write(data);
							fos.flush();
							fos.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					message = new Message("Category updated successfully!!", "success", "alert-success");
					session.setAttribute("message", message);
					response.sendRedirect("admin-category.jsp");
					
				} else if (operation.trim().equals("deleteCategory")) {

					int cid = Integer.parseInt(request.getParameter("cid"));
					catDao.deleteCategory(cid);
					response.sendRedirect("admin-category.jsp");

				} else if (operation.trim().equals("updateProduct")) {

					int pid = Integer.parseInt(request.getParameter("pid"));
					String name = request.getParameter("name");
					float price = Float.parseFloat(request.getParameter("price"));
					String description = request.getParameter("description");
					int quantity = Integer.parseInt(request.getParameter("quantity"));
					int discount = Integer.parseInt(request.getParameter("discount"));
					if (discount < 0 || discount > 100) {
						discount = 0;
					}
					Part part = request.getPart("product_img");
					int cid = Integer.parseInt(request.getParameter("categoryType"));
					if (cid == 0) {
						cid = Integer.parseInt(request.getParameter("category"));
					}
					if (part.getSubmittedFileName().isEmpty()) {
						String image = request.getParameter("image");
						Product product = new Product(pid, name, description, price, discount, quantity, image, cid);
						pdao.updateProduct(product);
					} else {

						Product product = new Product(pid, name, description, price, discount, quantity,
								part.getSubmittedFileName(), cid);
						pdao.updateProduct(product);
						// product image upload
						String path = request.getServletContext().getRealPath("/") + "Product_imgs" + File.separator
								+ part.getSubmittedFileName();
						try {
							FileOutputStream fos = new FileOutputStream(path);
							InputStream is = part.getInputStream();
							byte[] data = new byte[is.available()];
							is.read(data);
							fos.write(data);
							fos.flush();
							fos.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					message = new Message("Product updated successfully!!", "success", "alert-success");
					session.setAttribute("message", message);
					response.sendRedirect("admin-products.jsp");

				} else if (operation.trim().equals("deleteProduct")) {

					int pid = Integer.parseInt(request.getParameter("pid"));
					pdao.deleteProduct(pid);
					message = new Message("Product Deleted successfully!!", "success", "alert-success");
					session.setAttribute("message", message);
					response.sendRedirect("admin-products.jsp");

				}
				return;
				
			
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
			//UPDATE STATUS OF THE ORDER....
			try {
				
				int oid = Integer.parseInt(request.getParameter("oid"));
			    String status = request.getParameter("status");
			    OrderDao orderDao = new OrderDao(DbCon.getConnection());
			    orderDao.updateOrderStatus(oid, status);
			    response.sendRedirect("admin-orders.jsp");
			  
				
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