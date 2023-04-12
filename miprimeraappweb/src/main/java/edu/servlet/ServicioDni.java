package edu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServicioDni
 */
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ADD LA CLASE DNI, CALCULAR LA LETRA Y GENERAR LA RESPUESTA
		 
		String nombre = request.getParameter("name");
		String dni = request.getParameter("dni");
		
		System.out.println("Nombre rx " + nombre);
		System.out.println("Dni rx " + dni);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
