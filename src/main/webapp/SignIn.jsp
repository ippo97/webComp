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

	<title>C-SHOP</title>

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
	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	<%@ page isELIgnored="false" %>
	<!-- IMPOSTRANTE PER FAR FUNZIONARE JSTL -->
	
	<!-- Heder & navbar -->
	<jsp:include page="pageParts/HeadeNavbar.jsp"></jsp:include>
	<!-- /Heder & navbar -->


	
	<!--STATO INSERIMENTO -->
	<c:if test="${not empty statoInserimentoTrue}">
		<div class="alert alert-success">
			<strong>Success!</strong> Utente Registrato correttamente!
		</div>
	</c:if>

	<c:if test="${not empty statoInserimentoFalse}">
		<div class="alert alert-danger">
			<strong>Failed!</strong> Utente non registrato !
		</div>
	</c:if>
	<!--/STATO INSERIMENTO-->
		
<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<form id="checkout-form" class="clearfix" action="InserisciPersonaController" method="post">
					<div class="col-md-3">
					</div>
					
					<div class="col-md-6">
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Insersci i tuoi dati</h3>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="nome" placeholder="Nome" id="nome" maxlength="20" required  autofocus>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="cognome" placeholder="Cognome" maxlength="20"required autofocus>
							</div>
							<div class="form-group">
								<input class="input" type="email" name="email" placeholder="Email" id="email" maxlength="30" required autofocus>
							</div>						
							<div class="form-group">
								<input class="input" type="password" name="password" id="passwor1" placeholder="Password" maxlength="20"required autofocus>
							</div>
							<div class="form-group" id="divControllo">
								<input class="input" type="password" name="cpassword" id="passwor2" placeholder="Conferma Password" maxlength="20" required autofocus>
							</div>
							<div class="form-group">
								<button class="primary-btn" id="registrati" onclick='controlloLog()'>Registrati </button>
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

	<script>
	
	function controlloLog(){
		var pw1 = document.getElementById('passwor1').value;
		var pw2 = document.getElementById('passwor2').value;
		console.log("contollo-->" + (pw1 == pw2));
		if(pw1 != pw2){
			alert("Attenzioni  password non coincidenti!");
			return false;}
		return true;
	}
	
	</script>


	<!-- jQuery Plugins -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/main.js"></script>
	

</body>

</html>