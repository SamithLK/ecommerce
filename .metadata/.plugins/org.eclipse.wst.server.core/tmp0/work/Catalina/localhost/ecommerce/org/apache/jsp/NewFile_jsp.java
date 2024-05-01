/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-04-20 08:37:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.mypackage.model.Message;
import com.mypackage.connection.DbCon;
import com.mypackage.model.Product;
import com.mypackage.dao.ProductDao;
import com.mypackage.model.Cart;
import com.mypackage.dao.CartDao;
import java.util.List;
import com.mypackage.model.User;
import com.mypackage.model.Message;

public final class NewFile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/includes/alert_msg.jsp", Long.valueOf(1713264957983L));
    _jspx_dependants.put("/includes/css-js.jsp", Long.valueOf(1713262393428L));
    _jspx_dependants.put("/includes/navbar.jsp", Long.valueOf(1713601089725L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(8);
    _jspx_imports_classes.add("com.mypackage.model.Cart");
    _jspx_imports_classes.add("com.mypackage.dao.CartDao");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.mypackage.model.Product");
    _jspx_imports_classes.add("com.mypackage.model.Message");
    _jspx_imports_classes.add("com.mypackage.connection.DbCon");
    _jspx_imports_classes.add("com.mypackage.dao.ProductDao");
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

User activeUser = (User) session.getAttribute("activeUser");
if (activeUser == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("login.jsp");
	return;  
}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Shopping cart</title>\r\n");
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
      out.write("<style type=\"text/css\">\r\n");
      out.write(".qty {\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("	padding: 3px 6px;\r\n");
      out.write("	width: 46px;\r\n");
      out.write("	height: 32px;\r\n");
      out.write("	border-radius: 2px;\r\n");
      out.write("	background-color: #fff;\r\n");
      out.write("	border: 1px solid #c2c2c2;\r\n");
      out.write("	margin: 0 5px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!--navbar -->\r\n");
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
      out.write("<nav class=\"navbar navbar-expand-lg  bg-purple\" data-bs-theme=\"dark\">\r\n");
      out.write("   \r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">Rhythm.LK</a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("            </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse justify-content-end \" id=\"navbarSupportedContent\">\r\n");
      out.write("                <ul class=\"navbar-nav mr-auto mb-2 mb-lg-0 \">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link \" aria-current=\"page\" href=\"index.jsp\">Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"NewFile.jsp\">Cart</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                  \r\n");
      out.write("                    \r\n");
      out.write("                 ");
   if(user==null){ 
      out.write("\r\n");
      out.write("                   \r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"login.jsp\">Login</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                     \r\n");
      out.write("                    \r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"Register.jsp\">SignUp</a>\r\n");
      out.write("              ");
       }
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    	\r\n");
      out.write("                    	<li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"orders.jsp\">Orders</a>\r\n");
      out.write("                          <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"Logout?user=user\">Logout</a>\r\n");
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
      out.write("	");

	float totalPrice = 0;
	CartDao cartDao = new CartDao(DbCon.getConnection());
	List<Cart> listOfCart = cartDao.getCartListByUserId(user.getUserId());
	if (listOfCart == null || listOfCart.size() == 0) {
	
      out.write("\r\n");
      out.write("	<div class=\"container text-center py-5 px-5\">\r\n");
      out.write("		<img src=\"Images/empty-cart.png\" style=\"max-width: 250px;\"\r\n");
      out.write("			class=\"img-fluid\">\r\n");
      out.write("		<h4 class=\"mt-5\">Your cart is empty!</h4>\r\n");
      out.write("		<p>Add items to it now.</p>\r\n");
      out.write("		<a href=\"index.jsp\" class=\"btn btn-primary btn-lg\" role=\"button\"\r\n");
      out.write("			aria-disabled=\"true\">Shop Now</a>\r\n");
      out.write("	</div>\r\n");
      out.write("	");

	} else {
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"container mt-5\">\r\n");
      out.write("		");
      out.write("   \r\n");
      out.write("\r\n");
      out.write(" \r\n");

Message messg = (Message) session.getAttribute("message");
if (messg != null) {

      out.write("\r\n");
      out.write("<div class=\"alert ");
      out.print(messg.getCssClass());
      out.write("\" role=\"alert\" id=\"alert\">\r\n");
      out.write("	");
      out.print(messg.getMessage());
      out.write("\r\n");
      out.write("</div>\r\n");

session.removeAttribute("message");
}

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	setTimeout(function() {\r\n");
      out.write("		$('#alert').alert('close');\r\n");
      out.write("	}, 5000);\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("		<div class=\"card px-3 py-3\">\r\n");
      out.write("			<table class=\"table table-hover\">\r\n");
      out.write("				<thead>\r\n");
      out.write("					<tr class=\"table-primary text-center\" style=\"font-size: 18px;\">\r\n");
      out.write("						<th>Item</th>\r\n");
      out.write("						<th>Item Name</th>\r\n");
      out.write("						<th>Price</th>\r\n");
      out.write("						<th>Quantity</th>\r\n");
      out.write("						<th>Total price</th>\r\n");
      out.write("						<th>Remove</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</thead>\r\n");
      out.write("				<tbody>\r\n");
      out.write("					");

					ProductDao productDao = new ProductDao(DbCon.getConnection());
					for (Cart c : listOfCart) {
						Product prod = productDao.getProductsByProductId(c.getProductId());						
					
      out.write("\r\n");
      out.write("					<tr class=\"text-center\">\r\n");
      out.write("						<td><img src=\"Product_imgs\\");
      out.print(prod.getProductImages());
      out.write("\"\r\n");
      out.write("							style=\"width: 50px; height: 50px; width: auto;\"></td>\r\n");
      out.write("						<td class=\"text-start\">");
      out.print(prod.getProductName());
      out.write("</td>\r\n");
      out.write("						<td>&#8377;");
      out.print(prod.getProductPriceAfterDiscount());
      out.write("</td>\r\n");
      out.write("						<td><a\r\n");
      out.write("							href=\"CartOperationServlet?cid=");
      out.print(c.getCartId());
      out.write("&opt=1\"\r\n");
      out.write("							role=\"button\" class=\"btn btn-light\"\r\n");
      out.write("							style=\"border-radius: 50%; font-size: 8px;\"> <i\r\n");
      out.write("								class=\"fa-regular fa-plus fa-2xl\"></i>\r\n");
      out.write("						</a>\r\n");
      out.write("						<div class=\"qty\">");
      out.print(c.getQuantity());
      out.write("</div>\r\n");
      out.write("							");
if(c.getQuantity() > 1){ 
      out.write("\r\n");
      out.write("							<a href=\"CartOperationServlet?cid=");
      out.print(c.getCartId());
      out.write("&opt=2\"\r\n");
      out.write("							role=\"button\" class=\"btn btn-light\" id=\"qtyDesc\"\r\n");
      out.write("							style=\"border-radius: 50%; font-size: 8px;\"> <i\r\n");
      out.write("								class=\"fa-solid fa-minus fa-2xl\"></i></a>\r\n");
      out.write("							");
}else{ 
      out.write("\r\n");
      out.write("							<a href=\"CartOperationServlet?cid=");
      out.print(c.getCartId());
      out.write("&opt=2\"\r\n");
      out.write("							role=\"button\" class=\"btn btn-light disabled\" id=\"qtyDesc\"\r\n");
      out.write("							style=\"border-radius: 50%; font-size: 8px;\"> <i\r\n");
      out.write("								class=\"fa-solid fa-minus fa-2xl\"></i></a>\r\n");
      out.write("							");
} 
      out.write("\r\n");
      out.write("						</td>\r\n");
      out.write("\r\n");
      out.write("						<td>&#8377;");
      out.print(c.getQuantity() * prod.getProductPriceAfterDiscount());
      out.write("</td>\r\n");
      out.write("						<td><a\r\n");
      out.write("							href=\"CartOperationServlet?cid=");
      out.print(c.getCartId());
      out.write("&opt=3\"\r\n");
      out.write("							class=\"btn btn-secondary\" role=\"button\">Remove</a></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					");

					totalPrice += c.getQuantity() * prod.getProductPriceAfterDiscount();
					}
					
      out.write("\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td class=\"text-end\" colspan=\"8\"><h4 class='pe-5'>\r\n");
      out.write("								Total Amount : &#8377;\r\n");
      out.write("								");
      out.print(totalPrice);
      out.write("</h4></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</tbody>\r\n");
      out.write("			</table>\r\n");
      out.write("			<div class=\"text-end\">\r\n");
      out.write("				<a href=\"products.jsp\" class=\"btn btn-outline-primary\" role=\"button\"\r\n");
      out.write("					aria-disabled=\"true\">Continue Shopping</a>&nbsp; \r\n");
      out.write("					<a href=\"checkout.jsp\" id=\"checkout-btn\"\r\n");
      out.write("					class=\"btn btn-outline-primary\" role=\"button\" aria-disabled=\"true\">Checkout</a>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		$(document).ready(function(){\r\n");
      out.write("			$('#checkout-btn').click(function(){\r\n");
      out.write("			");

			session.setAttribute("totalPrice", totalPrice);
			session.setAttribute("from", "cart");
			
      out.write("	\r\n");
      out.write("			});\r\n");
      out.write("		});\r\n");
      out.write("	</script>\r\n");
      out.write("	\r\n");
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