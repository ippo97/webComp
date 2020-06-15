<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form method="post" action="LoadImageSecondController" enctype="multipart/form-data">
     Select file to upload:
     <input type="file" name="uploadFile" id="upfile" />
     <br/><br/>
    <input type="submit" value="Upload" ONCLICK="return checkData()"/>
    </form>

	<script>
	
	function checkData() {
		var upload = document.getElementById('upfile');
		var filename = upload.value;
		var fileExtension = (filename.substring(filename.lastIndexOf(".") + 1));
		var fileExtension = fileExtension.toLowerCase();
		if (filename == "") {
		alert ("Selezionare un'immagine.");
		return false;
		} else if (fileExtension == "jpg" || fileExtension == "jpeg" || fileExtension == "png") {
		return true;
		} else {
		alert ("Attenzione sono ammessi solo file jpg e jpeg e png.");
		return false;
		}
		}
	
	</script>
</body>
</html>