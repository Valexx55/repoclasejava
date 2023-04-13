package edu.servlet;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;
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
			response.setStatus(HttpsURLConnection.HTTP_INTERNAL_ERROR);
			response.getWriter().append("Error, rellene todos los datos");
		} else if (!(isNumeric(dni))) {
			response.setStatus(HttpsURLConnection.HTTP_BAD_REQUEST);
			response.getWriter().append("Error, mándame un DNI numérico");
		} else {
			//LA COSA HA IDO A IDO BIEN
			System.out.println("Va bien, DNI correcto");
			int numero_dni =  Integer.parseInt(dni);
			Dni objeto_dni = new Dni (numero_dni, nombre);
			char letra_calculada = objeto_dni.calcularLetra();
			objeto_dni.setLetra_dni(letra_calculada);
			
			System.out.println("DNI = " + objeto_dni.toString());
			
			response.setStatus(HttpsURLConnection.HTTP_OK);//200
			//echo a la request, que es como una especie de saco
			//de bolsa, de memoria intermedia, el objeto DNI
			//le meto el objeto dni a la request, porque
			//ese objeto constituye la parte dinámica/variable de la página
			//de salida
			request.setAttribute("dni", objeto_dni);
			//decirle al servidor, que envíe el jsp (la web) de salida correspodiente
			//"dale al cliente esta página como respuesta" - este JSP
			
			request.getRequestDispatcher("salidadni.jsp").forward(request, response);
			//response.getWriter().append("Su letra es: " + calcular_letra);
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
