<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Inserisci asta</title>

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
		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	<!--  <%@ page isELIgnored="false" %> -->
	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	
	<!-- Heder & navbar -->
	<jsp:include page="pageParts/HeadeNavbar.jsp"></jsp:include>
	<!-- /Heder & navbar -->

	<!-- Visualizzo lo stato dellinserimento  -->
	<c:if test="${not empty message}">
		<div class="alert alert-success">
			<strong>Success! </strong> ${message}
		</div>
	</c:if>

	<c:if test="${not empty messageErr}">
		<div class="alert alert-danger">
			<strong>Failed!</strong> ${messageErr}
		</div>
	</c:if>





<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<form id="checkout-form" class="clearfix" action="InserisciastaController" method="post" enctype="multipart/form-data">
					<div class="col-md-3">
					</div>
					
					<div class="col-md-6">
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Insersci i dati del tuo veicolo</h3>
							</div>
							<div class="form-group">
								<p class="title">Marca</p>
								<select class="input" id="marche" required autofocus>
		  							<option value="null">----</option>
								</select>
							</div>
							
							<div class="form-group">
							<p class="title">Modello</p>
								<select class="input" name="Modelli" id="modelli" disabled="disabled" required autofocus>
		  							<option value="null">----</option>
		  						</select>
							</div>	
							
							<div class="form-group">
							<p class="title">Immagini</p>
							<input class="input" type="file" name="uploadFile" id="upfile" max=3 multiple/>
							</div>
								
									
						  	<div class="form-group">
								<p class="title">Descrizione</p>
								<textarea class="inputTextArea" rows="5"  name="descrizione" placeholder="Descrivi veicolo"   required autofocus></textarea>
							</div>
						
							<div class="form-group">
								<p class="title">Anno di immatricolazione</p>
								<input class="input"  type="number"  name="annoImmatr" placeholder="Scrivi l'anno di immatricolazione" min="1900" step="1" required autofocus>
							</div>
							<div class="form-group">
								<p class="title">Km del veicolo</p>
								<input class="input" type="number" name="kmVeicolo" placeholder="scrivi i Km del veicolo" min="100" step="100" required autofocus>
							</div>
							 
							
							<div class="section-title">
								<h3 class="title">Dati relativi all'asta</h3>
							</div>
							<div class="form-group">
								<p class="title">Base dell'asta</p>
								<input class="input" type="number" name="baseAsta" placeholder="Base dell'asta" required autofocus>
							</div>
							<div class="form-group">
								<p class="title">Data di fine asta</p>
								  <input class="input" type="date" name="data" required autofocus>								
							</div>
							<div class="form-group">
								<p class="title">Ora di fine asta</p>
								  <input class="input" type="time" name="mydatetime">								
							</div>
							
							<div class="form-group">
							<p>Date/Time attuale: <span id="datetime"></span></p>
							</div>
							<script>
							var dt = new Date();
							document.getElementById("datetime").innerHTML = (("0"+dt.getDate()).slice(-2)) +"."+ (("0"+(dt.getMonth()+1)).slice(-2)) +"."+ (dt.getFullYear()) +" "+ (("0"+dt.getHours()).slice(-2)) +":"+ (("0"+dt.getMinutes()).slice(-2));
							</script>
							
							<div class="form-group">
								<button class="primary-btn"  id="InsAnnuncio">Inserisci asta</button>
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