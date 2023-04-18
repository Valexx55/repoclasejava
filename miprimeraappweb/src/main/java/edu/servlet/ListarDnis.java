package edu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.servlet.service.ListadoService;
import edu.servlet.service.ListadoServiceImpl;

/**
 * Servlet implementation class ListarDnis
 * este servicio, consulta los dnis alojados en el fichero
 * y los muestra en un JSP
 */
@WebServlet("/ListarDnis")
public class ListarDnis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListadoService listadoService;//la clase que me da el acceso al listado del DNI
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarDnis() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	this.listadoService = new ListadoServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		//LEER DEL FICHERO Y RECUPERAR LA LISTA DE DNIS
		List<Dni> lista_dnis = this.listadoService.obtenerListaDnis();
		
		//DEVOLVERLA EN EL JSP
		request.setAttribute("listadnis", lista_dnis);
		request.getRequestDispatcher("listadodnis.jsp").forward(request, response);
		
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
