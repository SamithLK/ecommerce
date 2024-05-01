
<%@page import="com.mypackage.model.Message"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import="com.mypackage.dao.UserDao"%>
<%@page import="com.mypackage.dao.UserDao"%>
<%@page import="com.mypackage.model.Admin"%>
<%@page import="com.mypackage.model.User "%>
<%@page errorPage="error_exception.jsp"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User's</title>
<%@include file="includes/css-js.jsp"%>
</head>
<body>
	<!--navbar -->
	<%@include file="includes/navbar.jsp"%>

	<div class="container-fluid px-5 py-3">
	<%@include file="includes/alert_msg.jsp"%>
		<table class="table table-hover table-bordered">
			<tr class="text-center table-info" style="font-size: 18px;">
				<th>User Name</th>
				<th>Email</th>
				<th>Phone No.</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Register Date</th>
				<th>Action</th>
			</tr>
			<%
			UserDao userDao = new UserDao(DbCon.getConnection());
			List<User> userList = userDao.getAllUser();
			for (User u : userList) {
			%>
			<tr>
				<td><%=u.getUserName()%></td>
				<td><%=u.getUserEmail()%></td>
				<td><%=u.getUserPhone()%></td>
				<td><%=u.getUserGender()%></td>
				<td><%=userDao.getUserAddress(u.getUserId())%></td>
				<td><%=u.getDateTime()%></td>
				<td><a href="UpdateUserServlet?operation=deleteUser&uid=<%=u.getUserId()%>" role="button" class="btn btn-danger">Remove</a></td>
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
	</div>
</body>
</html>
