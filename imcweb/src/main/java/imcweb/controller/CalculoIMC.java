package imcweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcweb.model.TipoIMC;
import imcweb.service.IMC;
import imcweb.service.InfoSalidaImc;
import imcweb.service.Paciente;


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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO: VALIDAR!
		// TODO: salida
		// TODO: FOTO

		// OBTENGO DATOS
		String cadena_peso = request.getParameter("peso");
		String cadena_altura = request.getParameter("altura");

		// HAGO CALCULO
		float peso = Float.parseFloat(cadena_peso);
		float estatura = Float.parseFloat(cadena_altura);
		System.out.println("PESO Y ALTURA RECIBIDOS " + peso + " " + cadena_altura);
		// Paciente paciente = new Paciente(peso, estatura);
		Paciente paciente = new Paciente(peso, estatura);
		float imc_paciente = IMC.calcula(paciente);
		TipoIMC tipoIMC = TipoIMC.traducirIMC(imc_paciente);

		String foto = obtenerRutaFotoTipoIMC(imc_paciente); // voy a hacer una función le doy el tipo imc y el me da la ruta de la foto
							// correspondiente
		System.out.println("imc " + imc_paciente + " " + tipoIMC);
		InfoSalidaImc infoImc = new InfoSalidaImc(tipoIMC.toString(), imc_paciente, foto);

		request.setAttribute("infoimc", infoImc); // le doy los datos variables a tomcat, para que componga el JSP
		request.getRequestDispatcher("salidaimc.jsp").forward(request, response);

		// GENERAR EL JSP
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private String obtenerRutaFotoTipoIMC(float imc) {
		String ruta_foto = null;

		if (imc < 16) {
			ruta_foto = "imagenes/desnutricion.png";
		} else if ((imc >= 16) && (imc < 18)) {
			ruta_foto = "imagenes/delgado.png";
		} else if ((imc >= 18) && (imc < 25)) {
			ruta_foto = "imagenes/atleta.png";
		} else if ((imc >= 25) && (imc < 31)) {
			ruta_foto = "imagenes/sobrepeso.png";
		} else {
			ruta_foto = "imagenes/obeso.png";
		}

		return ruta_foto;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
