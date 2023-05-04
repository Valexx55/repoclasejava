package imcweb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcweb.model.RegistroIMC;
import imcweb.service.IMCWebService;
import imcweb.service.IMCWebServiceImpl;

/**
 * Servlet implementation class ConsultarRangoPeso
 */
@WebServlet("/ConsultarRangoPeso")
public class ConsultarRangoPeso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarRangoPeso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//AQUÍ, GESTIONO LA PETICIÓN DE CONSULTAR
		//1 extrear los parámetros de la petición: peso max y peso min
		String spesomin = request.getParameter("pesomin");
		String spesomax = request.getParameter("pesomax");
		float pesomin = Float.parseFloat(spesomin);
		float pesomax = Float.parseFloat(spesomax);
		//TODO validar la entrada
		System.out.println("PESO MIN = " + pesomin + "PESO MAX = " + pesomax);
		//2 invoco al servicio, que es la clase que hace la tarea
		IMCWebService imcWebService = new IMCWebServiceImpl();
		try {
			List<RegistroIMC> lRegistroIMCs = imcWebService.conusltarRegistrosIMCPorRangoPeso(pesomin, pesomax);
			//TODO //3 le mando el JSP como respuesta
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// GENERAR LA RESPUESTA DE ERRROR
			e.printStackTrace();
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
