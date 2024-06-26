
<%@page import="com.mypackage.model.Message"%>
<%@page import="com.mypackage.model.Admin"%>




<%
Admin activeAdmin = (Admin) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("Admin.jsp");
	return;
}
%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="includes/header.jsp"%>
<title>Admin Control Panel</title>

<style>
.card {
	width: 170px; /* Adjust the width of the card */
	height: 230px; /* Adjust the height of the card */
}

.card-img-top {
	height: 200px; /* Adjust the height of the images as needed */
	object-fit: cover; /* Ensure images cover the entire card */
	}
	
.card-title {
  text-decoration: none;
}

.card-link {
    text-decoration: none; /* Remove underline */
}


.card {
        width: 170px; /* Adjust the width of the card */
        height: 230px; /* Adjust the height of the card */
        transition: transform 0.3s;
    }

.card:hover {
        transform: scale(1.2); /* Increase the size of the card on hover */
    }

.card-img-top {
        height: 200px; /* Adjust the height of the images as needed */
        object-fit: cover; /* Ensure images cover the entire card */
    }

.card-link {
        text-decoration: none; /* Remove underline */
    }

.card-title {
        text-decoration: none; /* Remove underline */
    }



</style>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>


	<!-- admin details and welcome -->

	<div class="row">
		<div class="container text-center" id="details" style="padding-top: 30px;">
			<img src="Add-Images/admin.png" style="max-width: 180px;"
				class="img-fluid">
			<h3>
				Welcome "<%=activeAdmin.getName()%>"
			</h3>
		</div>
	</div>




	<!-- cards -->

	<div class="container" style="padding-top: 50px;">
		<div class="row">

			<!-- First Card -->
			<div class="col-md-2 mb-2">
				<a href="addproduct.jsp" class="card-link">
					<div class="card">
						<img src="Add-Images/add.png" class="card-img-top" alt="Image 1">
						<div class="card-body">
							<p class="title" style="font-family: serif; font-size: 20px;">Add Product </p>
							
						</div>
					</div>
				</a>
			</div>

			<!-- Second Card -->
			<div class="col-md-2 mb-2">
				<a href="addcategory.jsp" class="card-link">
					<div class="card">
						<img src="Add-Images/add-cat4.jpeg" class="card-img-top" alt="Image 2">
						<div class="card-body">
							<h5 class="card-title" style="font-family: serif; font-size: 20px;">Add Category</h5>
							
						</div>
					</div>
				</a>
			</div>

			<!-- third Card -->
			<div class="col-md-2 mb-2">
				<a href="admin-category.jsp" class="card-link">
					<div class="card">
						<img src="Add-Images/manage.png" class="card-img-top" alt="Image 2">
						<div class="card-body">
							<h5 class="card-title" style="font-family: serif; font-size: 19px;">Manage Category</h5>
							
						</div>
					</div>
				</a>
			</div>

			<!-- fourth Card -->
			<div class="col-md-2 mb-2">
				<a href="admin-products.jsp" class="card-link">
					<div class="card">
						<img src="Add-Images/manage-product2.png" class="card-img-top" alt="Image 2">
						<div class="card-body">
							<h5 class="card-title" style="font-family: serif; font-size: 19px;">Manage Products</h5>
							
						</div>
					</div>
				</a>
			</div>

			<!-- fifth Card -->
		   <div class="col-md-2 mb-2">
				<a href="admin-orders.jsp" class="card-link">
					<div class="card">
						<img src="Add-Images/order-manage4.png" class="card-img-top" alt="Image 2">
						<div class="card-body">
							<h5 class="card-title" style="font-family: serif; font-size: 20px;">Manage Orders</h5>
							
						</div>
					</div>
				</a>
			</div>

			<!-- sixth Card -->
			<div class="col-md-2 mb-2">
				<a href="admin-users.jsp" class="card-link">
					<div class="card">
						<img src="Add-Images/user-manage2.png"class="card-img-top" alt="Image 2">
						<div class="card-body">
							<h5 class="card-title" style="font-family: serif; font-size: 20px;">Manage Users</h5>
							
						</div>
					</div>
				</a>
			</div>



		</div>
	</div>

</body>
</html>
