<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Prodotti</title>

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
				<!-- ASIDE -->
				<div id="aside" class="col-md-2">
				</div>

				<!-- MAIN -->
				<div id="main" class="col-md-8">
					<!-- store top filter 
					<div class="store-filter clearfix">
						<div class="pull-left">
							<div class="row-filter">
								<a href="#"><i class="fa fa-th-large"></i></a> <a href="#"
									class="active"><i class="fa fa-bars"></i></a>
							</div>
							<div class="sort-filter">
								<span class="text-uppercase">Sort By:</span> <select
									class="input">
									<option value="0">Position</option>
									<option value="0">Price</option>
									<option value="0">Rating</option>
								</select> <a href="#" class="main-btn icon-btn"><i
									class="fa fa-arrow-down"></i></a>
							</div>
						</div>
						<div class="pull-right">
							<div class="page-filter">
								<span class="text-uppercase">Show:</span> <select class="input">
									<option value="0">10</option>
									<option value="1">20</option>
									<option value="2">30</option>
								</select>
							</div>
							<ul class="store-pages">
								<li><span class="text-uppercase">Page:</span></li>
								<li class="active">1</li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#"><i class="fa fa-caret-right"></i></a></li>
							</ul>
						</div>
					</div>
					 /store top filter -->

					<!-- STORE -->
					<!-- <div id="store"> -->
					<div id="store">

						<div class="row">
							<c:forEach items="${annunci}" var="ann">

								<!-- Product Single -->
								<div class="col">
									<div class="product product-single">
										<div class="product-thumb">
											<div class="product-label">
												<span>New</span> <span class="sale">-20%</span>
											</div>
											<a class="main-btn quick-view" href="CaricaVeicoloController?idAnnuncio=${ann.idVeicolo}">
												<i class="fa fa-search-plus" ></i> Visualizza
											</a>
											<img src="./imageAuto/${ann.linkUno}">
										</div>
										<div class="product-body">
											<h3 class="product-price">&euro; ${ann.prezzo}</h3>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star-o empty"></i>
											</div>
											<h2 class="product-name">
												<a
													href="CaricaVeicoloController?idAnnuncio=${ann.idVeicolo}">Modello:
													${ann.idModello} Anno: ${ann.annoImmatricolazione}</a>
											</h2>
										</div>
									</div>
								</div>
								<!-- /Product Single -->
								<!--  <div class="clearfix visible-sm visible-xs"></div>-->
							</c:forEach>
						</div>

						<!-- store bottom filter 
						<div class="store-filter clearfix">
							<div class="pull-left">
								<div class="row-filter">
									<a href="#"><i class="fa fa-th-large"></i></a> <a href="#"
										class="active"><i class="fa fa-bars"></i></a>
								</div>
								<div class="sort-filter">
									<span class="text-uppercase">Sort By:</span> <select
										class="input">
										<option value="0">Position</option>
										<option value="0">Price</option>
										<option value="0">Rating</option>
									</select> <a href="#" class="main-btn icon-btn"><i
										class="fa fa-arrow-down"></i></a>
								</div>
							</div>
							<div class="pull-right">
								<div class="page-filter">
									<span class="text-uppercase">Show:</span> <select class="input">
										<option value="0">10</option>
										<option value="1">20</option>
										<option value="2">30</option>
									</select>
								</div>
								<ul class="store-pages">
									<li><span class="text-uppercase">Page:</span></li>
									<li class="active">1</li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#"><i class="fa fa-caret-right"></i></a></li>
								</ul>
							</div>
						</div>
						 /store bottom filter -->
					</div>
				</div>
				<!-- /MAIN -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /section -->

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