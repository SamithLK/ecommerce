<%@page import="com.mypackage.model.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page errorPage="error_exception.jsp"%>
<%@page import="com.mypackage.dao.UserDao"%>
<%@page import="com.mypackage.model.Product"%>
<%@page import="com.mypackage.model.Product"%>
<%@page import="com.mypackage.model.Admin"%>
<%@page import="com.mypackage.dao.ProductDao"%>
<%@page import="com.mypackage.dao.CategoryDao"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import= "java.util.List"%>


<%
Admin activeAdmin = (Admin) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
	Message message = new Message("Not Login As Admin.Please Login!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("LogAdmin.jsp");
	return;
}
UserDao userDao = new UserDao(DbCon.getConnection());
ProductDao productDao = new ProductDao(DbCon.getConnection());
CategoryDao catDao = new CategoryDao(DbCon.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Products Page</title>
<%@include file="includes/css-js.jsp"%>
</head>
<body>
	
	<%@include file="includes/navbar.jsp"%>

	
	<div class="container-fluid mt-3">
		<%@include file="includes/alert_msg.jsp"%>
		<table class="table table-hover">
			<tr class="table-primary text-center" style="font-size: 20px;">
				<th>Product Image</th>
				<th>Product Name</th>
				
				<th>Price</th>
				<th class="text-start">Quantity</th>
				<th class="text-start">Discount</th>
				<th>Action</th>
			</tr>
			
			<%
			List<Product> productList = productDao.getAllProducts();
			for (Product prod : productList) {
				String category = catDao.getCategoryName(prod.getCategoryId());
			%>
			<tr class="text-center">
				<td><img src="product-images\<%=prod.getProductImages()%>"
					style="width: 60px; height: 60px; width: auto;"></td>
				<td class="text-start"><%=prod.getProductName()%></td>
				
				<td>LKR <%=prod.getProductPrice()%></td>
				<td><%=prod.getProductQunatity()%></td>
				<td><%=prod.getProductDiscount()%>%</td>
				<td><a href="admin-products-update.jsp?pid=<%=prod.getProductId()%>" role="button" class="btn btn-info"><i class="fas fa-pencil-alt"></i>&nbsp;Edit</a>&emsp;<a
					href="AdminUpdateProducts?pid=<%=prod.getProductId()%>&operation=deleteProduct"
					class="btn btn-danger" role="button"><i class="fas fa-trash-alt"></i>&nbsp;Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>