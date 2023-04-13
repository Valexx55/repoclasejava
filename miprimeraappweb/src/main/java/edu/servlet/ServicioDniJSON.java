package edu.servlet;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServicioDniJSON
 */
@WebServlet("/ServicioDniJSON")
public class ServicioDniJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicioDniJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//http://localhost:8080/miprimeraappweb/ServicioDni?name=&dni=
		String nombre = request.getParameter("name");
		String dni = request.getParameter("dni");
		
	
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
			
			response.setStatus(HttpsURLConnection.HTTP_OK);
			
			//VOY A GENERAR UNA RESPUESTA QUE ES JSON
			//el objeto dni, lo tengo que pasar a TEXTO
			//=> SERIALIZAR
			
			Gson gson = new Gson();
			String dni_json = gson.toJson(objeto_dni);
			System.out.println("DNI EN FORMATO JSON");
			System.out.println(dni_json);
			
			//request.setAttribute("dni", objeto_dni);
			//request.getRequestDispatcher("salidadni.jsp").forward(request, response);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().append(dni_json);
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
