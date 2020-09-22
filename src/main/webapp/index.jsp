<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>C-SHOP</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Hind:400,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet" href="css/slick.css" />
<link type="text/css" rel="stylesheet" href="css/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet" href="css/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<!-- Heder & navbar -->
	<jsp:include page="pageParts/HeadeNavbar.jsp"></jsp:include>
	<!-- /Heder & navbar -->

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	<%@ page isELIgnored="false"%>
	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<form id="checkout-form" action="CercaAutoController" method="post">
					<div class="col-md-3"></div>

					<div class="col-md-6">
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Cerca la tua auto</h3>
							</div>
							<div class="form-group">
								<p class="title">Marca</p>
								<select class="input" id="marche" name="marche" required>
									<option value="null">----</option>
								</select>
							</div>

							<div class="form-group">
								<p class="title">Modello</p>
								<select class="input" name="Modelli" id="modelli"
									disabled="disabled" required >
									<option value="null">----</option>
								</select>
							</div>

							<div class="form-group">
								<p class="title">Prezzo:</p>
								<!--  <div id="price-slider" ></div> -->
								<input class="input" type="number" id="prezzoMax"
									name="PrezzoMax" placeholder="Scrivi il prezzo massimo "
									min="0" step="1" required >
							</div>

							<!-- 	<div class="form-group">
								<p class="title">Anno di immatricolazione massimo</p>
								<input class="input"  type="number"  name="annoImmatr" placeholder="Scrivi l'anno di immatricolazione" min="1900" step="1" required autofocus>
							</div>	-->

							<div class="form-group">
								<button class="primary-btn" id="cerca5" onclick='cont()'>Cerca</button>
							</div>
							
							
						</div>
					</div>
				</form>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- section-title -->
				<div class="col-md-12">
					<div class="section-title">
						<h2 class="title">Aste del giorno</h2>
						<div class="pull-right">
							<div class="product-slick-dots-1 custom-dots"></div>
						</div>
					</div>
				</div>
				<!-- /section-title -->

				
				

				<!-- Product Slick -->
				<div class="container">
					<div class="row">
						<div id="product-slick-1" class="product-slick col-md-12">
						
						<c:forEach items="${aste}" var="aste" varStatus="ind">
							
								<!-- Product Single -->
							<div class="product product-single">
								<div class="product-thumb">
									<!-- <div class="product-label">
										<span>New</span> <span class="sale">-20%</span>
									</div>-->
									<!--  <ul class="product-countdown">
										<li><span>00 H</span></li>
										<li><span>00 M</span></li>
										<li><span>00 S</span></li>
									</ul>-->
									<a class="main-btn quick-view"  href="CaricaAstaController?idAsta=${aste.id_asta}">
										<i class="fa fa-search-plus"></i> Visualizza
									</a>
									 
									<img src="imageAuto/${path[ind.index]}" alt="">

								</div>
								<div class="product-body">
									<h3 class="product-price">
										Base asta: &euro; ${aste.baseAsta}
									</h3>
									<div class="product-rating">
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star-o empty"></i>
									</div>
									<h2 class="product-name">
										<a > Modello: ${model[ind.index]} </a>
									</h2>
									<div class="product-btns">
										<a class="primary-btn" href="CaricaAstaController?idAsta=${aste.id_asta}">
											<i class="fa fa-shopping-cart"></i> Visualizza Asta
										</a>
									</div>
								</div>
							</div>
							<!-- /Product Single -->
							
							
							</c:forEach>							
						</div>
					</div>
				</div>
				<!-- /Product Slick -->
			</div>
			<!-- /row -->


		</div>
		<!-- /container -->
	</div>
	<!-- /section -->
	
	<script>
	
	function cont(){
		var a = document.getElementById('modelli');
		if(a.disabled == true){
			alert("Selezionare Modello!");	
			return false;
		}else
			return true;
	}
	
	
	
	
	
	</script>


	<!-- FOOTER -->
	<jsp:include page="pageParts/Footer.jsp"></jsp:include>
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/main.js"></script> 

</body>

</html>