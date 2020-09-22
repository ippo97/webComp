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
			<div class="row" >
				<form id="checkout-form" class="clearfix" action="InserisciastaController" method="post" enctype="multipart/form-data">
					<div class="col-md-3">
					</div>
					
					<div class="col-md-6" id="cont">
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Insersci i dati del tuo veicolo</h3>
							</div>
							<div class="form-group">
								<p class="title">Marca</p>
								<select class="input" id="marche"  autofocus> <!-- required  -->
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
							<input class="input" type="file" name="uploadFile" id="upfile"  multiple/> <!-- max=3  -->
							</div>
								
									
						  	<div class="form-group">
								<p class="title">Descrizione</p>
								<textarea class="inputTextArea" rows="5"  name="descrizione" placeholder="Descrivi veicolo" autofocus required></textarea>
							</div>
						
							<div class="form-group">
								<p class="title">Anno di immatricolazione</p>
								<input class="input"  type="number" id="annoImm" name="annoImmatr" placeholder="Scrivi l'anno di immatricolazione"   autofocus required> <!--required min="1900" step="1" -->
							</div>
							<div class="form-group">
								<p class="title">Km del veicolo</p>
								<input class="input" type="number" name="kmVeicolo" placeholder="scrivi i Km del veicolo"   autofocus required> <!-- min="100" step="100" -->
							</div>
							 
							
							<div class="section-title" >
								<h3 class="title">Dati relativi all'asta</h3>
							</div>
							<div class="form-group">
								<p class="title">Base dell'asta</p>
								<input class="input" type="number" name="baseAsta" placeholder="Base dell'asta"  autofocus required>
							</div>
							<div class="form-group" >
								<p class="title">Data di fine asta</p>
								  <input class="input" type="date" name="data" id="data" onchange='controlloData()' autofocus required>								
							</div>
							<div class="form-group">
								<p class="title">Ora di fine asta</p>
								  <input class="input" type="time" name="mydatetime" autofocus required>								
							</div>
							
							<div class="form-group">
							<p>Date/Ora attuale: <span id="datetime"></span></p>
							</div>
							<script>
							var dt = new Date();
							document.getElementById("datetime").innerHTML = (("0"+dt.getDate()).slice(-2)) +"/"+ (("0"+(dt.getMonth()+1)).slice(-2)) +"/"+ (dt.getFullYear()) +" "+ (("0"+dt.getHours()).slice(-2)) +":"+ (("0"+dt.getMinutes()).slice(-2));
							</script>
							
							<div class="form-group">
								<button class="primary-btn"  id="InserisciAsta" onmouseover='controllo()' >Inserisci asta</button>
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
	
	function controllo(){
		
		var a = document.getElementById('modelli');
		
		var upload = document.getElementById('upfile');
		var filename = upload.value;
		var fileExtension = (filename.substring(filename.lastIndexOf(".") + 1));
		fileExtension = fileExtension.toLowerCase();
		
		if(a.disabled == true){
			alert("Selezionare Modello!");	
		}
		else if(filename == ""){
			alert("Seleziona almeno un'immagine!");
			return false;
		}else if (fileExtension == "jpg" || fileExtension == "jpeg") {
			return true;
		}else{
			alert("L'estensione deve essere jpg!-->" + fileExtension);
			$('input').val("");
			document.getElementById("upfile").focus();
			return false;
		}
		
		//controllo anno immatricolazione
		var annoIm = document.getElementById('annoImm');
		var dt = new Date();
		
		if(annoIm.value > dt.getFullYear()){
			alert("Anno immatricolazione non corretto!");
			annoIm.value ="";
			annoIm.focus();
		}
		
	}
	
	function controlloData() {
		var data = document.getElementById("data");
		var dt = new Date();
		var dt1 = new Date();
		//if(dt.getDate()>data.day dt.getMonth() dt.getFullYear())
		
		 // Parse the date parts to integers
    	var dateString = data.value;
		var parts   = dateString.split("-");
    	var day     = parseInt(parts[2], 10);
    	var month   = parseInt(parts[1], 10);
    	var year    = parseInt(parts[0], 10);
		
    	if(year < dt.getFullYear()){/*se anno piu piccolo*/ alert("Data non corretta - Anno"); document.getElementById("data").value = ""; }
    	if(year == dt.getFullYear() && month < (("0"+(dt.getMonth()+1)).slice(-2))) {/*se è nello stesso anno ma con mese inferiore*/alert("Data non corretta - Mese"); document.getElementById("data").value = "";}
    	if(year == dt.getFullYear() && month == (("0"+(dt.getMonth()+1)).slice(-2)) && day < dt.getDate()) {/*se è nello stesso anno, mese, con un giorno inferiore*/alert("Data non corretta - Anno Mese Data"); document.getElementById("data").value = "";}
    	if(year == dt.getFullYear() && month == (("0"+(dt.getMonth()+1)).slice(-2)) && day == dt.getDate()) {/*se è nello stesso anno, mese, giorno*/alert("Data non corretta - Oggi non è possibile inserire un'asta!"); document.getElementById("data").value = "";}
    	
    	//console.log(year + " " + day + " " + month);
    	//console.log(dt.getFullYear() + " " + dt.getDate() + " " + (("0"+(dt.getMonth()+1)).slice(-2)));
	}
	
	
	
	// controllo che i file sono massimo 3
	$('#upfile').change(controlloNumeroFile);
	function controlloNumeroFile() {
		// alert("controllofile");
		var fileUpload = document.getElementById('upfile').files;
		var nelements = fileUpload.length;
		if (nelements > 3) {
			alert("Attenzione hai inserito piu' di 3 foto!");
			$('input').val("");
		}
	}
	
	</script>
	
	
	
	
	<!--  <script>
	//controllo se è stato selezionato un modello
	var selModel = false;
	var a = document.getElementById('modelli');
	a.addEventListener('click',function(){
		selModel = true;
		alert(selModel);
	})
	
	</script> -->
	
	<!-- jQuery Plugins -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/main.js"></script>

</body>

</html>