<%@page import="com.mypackage.model.Message"%>
<%@page import="com.mypackage.model.Admin"%>
<%@page errorPage="error_exception.jsp"%>
<%@page import="com.mypackage.model.Product"%>
<%@page import="com.mypackage.model.Category"%>
<%@page import="com.mypackage.dao.CategoryDao"%>
<%@page import="com.mypackage.dao.ProductDao"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Admin activeAdmin = (Admin) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("adminlogin.jsp");
	return;
}

CategoryDao categoryDao = new CategoryDao(DbCon.getConnection());
List<Category> categoryList = categoryDao.getAllCategories();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
<%@include file="includes/css-js.jsp"%>
</head>
<body>
	
	<%@include file="includes/navbar.jsp"%>

	
	<%
	int cid = Integer.parseInt(request.getParameter("cid"));
	Category category = categoryDao.getCategoryById(cid);
	%>
	<div class="container mt-5">
		<div class="row row-cols-1 row-cols-md-1 offset-md-2">
			<div class="col">
				<div class="card w-75">
					<div class="card-header text-center">
						<h3>Edit Category</h3>
					</div>
					<form action="AdminUpdateProducts?cid=<%=cid%>" method="post"
						enctype="multipart/form-data">
						<div class="card-body">
							<input type="hidden" name="operation" value="updateCategory">
							<div class="mb-3">
								<label class="form-label"><b>Category Name</b></label> <input
									type="text" name="category_name" value="<%=category.getCategoryName()%>" class="form-control" >
							</div>
							<div class="mb-3">
								<label class="form-label"><b>Category
										Image</b></label><input class="form-control" type="file" name="category_img">
							</div>
							<div class="mb-3">
								<label class="form-label"><b>Uploaded Image:&nbsp;</b></label><%=category.getCategoryImage()%>&emsp;<img
									src="product-images\<%=category.getCategoryImage()%>"
									style="width: 80px; height: 80px; width: auto;">
								<input type="hidden" name="image" value="<%=category.getCategoryImage()%>">
							</div>
						</div>
						<div class="card-footer text-center">
							<button type="submit" class="btn btn-lg btn-primary me-3">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end-->
</body>
</html>