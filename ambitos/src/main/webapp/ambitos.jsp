<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SALIDA</title>
</head>
<body>
<!-- se puedo omitir el nombre del "saco" o ámbito y Expression lenguage
buscaría en la request, en la sesion y en el aplication/contexto -->
NUMVECES AMBITO/SCOPE REQUEST  ${requestScope.numveces} <br>
NUMVECES AMBITO/SCOPE SESSION  ${sessionScope.numvecessesion} <br>
NUMVECES AMBITO/SCOPE APLICACION / CONTEXTO ${applicationScope.numvecesapp}
</body>
</html>