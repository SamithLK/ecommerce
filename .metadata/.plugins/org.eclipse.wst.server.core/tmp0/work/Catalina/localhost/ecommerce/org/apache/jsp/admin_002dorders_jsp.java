/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-05-01 05:19:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mypackage.model.Message;
import com.mypackage.dao.UserDao;
import com.mypackage.model.Product;
import com.mypackage.model.Product;
import com.mypackage.model.Admin;
import com.mypackage.model.Order;
import com.mypackage.model.OrderedProduct;
import com.mypackage.dao.OrderDao;
import com.mypackage.dao.OrderedProductDao;
import com.mypackage.dao.ProductDao;
import com.mypackage.dao.CategoryDao;
import com.mypackage.connection.DbCon;
import java.util.List;
import com.mypackage.model.User;

public final class admin_002dorders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/includes/css-js.jsp", Long.valueOf(1713262393428L));
    _jspx_dependants.put("/includes/navbar.jsp", Long.valueOf(1714420048446L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(13);
    _jspx_imports_classes.add("com.mypackage.model.Product");
    _jspx_imports_classes.add("com.mypackage.model.Order");
    _jspx_imports_classes.add("com.mypackage.dao.OrderDao");
    _jspx_imports_classes.add("com.mypackage.model.Admin");
    _jspx_imports_classes.add("com.mypackage.model.OrderedProduct");
    _jspx_imports_classes.add("com.mypackage.model.Message");
    _jspx_imports_classes.add("com.mypackage.dao.CategoryDao");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.mypackage.dao.OrderedProductDao");
    _jspx_imports_classes.add("com.mypackage.dao.ProductDao");
    _jspx_imports_classes.add("com.mypackage.connection.DbCon");
    _jspx_imports_classes.add("com.mypackage.dao.UserDao");
    _jspx_imports_classes.add("com.mypackage.model.User");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error_exception.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

OrderDao orderDao = new OrderDao(DbCon.getConnection());
OrderedProductDao ordProdDao = new OrderedProductDao(DbCon.getConnection());
List<Order> orderList = orderDao.getAllOrder();
UserDao userDao = new UserDao(DbCon.getConnection());

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>View Order's</title>\r\n");
      out.write("<!--CSS-->\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">\r\n");
      out.write("<!--font awesome-->\r\n");
      out.write("<!--<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--JavaScript-->\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"JS/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!--jQuery-->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!--sweet alert-->\r\n");
      out.write("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	");
      out.write("<link rel=\"stylesheet\" href=\"css/styles.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");


User user=(User) session.getAttribute("activeUser");


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg  bg-purple\" data-bs-theme=\"dark\" style=\"width: 100%;\">\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("           \r\n");
      out.write("            <a class=\"navbar-brand btn\" href=\"index.jsp\" style=\"transition: outline 5s; text-decoration: none;\" onmouseover=\"this.style.outline='1px solid #17a2b8';\" onmouseout=\"this.style.outline='none';\">\r\n");
      out.write("    <img src=\"about/rlk-2png.png\" style=\"width: 50px; height: 25px; border-radius: 5px; margin-top: 0;\">&nbsp;Rhythm.LK\r\n");
      out.write("</a>\r\n");
      out.write("\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <li class=\"nav-item\" style=\"list-style-type: none;\">\r\n");
      out.write("                        <a class=\"nav-link btn btn-outline-info\" aria-current=\"page\" href=\"index.jsp\" style=\"text-decoration: none;\"><i class=\"fas fa-home\"></i></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("            <!-- Search bar -->\r\n");
      out.write("            <form class=\"d-flex\" style=\"padding-left: 30px;\">\r\n");
      out.write("                <input class=\"form-control me-2 text-center\" type=\"search\" placeholder=\"What Are You Looking For?\" aria-label=\"Search\" style=\"width: 550px; background-color: white;\">\r\n");
      out.write("                <button class=\"btn btn-outline-light\" type=\"submit\"><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("            </form>\r\n");
      out.write("            <!-- End of search bar -->\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"collapse navbar-collapse justify-content-end \" id=\"navbarSupportedContent\">\r\n");
      out.write("                <ul class=\"navbar-nav mr-auto mb-2 mb-lg-0 \">\r\n");
      out.write("                    \r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link btn btn-outline-info\" href=\"cart.jsp\"><i class=\"fas fa-shopping-cart\"></i></a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                  \r\n");
      out.write("                    \r\n");
      out.write("                 ");
   if(user==null){ 
      out.write("\r\n");
      out.write("                   \r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link btn btn-outline-info\" href=\"login.jsp\">Login</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link btn btn-outline-info\" href=\"LogAdmin.jsp\">Admin</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                     \r\n");
      out.write("                    \r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link btn btn-outline-info\" href=\"Register.jsp\">SignUp</a>\r\n");
      out.write("              ");
       }
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    	\r\n");
      out.write("                    	<li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link btn btn-outline-info\" href=\"order.jsp\">Orders</a>\r\n");
      out.write("                          <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link btn btn-outline-info\" href=\"Logout?user=user\">Logout</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                   \r\n");
      out.write("                      \r\n");
      out.write("                 \r\n");
      out.write("            </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"container-fluid px-3 py-3\">\r\n");
      out.write("		");

		if (orderList == null || orderList.size() == 0) {
		
      out.write("\r\n");
      out.write("		<div class=\"container mt-5 mb-5 text-center\">\r\n");
      out.write("			<img src=\"Add-Images/empty-cart.png\" style=\"max-width: 200px;\"\r\n");
      out.write("				class=\"img-fluid\">\r\n");
      out.write("			<h4 class=\"mt-3\">Empty Orders!!!</h4>\r\n");
      out.write("		</div>\r\n");
      out.write("		");

		} else {
		
      out.write("\r\n");
      out.write("		<div class=\"container-fluid\">\r\n");
      out.write("			<table class=\"table table-hover\">\r\n");
      out.write("				<tr class=\"table-primary\" style=\"font-size: 18px;\">\r\n");
      out.write("					<th class=\"text-center\">Product</th>\r\n");
      out.write("					<th>Order ID</th>\r\n");
      out.write("					<th>Product Details</th>\r\n");
      out.write("					<th>Delivery Address</th>\r\n");
      out.write("					<th>Date/Time</th>\r\n");
      out.write("					<th>Payment Type</th>\r\n");
      out.write("					<th>Status</th>\r\n");
      out.write("					<th colspan=\"2\" class=\"text-center\">Action</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");

				for (Order order : orderList) {
					List<OrderedProduct> ordProdList = ordProdDao.getAllOrderedProduct(order.getId());
					for (OrderedProduct orderProduct : ordProdList) {
				
      out.write("\r\n");
      out.write("				<form action=\"AdminUpdateProducts?oid=");
      out.print(order.getId());
      out.write("\"\r\n");
      out.write("					method=\"post\">\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td class=\"text-center\"><img\r\n");
      out.write("							src=\"product-images\\");
      out.print(orderProduct.getImage());
      out.write("\"\r\n");
      out.write("							style=\"width: 50px; height: 50px; width: auto;\"></td>\r\n");
      out.write("						<td>");
      out.print(order.getOrderId());
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(orderProduct.getName());
      out.write("<br>Quantity: ");
      out.print(orderProduct.getQuantity());
      out.write("<br>Total\r\n");
      out.write("							Price: LKR ");
      out.print(orderProduct.getPrice() * orderProduct.getQuantity());
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(userDao.getUserName(order.getUserId()));
      out.write("<br>Mobile\r\n");
      out.write("							No. ");
      out.print(userDao.getUserPhone(order.getUserId()));
      out.write("<br>");
      out.print(userDao.getUserAddress(order.getUserId()));
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(order.getDate());
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(order.getPayementType());
      out.write("</td>\r\n");
      out.write("						<td>");
      out.print(order.getStatus());
      out.write("</td>\r\n");
      out.write("						<td><select id=\"operation\" name=\"status\" class=\"form-select\">\r\n");
      out.write("								<option>UPDATE STATUS</option>\r\n");
      out.write("								<option value=\"Order Confirmed\">Order Confirmed</option>\r\n");
      out.write("								<option value=\"Shipped\">Shipped</option>\r\n");
      out.write("								<option value=\"Out For Delivery\">Out For Delivery</option>\r\n");
      out.write("								<option value=\"Delivered\">Delivered</option>\r\n");
      out.write("						</select></td>\r\n");
      out.write("						<td>\r\n");
      out.write("							");

							if (order.getStatus().equals("Delivered")) {
							
      out.write("\r\n");
      out.write("							<button type=\"submit\" class=\"btn btn-success\">Update</button>\r\n");
      out.write("							");

							} else {
							
      out.write("\r\n");
      out.write("							<button type=\"submit\" class=\"btn btn-secondary\">Update</button> \r\n");
      out.write("							");
}
      out.write(" <br> <br>\r\n");
      out.write("							<a href=\"DeleteOrderServlet?operation=deleteOrder&oid=");
      out.print(order.getId());
      out.write("\" role=\"button\" class=\"btn btn-danger\">Remove</a>\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("						</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</form>\r\n");
      out.write("				");

				}
				}
				
      out.write("\r\n");
      out.write("			</table>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		");

		}
		
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}