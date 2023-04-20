<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilolistadodnis.css">
<title>LISTA DE DNIS</title>
</head>
<body>
	<c:if test="${not empty listadnis}">
		<table >
			<tr>
				<th>Numero DNI</th>
				<th>Letra DNI</th>
				<th>Nombre</th>
			</tr>
			<c:forEach items="${listadnis}" var="dniaux">
				<tr>
					<td>${dniaux.numero_dni}</td>
					<td>${dniaux.letra_dni}</td>
					<td>${dniaux.nombre}</td>
				</tr>
			</c:forEach>

		</table>
		<p><a href="./">Ir al menú principal</a></p>
	</c:if>
	<c:if test="${empty listadnis}">
		EL LISTADO DE DNIS ESTÁ VACÍO
	</c:if>

</body>
</html>