<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="JuegoAdivina" method="get">
	<label for="numero">NUMERO</label>
	<input name="numero" id="numero" type="number"><br>
	<input type="submit" value="JUGAR"><br>
</form>
Te quedan ${vidas} intentos<br>
${mensaje_respuesta}
</body>
</html>