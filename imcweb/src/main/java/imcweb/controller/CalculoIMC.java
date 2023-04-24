package imcweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcweb.service.IMC;
import imcweb.service.Paciente;
import imcweb.service.Salida;
import imcweb.service.TipoIMC;

//import edu.java.val.salud.Paciente;

/**
 * Servlet implementation class CalculoIMC
 */
@WebServlet("/CalculoIMC")
public class CalculoIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculoIMC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//TODO: VALIDAR!
		//TODO: salida
		//TODO: FOTO
		
			//comprobar, que están los datos necesarios y son correctos
		// url http://localhost:9000/imcweb/CalculoIMC?peso=300&altura=2
		String cadena_peso = request.getParameter("peso");
		String cadena_altura = request.getParameter("altura");
		
		float peso = Float.parseFloat(cadena_peso);
		float estatura = Float.parseFloat(cadena_altura);
		System.out.println("PESO Y ALTURA RECIBIDOS " + peso + " " + cadena_altura);
		//Paciente paciente = new Paciente(peso, estatura);
		Paciente paciente = new Paciente(peso, estatura);
		float imc_paciente =  IMC.calcula(paciente);
		TipoIMC tipoIMC = TipoIMC.traducirIMC(imc_paciente);
		
		System.out.println("imc " + imc_paciente + " " + tipoIMC);
		
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
