package edu.servlet;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.service.BuscarDniEnFichero;
import edu.util.Constantes;

/**
 * Servlet implementation class BusquedaDni
 */
@WebServlet("/BusquedaDni")// GET / POST http://localhost:8080/miprimeraappweb/BusquedaDni?dni=546457
public class BusquedaDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaDni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest peticionHTTP, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		//http://localhost:8080/miprimeraappweb/BusquedaDni?dni=33
		//1 OBTENER EL DNI QUE ME MANDA LA PÁGINA
		String numdni = peticionHTTP.getParameter("dni");//esto extrae de la url el valor del parmaetro dni
		System.out.println("nos llega para buscar un dni " + numdni);
		//2 BUSCAR ESE DNI EN EL FICHERO
		Path path = Path.of(getServletContext().getRealPath(Constantes.RUTA_FICHERO_DNIS));
		Dni dni_buscado = BuscarDniEnFichero.buscarNumeroDniEnFichero(numdni, path);
		//3 GENERO LA RESPUESTA
		peticionHTTP.setAttribute("dnibuscado", dni_buscado);
		peticionHTTP.getRequestDispatcher("salidabusqueda.jsp").forward(peticionHTTP, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
