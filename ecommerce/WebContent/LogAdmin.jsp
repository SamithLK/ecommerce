<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mypackage.model.*"%>



<html>
<head>
<%@include file="includes/header.jsp"%>
<%@include file="includes/css-js.jsp"%>
 


<title>login Admin</title>

</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	
	

	<div class="container-fluid">
		<div class="row mt-5">

			<div class="col-md-4 offset-md-4">
				<div class="card">

					<div class="card-body px-5">
						<div class="container text-center">
							<img src="Add-Images/admin-login.png" style="max-width: 100px;"
								class="img-fluid">
						</div>

						<h3 class="text-center">Admin Login</h3>
						<%@include file="includes/alert_msg.jsp" %>
						<!--login-form-->
						<form id="login-form" action="LoginServlet" method="post">
							<input type="hidden" name="login" value="admin">
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									name="email" placeholder="Email address"
									class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									type="password" name="password"
									placeholder="Enter your password" class="form-control" required>
							</div>
							<div id="login-btn" class="container text-center">
								<button type="submit" class="btn btn-outline-success me-3">Login</button>
								<button type="reset" class="btn btn-outline-danger me-3">Reset</button>
							</div>
						</form>

						<div class="mt-3 text-center">
							<p style="font-size: smaller;">
								Not Admin?Log In as a user <a href="login.jsp"
									style="font-size: smaller;">Sign Up</a>
							</p>

						</div>


					</div>

				</div>




			</div>



		</div>


	</div>






</body>
</html>
