package edu.servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServicioDni
 */
//ANOTACIÓN - directiva - MARCA
@WebServlet("/ServicioDni")//con esto mapeamos o asociamos la URL a esta clase de tal modo que el servidor redirige a este servicio, las peticiones con el nombre/sufijo ServicioDni
//pej: http://localhost:8080/miprimeraappweb/ServicioDni
//http://localhost:8080/miprimeraappweb/inicio.html
public class ServicioDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicioDni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGetMio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO ADD LA CLASE DNI, CALCULAR LA LETRA Y GENERAR LA RESPUESTA
		 
		String nombre = request.getParameter("name");
		String dni = request.getParameter("dni");
		
		System.out.println("Nombre rx " + nombre);
		System.out.println("Dni rx " + dni);
		//crear un objeto dni y llamar al calular letra
		//pasar del dni String al dni númerico, para poder consturir el objeto dni
		int numero_dni = Integer.parseInt(dni);//"CASTING" - conversión de tipos
		Dni objeto_dni = new Dni(numero_dni, nombre);
		char letra_dni = objeto_dni.calcularLetra();
		
		//response.setStatus(500);
		//con getWriter estoy escribiendo en el cuerpo de la respuesta
		response.getWriter().append("SU LETRA ES " + letra_dni);
	}
	
	/**
	 * 
	 * @param cadena
	 * @return false si cadena no representa un número true si cadena es un número
	 */
	 private static boolean isNumeric(String cadena) {

	        boolean resultado = false;

		        try {
		            Integer.parseInt(cadena);
		            resultado = true;
		        } catch (NumberFormatException excepcion) {
		            resultado = false;
		        }

	        return resultado;
	    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//http://localhost:8080/miprimeraappweb/ServicioDni?name=&dni=
		// TODO Auto-generated method stub
		String nombre = request.getParameter("name");
		String dni = request.getParameter("dni");
		// Crear un objeto dni y llamar al calcular letra
		//pasar del dni String al dni numérico para poder construir el objeto dni
		
		//nombre==""; nombre.isEmpty()
		//Objects.isNull(dni); nombre==null
		if(nombre==null ||dni==null||nombre.isEmpty()||dni.isEmpty()) {
			response.setStatus(500);
			response.getWriter().append("Error, rellene todos los datos");
		} else if (!(isNumeric(dni))) {
			response.setStatus(400);
			response.getWriter().append("Error, mándame un DNI numérico");
		} else {
			int numero_dni =  Integer.parseInt(dni);
			Dni objeto_dni = new Dni (numero_dni, nombre);
			char calcular_letra = objeto_dni.calcularLetra();
			response.setStatus(200);
			response.getWriter().append("Su letra es: " + calcular_letra);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
