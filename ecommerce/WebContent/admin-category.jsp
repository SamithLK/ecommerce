<%@page import="com.mypackage.model.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page errorPage="error_exception.jsp"%>
<%@page import="com.mypackage.dao.UserDao"%>
<%@page import="com.mypackage.model.Product"%>
<%@page import="com.mypackage.model.Category"%>
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
CategoryDao categoryDao = new CategoryDao(DbCon.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Categories</title>
<%@include file="includes/css-js.jsp"%>
</head>
<body>
	
	<%@include file="includes/navbar.jsp"%>

	<!-- Category -->
	<div class="container mt-3">
	<%@include file="includes/alert_msg.jsp"%>
		<table class="table table-hover" style="border: 1px solid black;">
			<tr class="table-info text-center" style="font-size: 20px;">
				<th>Image</th>
				<th>Category Name</th>
				<th>Action</th>
			</tr>
			<%
			List<Category> categoryList = categoryDao.getAllCategories();
			for (Category c : categoryList) {
			%>
			<tr class="text-center">
				<td><img src="product-images\<%=c.getCategoryImage()%>"
					style="width: 60px; height: 60px; width: auto;"></td>
				<td><%=c.getCategoryName()%></td>
				<td><a href="admin-category-update.jsp?cid=<%=c.getCategoryId()%>" role="button" class="btn btn-secondary"><i class="fas fa-cog"></i>&nbsp;Update</a>&emsp;<a
					href="AdminUpdateProducts?cid=<%=c.getCategoryId()%>&operation=deleteCategory"
					class="btn btn-danger" role="button"><i class="fas fa-trash-alt"></i>&nbsp;Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<div style="text-align: center; margin-top: 50px;">
  <form action="Admin.jsp">
    <button type="submit" style="padding: 10px 20px; background-color: #28a745; color: #fff; border: none; border-radius: 5px;"><i class="fas fa-user"></i>&nbsp;Back To Admin Dashboard</button>
  </form>
	</div>

</body>
</html>