<%@page import="com.mypackage.model.Message"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import="com.mypackage.model.User"%>
<%@page import="com.mypackage.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.mypackage.dao.CartDao"%>
<%@page errorPage="error_exception.jsp"%>
<%
User activeUser = (User) session.getAttribute("activeUser");
if (activeUser == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("login.jsp");
	return;
}
String from = (String) session.getAttribute("from");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<%@include file="includes/css-js.jsp"%>
</head>
<body>
	<!--navbar -->
	<%@include file="includes/navbar.jsp"%>

	<div class="container  mt-5"
		style="font-size: 17px; text-align: center; margin-left: 250px; margin-right: auto;">
		<div class="row">

			<!-- Delivery Address Container -->
			<div class="col-md-8">
				<div class="card">
					<div class="container px-3 py-4">
						<div class="card">

							<div class="container-fluid text-white"
								style="background-color: #7e57c2;">
								<h4>Delivery Address</h4>
							</div>
						</div>
						<br>
						<div class="mt-3 mb-3">
							<h5><%=user.getUserName()%>
								&nbsp;
								<%=user.getUserPhone()%></h5>
							<%
							StringBuilder str = new StringBuilder();
							str.append(user.getUserAddress() + ", ");
							str.append(user.getUserCity() + ", ");
							str.append(user.getUserCity() + ", ");
							str.append(user.getUserPincode());
							out.println(str);
							%>
							<br> <br>
							<div>
								<div style="margin-left: 30px; margin-right: auto;">
									<button type="button" class="btn btn-outline-info"
										data-bs-toggle="modal" data-bs-target="#exampleModal">
										Change Address</button>
								</div>
							</div>
						</div>
					</div>
					<hr>
					<br>


					<!-- Form -->

					<div class="container">
						<form action="OrderOperationServlet" method="post">
							<div class="card">
								<div class="container-fluid text-white"
									style="background-color: #7e57c2;">
									<h4>Payment Options</h4>
								</div>
							</div>
							<br>




							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="paymentMode"
									id="creditCard" value="Credit Card" required> <label
									class="form-check-label" for="creditCard">Credit</label>
							</div>

							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="paymentMode"
									id="debitCard" value="Debit Card" required> <label
									class="form-check-label" for="debitCard">Debit</label>
							</div>

							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="paymentMode"
									id="atmCard" value="Cash-On-Delivery" required> <label
									class="form-check-label" for="atmCard">COD</label>
							</div>


							<div class="mb-3">


								<input class="form-control mt-3" type="number"
									placeholder="Card Number" name="cardno">
								<div class="row gx-5">
									<div class="col mt-3">
										<input class="form-control" type="number"
											placeholder="Enter CVV" name="cvv">
									</div>
									<div class="col mt-3">
										<input class="form-control" type="text" placeholder="MM/YY">
									</div>
								</div>
								<input class="form-control mt-3" type="text"
									placeholder="Card holder name" name="name">
							</div>

							<!-- Total Price Details Container -->

							<div>
								<div class="card">
									<div class="container px-3 py-3">

										<div class="container-fluid text-white"
											style="background-color: #7e57c2;">
											<h4>Price Details</h4>
										</div>


										<%
										if (from.trim().equals("cart")) {
											CartDao cartDao = new CartDao(DbCon.getConnection());
											int totalProduct = cartDao.getCartCountByUserId(user.getUserId());
											float totalPrice = (float) session.getAttribute("totalPrice");
										%>
										<table class="table table-borderless">
											<tr>
												<td>Total Items</td>
												<td><%=totalProduct%></td>
											</tr>
											<tr>
												<td>Sub Total</td>
												<td>LKR  <%=totalPrice%></td>
											</tr>
											<tr>
												<td>Shipping Charges</td>
												<td>LKR  40</td>
											</tr>
											<tr>
												<td>Logistics Charges</td>
												<td>LKR  29</td>
											</tr>
											<tr>
												<td><h5>Total Price :</h5></td>
												<td><h5>
														LKR 
														<%=totalPrice + 69%></h5></td>
											</tr>
										</table>
										<%
										} else {
										ProductDao productDao = new ProductDao(DbCon.getConnection());
										int pid = (int) session.getAttribute("pid");
										float price = productDao.getProductPriceById(pid);
										%>
										<table class="table table-borderless">
											<tr>
												<td>Total Items</td>
												<td>1</td>
											</tr>
											<tr>
												<td>Sub Total</td>
												<td>LKR <%=price%></td>
											</tr>
											<tr>
												<td>Shipping Charges</td>
												<td>LKR 40</td>
											</tr>
											<tr>
												<td>Logistic Charges</td>
												<td>LKR 29</td>
											</tr>
											<tr>
												<td><h5>Total Price :</h5></td>
												<td><h5>
														LKR
														<%=price + 69%></h5></td>
											</tr>
										</table>
										<%
										}
										%>
										<div
											style="font-size: 17px; margin-left: 30px; margin-right: auto;">
											<button type="submit"
												class="btn btn-lg btn-outline-success mt-3">Place
												Order</button>


										</div>


									</div>
								</div>
							</div>
						</form>
					</div>




				</div>
			</div>
		</div>



	</div>

	<!-- End of Form -->


	<!--Change Address Model -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Change
						Address</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<form action="UpdateUserServlet" method="post">
					<input type="hidden" name="operation" value="changeAddress">
					<div class="modal-body mx-3">
						<div class="mt-2">
							<label class="form-label fw-bold">Address</label>
							<textarea name="user_address" rows="3"
								placeholder="Enter Address(Area and Street))"
								class="form-control" required></textarea>
						</div>
						<div class="mt-2">
							<label class="form-label fw-bold">City</label> <input
								class="form-control" type="text" name="city"
								placeholder="City/District/Town" required>
						</div>
						<div class="mt-2">
							<label class="form-label fw-bold">Pin Code</label> <input
								class="form-control" type="number" name="pincode"
								placeholder="Pincode" maxlength="6" required>
						</div>
						<div class="mt-2">
							<label class="form-label fw-bold">State</label> <select
								name="state" class="form-select">
								<option selected>--Select State--</option>
								<option value="Western">Western</option>
								<option value="Southern">Southern</option>
								<option value="Northern">Northern</option>

							</select>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end model -->

</body>
</html>