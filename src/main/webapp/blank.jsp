<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

		<div class="container"> 
		  	<div id="myDiv">
		    
		            <img id="myImg" src="ny.jpg"  >
		    		

			<script>
			
			$(document).ready(function() { 
				alert("Image is loaded");
				document.getElementById("myImg").src = "https://www.w3schools.com/bootstrap/ny.jpg";
			});
			
			
			</script>
		    
			</div>
		</div>
		
		
		
</body>
</html>
