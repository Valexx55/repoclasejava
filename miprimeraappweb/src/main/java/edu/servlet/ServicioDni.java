package edu.servlet;

import java.io.IOException;
import java.net.http.HttpClient;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//TODO: MODIFICAR EL SERVICIO PARA QUE CADA DNI
//RECIBIDO, SER GUARDE EN UN FICHERO
//USAD files y path COMO en el ejemplo https://codeshare.io/EB8Rep
/**
 * Servlet implementation class ServicioDni
 */
//ANOTACIÓN - directiva - MARCA
@WebServlet("/ServicioDni")//con esto mapeamos o asociamos la URL a esta clase de tal modo que el servidor redirige a este servicio, las peticiones con el nombre/sufijo ServicioDni
//pej: http://localhost:8080/miprimeraappweb/ServicioDni
//http://localhost:8080/miprimeraappweb/inicio.html
public class ServicioDni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Path fichero_salida_dnis;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServicioDni() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("En el constructor");
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("en service");
    	super.service(req, resp);
    	
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("En el init");
    	//donde voy a comprobar si el fichero existe
    	// y si no existe, lo creo
    	//this es el Servlet creado / el objeto que atiende las peticiones / El controlador en MVC
    	this.fichero_salida_dnis = Path.of(getServletContext().getRealPath("/listadnis.txt"));
    	if (!Files.exists(this.fichero_salida_dnis))
    	{
    		System.out.println("El fichero no existe, lo creo");
    		try {
				Files.createFile(this.fichero_salida_dnis);
				System.out.println("El fichero creado");
				System.out.println("EL PATH ES " + this.fichero_salida_dnis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error al crear el fichero");
			}
    	} else {
    		System.out.println("El fichero ya existía");
    		System.out.println("EL PATH ES " + this.fichero_salida_dnis);
    	}
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
		String param_nombre_dni = request.getParameter("name");
		String param_num_dni = request.getParameter("dni");
		// Crear un objeto dni y llamar al calcular letra
		//pasar del dni String al dni numérico para poder construir el objeto dni
		
		//nombre==""; nombre.isEmpty()
		//Objects.isNull(dni); nombre==null
		if(param_nombre_dni==null ||param_num_dni==null||param_nombre_dni.isEmpty()||param_num_dni.isEmpty()) {
			response.setStatus(HttpsURLConnection.HTTP_INTERNAL_ERROR);
			response.getWriter().append("Error, rellene todos los datos");
		} else if (!(isNumeric(param_num_dni))) {
			response.setStatus(HttpsURLConnection.HTTP_BAD_REQUEST);
			response.getWriter().append("Error, mándame un DNI numérico");
		} else {
			//LA COSA HA IDO A IDO BIEN
			System.out.println("Va bien, DNI correcto");
			int numero_dni =  Integer.parseInt(param_num_dni);
			Dni objeto_dni = new Dni (numero_dni, param_nombre_dni);
			char letra_calculada = objeto_dni.calcularLetra();
			objeto_dni.setLetra_dni(letra_calculada);
			
			System.out.println("DNI = " + objeto_dni.toString());
			
			//Escribir en el fichero de salida
			Files.writeString(this.fichero_salida_dnis, objeto_dni.toString() + "\n", StandardOpenOption.APPEND);
			
			
			
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
