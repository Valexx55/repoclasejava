<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estiloformulario.css">
<title>LISTA DE DNIS</title>
</head>
<body>
 
	<c:if test="${not empty dnibuscado}">
		<form>
		<ul>
			<li><label for="name">Nombre:</label> <input type="text"
				id="name" name="name" value="${dnibuscado.nombre}"></li>
			<li><label for="dni">Numero Dni:</label> <input type="number"
				id="dni" name="dni" value="${dnibuscado.numero_dni}"></li>
			<li><label for="letra">Letra Dni:</label> <input type="text"
				id="letra" name="letra" value="${dnibuscado.letra_dni}"></li>
		</ul>
		<p><a href="./">Ir al menú principal</a></p>
		<!-- <p><a href="index.html">Ir al menú principal index</a></p> -->
	</form>
	</c:if>
	<c:if test="${empty dnibuscado}">
		EL DNI BUSCADO NO ESTÁ EN NUESTRA APP
		<p><a href="busquedadni.html">Volver a buscar</a></p>
	</c:if>
 
</body>
</html>