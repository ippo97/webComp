<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>E-SHOP HTML Template</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

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
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	<%@ page isELIgnored="false"%>
	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	
	
	
	<!-- Heder & navbar -->
	<jsp:include page="pageParts/HeadeNavbar.jsp"></jsp:include>
	<!-- /Heder & navbar -->


	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!--  Product Details -->
				<div class="product product-details clearfix">
				<div class="col-md-6">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<c:if test="${veicolo.linkUno ne 'null'}">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								</c:if>
								<c:if test="${veicolo.linkDue ne 'null'}">
								<li data-target="#myCarousel" data-slide-to="1"></li>
								</c:if>
								<c:if test="${veicolo.linkTre ne 'null'}">
								<li data-target="#myCarousel" data-slide-to="2"></li>
								</c:if>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner ">
								<c:if test="${veicolo.linkUno ne 'null'}">
								<div class="item active">
									<img src="imageAuto/${veicolo.linkUno}" 
										style="width: 100%;">
								</div>
								</c:if>
								<c:if test="${veicolo.linkDue ne 'null'}">
								<div class="item">
									<img src="imageAuto/${veicolo.linkDue}"
										style="width: 100%;">
								</div>
								<c:if test="${veicolo.linkTre ne 'null'}">
								</c:if>
								<div class="item">
									<img src="imageAuto/${veicolo.linkTre}"
										style="width: 100%;">
								</div>
								</c:if>
							</div>

							<!-- Left and right controls -->
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span> <span
								class="sr-only">Dietro</span>
							</a> <a class="right carousel-control" href="#myCarousel"
								data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span> <span
								class="sr-only">Avanti</span>
							</a>
						</div>

					</div>
					<div class="col-md-6">
						<div class="product-body">
							<div class="product-label">
								<!--  <span>New</span>
								<span class="sale">-20%</span>-->
							</div>
							<h2 class="product-name">${marca.idMarca} ${veicolo.idModello} Anno: ${veicolo.annoImmatricolazione}</h2>
							<c:if test="${empty asta}">
							<h3 class="product-price">${veicolo.prezzo} &euro;</h3>
							</c:if>
							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o empty"></i>
								</div>
								<!--<a href="#">3 Review(s) / Add Review</a> -->
							</div>
							
							<p style="font-size:18px"><strong>Modello:</strong> ${veicolo.idModello}</p>
							<p style="font-size:18px"><strong>Email:</strong> ${veicolo.email}</p>
							<p style="font-size:18px"><strong>N.telefono: </strong>  345897586</p>
							
							<c:if test="${not empty asta}">
							
							<div class="product-btns">
								<div class="qty-input">
									<p style="font-size:18px"> <strong>Puntata attuale:</strong> <label id="lbl">hgkgk</label></p>
									
								</div>
							</div>	
							
							<div class="qty-input">
								<input class="input" type="number">
								<div class="pull-right">
								<button class="primary-btn ">    Punta   </button>
									
								</div>
							</div>
							
							</c:if>
							
						</div>
					</div>
					<div class="col-md-12">
						<div class="product-tab">
							<ul class="tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab1">Descrizione</a></li>
								<li><a data-toggle="tab" href="#tab2">Recensioni (${fn:length(recensioni)})</a></li>
							</ul>
							<div class="tab-content">
								<div id="tab1" class="tab-pane fade in active">
									<p>${veicolo.descrizione}</p>
								</div>
								<div id="tab2" class="tab-pane fade in">

									<div class="row">
										<div class="col-md-6">
											<div class="product-reviews" id="prova">
												
										<c:forEach items="${recensioni}" var="rec" varStatus="loop">

												<div class="single-review" id="rec${loop.count}">
													<div class="review-heading" >
														<div><a href="#"><i class="fa fa-user-o"></i> ${rec.nomeRevensitore}</a></div>
														<div><a href="#"><i class="fa fa-clock-o"></i> ${rec.data}</a></div>
														<div class="review-rating pull-right">
															
															<c:forEach begin="1" end="${rec.stelle}" var="val">
    															<i class="fa fa-star"></i>
															</c:forEach>
															
															<c:forEach begin="${rec.stelle}" end="4" var="val">
    															<i class="fa fa-star-o empty"></i>
															</c:forEach>
														</div>
													</div>
													<div class="review-body">
														<p>${rec.testo}</p>
													</div>
												</div>
												
											</c:forEach>

												<!-- <ul class="reviews-pages">
													<li class="active">1</li>
													<li><a href="#">2</a></li>
													<li><a href="#">3</a></li>
													<li><a href="#"><i class="fa fa-caret-right"></i></a></li>
												</ul> -->
											</div>
										</div>
										<div class="col-md-6">
											<h4 class="text-uppercase">Descrivi la tia esperienza d'acquisto sul venditore!</h4>
											<p>La tua email non sara' publicata.</p>
											<div class="review-form">
												<div class="form-group">
													<input class="input" type="text" id="nome" placeholder="Il tuo nome" />
												</div>
												<div class="form-group">
													<input class="input" type="email" id="email" placeholder="La tua mail" />
												</div>
												<div class="form-group">
													<textarea class="input" id="recensione" placeholder="La tua recenzione"></textarea>
												</div>
												<div class="form-group">
													<div class="input-rating">
														<strong class="text-uppercase">Il tuo punteggio: </strong>
														<div class="stars">
															<input type="radio" id="star5" name="rating" value="5" /><label for="star5"></label>
															<input type="radio" id="star4" name="rating" value="4" /><label for="star4"></label>
															<input type="radio" id="star3" name="rating" value="3" /><label for="star3"></label>
															<input type="radio" id="star2" name="rating" value="2" /><label for="star2"></label>
															<input type="radio" id="star1" name="rating" value="1" /><label for="star1"></label>
														</div>
													</div>
												</div>
												<button class="primary-btn"  name="for" id="btnRew" onclick="inserisciRecensione()">Invia</button>
											</div>
										</div>
									</div>

							<script type="text/javascript">
							
							 function inserisciRecensione() {
								 //alert("entrato sbagliato!");
								 var nome = document.getElementById("nome").value;
								 var email = document.getElementById("email").value;
								 var recensione = document.getElementById("recensione").value;
								 var stelle = document.querySelector('input[name="rating"]:checked').value;
								
								 //alert(stelle);
								 if(!nome || !email || !recensione)
								 { alert("Compila tutti i campi!"); return false;}
								
								 var venditore =  '${veicolo.email}';
								  
									$.ajax({
										 type: "post",
										 url:"InserisciRecensioneController",
										 data:{nom: nome, emai: email, recens: recensione, vendit: venditore, stel: stelle},
										 success:function(data){
											 alert(data);
										 }
									 });
								 
									var d1 = document.getElementById('rec1');
									var nuova ="<div> Aggiorna la paggina per visualizzare la tua recensione !</div>" ;
									d1.insertAdjacentHTML('beforebegin', nuova);
									
									//disabilito il bottone per non fa inserire nuove recensioni
									document.getElementById("btnRew").disabled = true;
							}
							 
							// set timeout
							 var tid = setTimeout(aggPrezzo, 2000);
							 function aggPrezzo() {
							  var g = document.getElementById("lbl").innerHTML = "CIao lenmxlln";
							  
							  var id = '${asta.id_asta}'
							  var name='<%=session.getAttribute("email")%>';
							 $.ajax({
									 type: "post",
									 url:"CaricaUltimaPuntata",
									 data:{idAsta : id},
									 success:function(data){
										 //alert(data);
									 }
								 });
							  
							  tid = setTimeout(aggPrezzo, 2000); // repeat myself
							 }
							 
							</script>

								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- /Product Details -->
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
				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h2 class="title">Aste</h2>
					</div>
				</div>
				<!-- section title -->

				<c:forEach items="${aste}" var="aste" varStatus="ind">

				<!-- Product Single -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="product product-single">
						<div class="product-thumb">
							<div class="product-label">
							<!-- 	<span>New</span>
								<span class="sale">-20%</span> -->
							</div>
							<a class="main-btn quick-view"href="CaricaAstaController?idAsta=${aste.id_asta}"><i class="fa fa-search-plus"></i> Quick view</a>
							<img src="imageAuto/${path[ind.index]}" alt="">
						</div>
						<div class="product-body">
							<h3 class="product-price">Base Asta: ${aste.baseAsta}</h3>
							<div class="product-rating">
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star-o empty"></i>
							</div>
							<h2 class="product-name"><a href="#">Modello: ${model[ind.index]} </a></h2>
							<div class="product-btns">
								<button class="main-btn icon-btn"><i class="fa fa-heart"></i></button>
								<button class="main-btn icon-btn"><i class="fa fa-exchange"></i></button>
								<a class="primary-btn add-to-cart" href="CaricaAstaController?idAsta=${aste.id_asta}" ><i class="fa fa-shopping-cart"></i> Visualizza</a>
							</div>
						</div>
					</div>
				</div>
				<!-- /Product Single -->
				
				</c:forEach>
				
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
