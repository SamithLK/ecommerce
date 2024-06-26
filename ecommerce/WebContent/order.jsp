
<%@page import="com.mypackage.model.Message"%>
<%@page import="com.mypackage.model.OrderedProduct"%>
<%@page import="com.mypackage.model.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.mypackage.dao.OrderedProductDao"%>
<%@page import="com.mypackage.dao.OrderDao"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import="com.mypackage.model.User"%>
<%@page errorPage="error_exception.jsp"%>



<%
User u2 = (User) session.getAttribute("activeUser");
if (u2 == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("login.jsp");
	return;  
}
OrderDao orderDao = new OrderDao(DbCon.getConnection());
OrderedProductDao ordProdDao = new OrderedProductDao(DbCon.getConnection());

List<Order> orderList = orderDao.getAllOrderByUserId(u2.getUserId());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Orders</title>
    <%@include file="includes/css-js.jsp"%>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
<div class="container-fluid px-3 py-3">
	<%
	if (orderList == null || orderList.size() == 0) {
	%>
	<div class="container mt-5 mb-5 text-center">
     <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
      <img src="Add-Images/no-order.jpg" style="max-width: 200px;" class="img-fluid">
      <h2 class="mt-3"><center>No Orders Found</center></h2>
    You haven't made any purchases yet!!
  <button type="button" onclick="window.open('index.jsp')" class="btn btn-success">Start Shopping</button>

	</div>

</div>

</div>


	<%
	} else {
	%>
	<h4><center>My Orders</center></h4>
	<hr>
	<div class="container">
		<table class="table table-hover">
			<tr class="text-center table-secondary">
			  <th>Product</th>
			  <th>Order ID</th>
			  <th>Name</th>
			  <th>Quantity</th>
			  <th>Total Price</th>
			  <th>Date and Time</th>
			  <th>Payment Type</th>
			  <th>Status</th>
			</tr>
			<%
			for (Order order : orderList) {
				List<OrderedProduct> ordProdList = ordProdDao.getAllOrderedProduct(order.getId());
				for (OrderedProduct orderProduct : ordProdList) {
			%>
			<tr class="text-center">
				<td><img src="product-images\<%=orderProduct.getImage()%>"
					style="width: 40px; height: 40px; width: auto;"></td>
				<td class="text-start"><%=order.getOrderId()%></td>
				<td class="text-start"><%=orderProduct.getName()%></td>
				<td><%=orderProduct.getQuantity()%></td>
				<td><%=orderProduct.getPrice() * orderProduct.getQuantity()%></td>
				<td><%=order.getDate()%></td>
				<td><%=order.getPayementType()%></td>
				<td class="fw-semibold" style="color: green;"><%=order.getStatus()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
		
		<div style="text-align: center; margin-top: 50px;">
  <form action="index.jsp">
    <button type="submit" style="padding: 10px 20px; background-color: #28a745; color: #fff; border: none; border-radius: 5px;"><i class="fas fa-home"></i>&nbsp;Back To HomePage</button>
  </form>
</div>
	</div>
	<%
	}
	%>
</div>

</body>
</html>
