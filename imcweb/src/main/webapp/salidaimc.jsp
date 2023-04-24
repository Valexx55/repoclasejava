<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- imc numerico, imc nominal, foto 

	private String imc_nom;//nombre
	private float imc_num;//numero
	private String foto;//ruta-->
	
<p>Su IMC resultante es: ${infoimc.imc_num}, su estado es: ${infoimc.imc_nom}</p>
<img src="${infoimc.foto}" alt="La foto de su estado">
</body>
</html>