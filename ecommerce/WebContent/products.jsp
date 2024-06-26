<%@page import="java.util.List"%>
<%@page import="com.mypackage.connection.DbCon" %>
<%@page import="com.mypackage.model.*" %>
<%@page import="com.mypackage.dao.ProductDao" %>
<%@page import="java.util.List" %>

<%

//Retrieving user and initializing DAO objects
User u = (User) session.getAttribute("activeUser");

ProductDao productDao = new ProductDao(DbCon.getConnection());

//Retrieving product list
List<Product> prodList = productDao.getAllProducts();
String message = "<span style=\"color: white;\">All Products</span>";




%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Products</title>
    <style>
        /* CSS styles */
    </style>
</head>
<body style="background-color: #f0f0f0;">
<h4 class="text-center mt-2"><%=message%></h4>
<div class="container-fluid my-3 px-5">
    <div class="row row-cols-1 row-cols-md-4 g-3">
        <% for (Product p : prodList) { %>
            <div class="col">
                <div class="card h-100 px-2 py-2">
                    <div class="container text-center">
                        <h5 class="card-title text-center">
   <%= p.getProductName() %>
   <img src="product-images\<%= p.getProductImages() %>" class="card-img-top m-2" style="max-width: 100%; max-height: 200px; width: auto;">
</h5>

                        <div class="container text-center">
                           
                            <span class="product-price">LKR <%=p.getProductPrice()%></span>&ensp;
                            <span class="product-discount"><%=p.getProductDiscount()%>&#37; off</span>
                        </div>
                        <div class="container text-center mb-2 mt-2"> 
                            <button type="button"
                                    onclick="window.open('viewProduct.jsp?pid=<%=p.getProductId()%>', '_self')"
                                    class="btn btn-primary text-white">View Details</button>
                                   
                        </div>
                                    
                                    
                        
                    </div>
                </div>
            </div>
        <% } %>
    </div>
</div>
</body>
</html>

