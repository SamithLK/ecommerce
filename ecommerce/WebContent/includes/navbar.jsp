<link rel="stylesheet" href="css/styles.css">
<%@page import="com.mypackage.model.User"%>

<%

User user=(User) session.getAttribute("activeUser");

%>






<nav class="navbar navbar-expand-lg  bg-purple" data-bs-theme="dark" style="width: 100%;">

   
        <div class="container">
           
            <a class="navbar-brand btn" href="index.jsp" style="transition: outline 5s; text-decoration: none;" onmouseover="this.style.outline='1px solid #17a2b8';" onmouseout="this.style.outline='none';">
    <img src="about/rlk-2png.png" style="width: 50px; height: 25px; border-radius: 5px; margin-top: 0;">&nbsp;Rhythm.LK
</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <li class="nav-item" style="list-style-type: none;">
                        <a class="nav-link btn btn-outline-info" aria-current="page" href="index.jsp" style="text-decoration: none;"><i class="fas fa-home"></i></a>
                    </li>
            <!-- Search bar -->
            <form class="d-flex" style="padding-left: 30px;">
                <input class="form-control me-2 text-center" type="search" placeholder="What Are You Looking For?" aria-label="Search" style="width: 550px; background-color: white;">
                <button class="btn btn-outline-light" type="submit"><i class="fas fa-search"></i></button>
            </form>
            <!-- End of search bar -->
            
            <div class="collapse navbar-collapse justify-content-end " id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto mb-2 mb-lg-0 ">
                    
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-info" href="cart.jsp"><i class="fas fa-shopping-cart"></i></a>
                    </li>
                  
                    
                 <%   if(user==null){ %>
                   
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-info" href="login.jsp">Login</a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-info" href="LogAdmin.jsp">Admin</a>
                    </li>
                    
                     
                    
                    <li class="nav-item">
                        <a class="nav-link btn btn-outline-info" href="Register.jsp">SignUp</a>
              <%       }%>
                    
                    	
                    	<li class="nav-item">
                        <a class="nav-link btn btn-outline-info" href="order.jsp">Orders</a>
                          <li class="nav-item">
                        <a class="nav-link btn btn-outline-info" href="Logout?user=user">Logout</a>
                    </li>
                    </li>
                    
                    
                   
                      
                 
            </ul>
            </div>
        </div>
    </div>
</nav>
