<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilolistadoregistros.css">
<title>LISTA DE DNIS</title>
</head>
<!--
	private int id;
	private Date fecha_registro;
	private float imc_num;
	private float altura;
	private float peso;
	private TipoIMC tipoIMC;
	private Paciente paciente; 
 -->
<body>
	<c:if test="${not empty listareg}">
		<table >
			<tr>
				<th>FECHA</th>
				<th>IMC NUMERICO</th>
				<th>TIPO IMC</th>
				<th>PESO</th>
				<th>ALTURA</th>
				<th>PACIENTE</th>
			</tr>
			<c:forEach items="${listareg}" var="registro">
				<tr>
					<td>${registro.fecha_registro}</td>
					<td>${registro.imc_num}</td>
					<td>${registro.tipoIMC}</td>
					<td>${registro.peso}</td>
					<td>${registro.altura}</td>
					<td><a href="ConultarPaciente?id=${registro.paciente.id}">DETALLE PACIENTE</a></td>
				</tr>
			</c:forEach>

		</table>
		<p><a href="./">Ir al menú principal</a></p>
	</c:if>
	<c:if test="${empty listareg}">
		Noy hay registros en ese rango
	</c:if>

</body>
</html>