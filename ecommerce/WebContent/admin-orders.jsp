<%@page import="com.mypackage.model.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page errorPage="error_exception.jsp"%>
<%@page import="com.mypackage.dao.UserDao"%>
<%@page import="com.mypackage.model.Product"%>
<%@page import="com.mypackage.model.Product"%>
<%@page import="com.mypackage.model.Admin"%>
<%@page import="com.mypackage.model.Order"%>
<%@page import="com.mypackage.model.OrderedProduct"%>
<%@page import="com.mypackage.dao.OrderDao"%>
<%@page import="com.mypackage.dao.OrderedProductDao"%>
<%@page import="com.mypackage.dao.ProductDao"%>
<%@page import="com.mypackage.dao.CategoryDao"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import="java.util.List"%>

<%
OrderDao orderDao = new OrderDao(DbCon.getConnection());
OrderedProductDao ordProdDao = new OrderedProductDao(DbCon.getConnection());
List<Order> orderList = orderDao.getAllOrder();
UserDao userDao = new UserDao(DbCon.getConnection());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Order's</title>
<%@include file="includes/css-js.jsp"%>
</head>
<body>

	<%@include file="includes/navbar.jsp"%>



	<div class="container-fluid px-3 py-3">
		<%
		if (orderList == null || orderList.size() == 0) {
		%>
		<div class="container mt-5 mb-5 text-center">
			<img src="Add-Images/empty-cart.png" style="max-width: 200px;"
				class="img-fluid">
			<h4 class="mt-3">Empty Orders!!!</h4>
		</div>
		<%
		} else {
		%>
		<div class="container-fluid">
			<table class="table table-hover">
				<tr class="table-primary" style="font-size: 18px;">
					<th class="text-center">Product</th>
					<th>Order ID</th>
					<th>Product Details</th>
					<th>Delivery Address</th>
					<th>Date/Time</th>
					<th>Payment Type</th>
					<th>Status</th>
					<th colspan="2" class="text-center">Action</th>
				</tr>
				<%
				for (Order order : orderList) {
					List<OrderedProduct> ordProdList = ordProdDao.getAllOrderedProduct(order.getId());
					for (OrderedProduct orderProduct : ordProdList) {
				%>
				<form action="AdminUpdateProducts?oid=<%=order.getId()%>"
					method="post">
					<tr>
						<td class="text-center"><img
							src="product-images\<%=orderProduct.getImage()%>"
							style="width: 50px; height: 50px; width: auto;"></td>
						<td><%=order.getOrderId()%></td>
						<td><%=orderProduct.getName()%><br>Quantity: <%=orderProduct.getQuantity()%><br>Total
							Price: LKR <%=orderProduct.getPrice() * orderProduct.getQuantity()%></td>
						<td><%=userDao.getUserName(order.getUserId())%><br>Mobile
							No. <%=userDao.getUserPhone(order.getUserId())%><br><%=userDao.getUserAddress(order.getUserId())%></td>
						<td><%=order.getDate()%></td>
						<td><%=order.getPayementType()%></td>
						<td><%=order.getStatus()%></td>
						<td><select id="operation" name="status" class="form-select">
								<option>UPDATE STATUS</option>
								<option value="Order Confirmed">Order Confirmed</option>
								<option value="Shipped">Shipped</option>
								<option value="Out For Delivery">Out For Delivery</option>
								<option value="Delivered">Delivered</option>
						</select></td>
						<td>
							<%
							if (order.getStatus().equals("Delivered")) {
							%>
							<button type="submit" class="btn btn-success">Update</button>
							<%
							} else {
							%>
							<button type="submit" class="btn btn-secondary">Update</button> 
							<%}%> <br> <br>
							<a href="DeleteOrderServlet?operation=deleteOrder&oid=<%=order.getId()%>" role="button" class="btn btn-danger">Remove</a>

	
						</td>
					</tr>
				</form>
				<%
				}
				}
				%>
			</table>

		</div>
		<%
		}
		%>
	</div>
</body>
</html>