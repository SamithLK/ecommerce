<%@page contentType="text/html"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mypackage.connection.DbCon"%>
<%@page import="com.mypackage.model.*"%>
<%@page import="com.mypackage.dao.ProductDao"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>

<%@include file="includes/header.jsp"%>
<%@include file="includes/css-js.jsp"%>


<title>Welcome to Ecommerce site</title>


<style type="text/css">

@import url(https://fonts.google.com/specimen/Bebas+Neue);
*
{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Bebas Neue;

}

body.body
{
    display: flex;
    justify-content: flex-end;
    align-items: flex-end;
    min-height: 100vh;
    background: #333;

}

footer
{
    position: relative;
    width: 100%;
    background: #3586ff;
    min-height: 100px;
    padding: 20px 50px;
    display: flex;
    justify-content: center;
    align-items: center ;
    flex-direction: column;

}

footer .social_media,
footer .menu
{
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 10px 0;
}

footer .social_media li,
footer .menu li
{
    list-style: none;
}

footer .social_media li a
{
    font-size: 2em;
    color: #fff;
    margin: 0 10px;
    display: inline-block;
    transition: 0.5s;
}

footer .social_media li a:hover
{
    transform: translateY(-15px);
}

footer .menu li a
{
    font-size: 1.2em;
    color: #fff;
    margin: 0 10px;
    display: inline-block;
    text-decoration: none;
    opacity: 0.75;
    word-spacing: 30px;

}

footer .menu li a:hover
{
    opacity: 1;
}

footer p
{
    color: #fff;
    text-align: center;
    margin-top: 15px;
    margin-bottom: 10px;
    font-size: 1.1em;
}

footer .wave
{
    position: absolute;
    top: -100px;
    left: 0;
    width: 100%;
    height: 100px;
    background: url(wave.png);
    background-size: 1000px 100px;
}
footer .wave#wave1
{
    z-index: 1000;
    opacity: 1;
    bottom: 0;
    animation: animateWave 4s linear infinite;
}
footer .wave#wave2
{
    z-index: 999;
    opacity: 0.5;
    bottom: 10px;
    animation: animateWave_02 4s linear infinite;
}
footer .wave#wave3
{
    z-index: 1000;
    opacity: 0.2;
    bottom: 15px;
    animation: animateWave 3s linear infinite;
}
footer .wave#wave4
{
    z-index: 999;
    opacity: 0.7;
    bottom: 20px;
    animation: animateWave_02 3s linear infinite;
}


@keyframes animateWave
{
    0%
    {
        background-position-x: 1000px;
    }
    100%
    {
        background-position-x: 0px;
    }
}

@keyframes animateWave_02
{
    0%
    {
        background-position-x: 0px;
    }
    100%
    {
        background-position-x: 1000px;
    }
}

img.img{

    position: absolute;
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 50px 0;
    border-radius: 30%;
    width:50px ;
    height: 50px;
    bottom: -100px;
    align-items: center;
    float: left;

}






</style>






<!-- Carousel Zooming Effect -->
<style type="text/css">
.carousel-item img {
	transition: transform 3s ease-in-out;
	transform-origin: center center;
}

.zoom-in {
	transform: scale(1.2);
}
</style>

<script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function() {
            const carousel = document.getElementById('carouselAutoplaying');
            const imgs = carousel.querySelectorAll('.carousel-item img');

            carousel.addEventListener('slid.bs.carousel', function() {
                imgs.forEach(function(img) {
                    img.classList.remove('zoom-in');
                });
                const activeCarouselItem = carousel.querySelector('.carousel-item.active');
                const activeImgs = activeCarouselItem.querySelectorAll('img');
                activeImgs.forEach(function(img) {
                    img.classList.add('zoom-in');
                });
            });

            // Apply zoom to the first carousel item initially
            const firstImg = carousel.querySelector('.carousel-item.active img');
            firstImg.classList.add('zoom-in');
        });
    </script>
<!-- End of Carousel Zooming Effect -->

<!-- Carousel text -->

<style type="text/css">
.carousel-caption {
	/* Align caption text to the left */
	color: white;
	position: absolute;
	right: 900px; /* Adjust right positioning as needed */
	bottom: 100px;
}

.carousel-caption h2, .carousel-caption p {
	color: inherit; /* Inherit color from .carousel-caption */
}

.carousel-caption-second {
	/* Align caption text to the right */
	color: white;
	position: absolute;
	right: 100px; /* Adjust right positioning as needed */
	bottom: 150px;
}

.carousel-caption-second h2, .carousel-caption-second p {
	color: inherit; /* Inherit color from .carousel-caption */
	font-size: 2rem;
}
</style>

<style>
.popup {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
	z-index: 999;
}

.popup.show {
	display: block;
}

.popup-content {
	text-align: center;
}

.popup-title {
	font-size: 1.5rem;
	margin-bottom: 10px;
}

.popup-message {
	font-size: 1rem;
	margin-bottom: 15px;
}

.popup-close-btn {
	background-color: green;
	color: white;
	padding: 8px 16px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
</style>

</head>



<body style="background-color: black;">
	<%@include file="includes/navbar.jsp"%>
	

	<div class="container-fluid">


		<!-- Carousel -->
		<div id="carouselAutoplaying"
			class="carousel slide carousel-dark mt-3 mb-3"
			data-bs-ride="carousel" data-bs-pause="hover="false"">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="product-images\caroselnew3.jpg" alt="..." />

					<div class="carousel-caption">
						<h2 id="typed-text-1" style="color: white; font-size: 2rem;"></h2>
						<p id="typed-text-2"
							style="color: white; font-family: 'Bebas Neue', cursive;"></p>
					</div>


					<div class="carousel-caption-second">
						<h2 style="color: white; font-family: 'Bebas Neue', cursive;">Welcome To Rhythm.LK</h2>
						<p style="color: white; font-size: 1.5rem; font-family: 'Bebas Neue', cursive;">Shop the Best Gear
						</p>
					</div>

				</div>
				<div class="carousel-item">
					<img src="product-images\caroselnew.jpg" alt="...">

				</div>
				<div class="carousel-item">
					<img src="product-images\caroselnew2.webp" alt="...">
				</div>
				<div class="carousel-item">
					<img src="product-images\carosel4.webp" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselAutoplaying" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"
					style="color: black;"></span> <span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselAutoplaying" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<!-- end of carousel -->

		<jsp:include page="products.jsp"></jsp:include>

		<!-- Banner-->
		<div class="container-fluid banner-container" style="margin-bottom: 150px;">
			<img src="product-images\banner.png" alt="Banner Image"
				style="width: 100%;" class="img-fluid">
		</div>
		<script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>
		<script>
  // Script for typed animation effect

 const typedText1Element = document.getElementById('typed-text-1');
  const typedText2Element = document.getElementById('typed-text-2');

  if (typedText1Element) {
    const typed1 = new Typed('#typed-text-1', {
      strings: ["Now Available...."],
      typeSpeed: 30, 
      backSpeed: 0, 
    });
  } else {
    console.error('Element with ID "typed-text-1" not found.');
  }

  if (typedText2Element) {
    const typed2 = new Typed('#typed-text-2', {
      strings: ["Fender American Vintage II Stratocaster Series....."],
      typeSpeed: 30,
      backSpeed: 0,
    });
  } else {
    console.error('Element with ID "typed-text-2" not found.');
  }

  // Repeat similar code for other carousel captions you want to animate
  // (replace IDs with corresponding IDs from your HTML)

</script>
		<%
		String order = (String) session.getAttribute("order");
		if (order != null) {
		%>
		<div id="order-confirmation-popup" class="popup">
			<div class="popup-content">
				<i class="fas fa-check-circle"
					style="color: green; font-size: 2rem; margin-right: 10px;"></i>
				<h2 class="popup-title">Order Placed, Thank you!</h2>
				<p class="popup-message">Your Order is Processing Now</p>
				<button class="popup-close-btn">Close</button>
			</div>
		</div>
		<script>
  const popup = document.getElementById("order-confirmation-popup");
  if (popup) {
    setTimeout(() => {
      popup.classList.add("show"); // Show popup after a delay
    }, 100); // Adjust delay as needed
    
    const closeBtn = document.querySelector(".popup-close-btn");
    closeBtn.addEventListener("click", () => {
      popup.classList.remove("show");
    });
    
    setTimeout(() => {
        popup.classList.remove("show");
      }, 5000);
    
  }
</script>

		<%
		}
		session.removeAttribute("order");
		%>
		
		
		
		
<footer>
        <div class="waves">
            <div class="wave" id="wave1"></div>
            <div class="wave" id="wave2"></div>
            <div class="wave" id="wave3"></div>
            <div class="wave" id="wave4"></div>
        </div>

        <ul class="social_media">
            <li> <a href="#"> <ion-icon name="logo-facebook"></ion-icon>
            </a> </li>
            <li> <a href="#"> <ion-icon name="logo-instagram"></ion-icon></a> </li> 
            <li> <a href="#"> <ion-icon name="logo-whatsapp"></ion-icon>
            </a> </li>
            <li> <a href="#"> <ion-icon name="logo-linkedin"></ion-icon>
            </a> </li>
            <li> <a href="#"> <ion-icon name="logo-twitter"></ion-icon></a> </li>&emsp;
            &emsp;&emsp; 
        </ul>
        <ul class="menu">
            <li><a href="index.jsp">Home&thinsp;</a></li>
            <li><a href="about/About.html">&thinsp;&thinsp;&thinsp;About</a></li>
            <li><a href="about/About.html">Services</a></li>
            <li><img src="about/rlk-2png.png" style="width: 50px; height: 50px;"> </li>
            <li><a href="about/About.html">Contact</a></li>
            <li><a href="about/About.html">Brands</a></li>
        </ul>
        <p> &reg; 2024  Rythem   Musics   |  &copy; All   Right   Reserved </p>
    </footer>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>"
		
		

</div>





 



</body>
</html>