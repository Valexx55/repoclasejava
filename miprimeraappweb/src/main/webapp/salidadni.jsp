<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estiloformulario.css">
<title>Página de inicio</title>
</head>
<body>
	<!--
ESTO ES UN COMENTARIO

1 TODO: UN FORMULARIO CON LOS CAMPOS
NOMBRE Y NÚMERO
Y BOTÓN DE CALCULAR LETRA
--
2 -- 
HACER UN SERVICIO DE JAVA QUE RECIBA
ESTOS DATOS DEL FORMULARIO Y CALCULE LA LETRA

3 -- 
GENERAMOS LA RESPUESTA 
 -->

	<form>
		<ul>
			<li><label for="name">Nombre:</label> <input type="text"
				id="name" name="name" value="${dni.nombre}"></li>
			<li><label for="dni">Numero Dni:</label> <input type="number"
				id="dni" name="dni" value="${dni.numero_dni}"></li>
			<li><label for="letra">Letra Dni:</label> <input type="text"
				id="letra" name="letra" value="${dni.letra_dni}"></li>
		</ul>
	</form>

</body>
</html>