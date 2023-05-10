package imcweb.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FiltroConsultaRangoPeso1
 */
@WebFilter("/ConsultarRangoPeso")
public class FiltroConsultaRangoPeso1 extends HttpFilter implements Filter {

	
	
	private static final String NOMBRE_USUARIO = "canelo";
	private static final String PASSWORD_USUARIO = "secreto";
	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public FiltroConsultaRangoPeso1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//0 CASTING DE LA REQUEST, PARA PODER METERLE MANO AL MENSAJE HTTP
		
		HttpServletRequest peticionHttp = (HttpServletRequest)request;
		//1 OBTENER CREDENCIALES - tenemos que leer la cabcera Authorization
		String autorizacion = peticionHttp.getHeader("Authorization");
		if (autorizacion!=null)
		{
			System.out.println("CABECERA AUTHORIZATION = " +autorizacion);
			//2 DECODIFICO BASE64
			autorizacion =  autorizacion.substring(6);//quito lo del basic
			Decoder decoficador =  Base64.getDecoder();
			byte[] bytedeco = decoficador.decode(autorizacion);
			String autoizacion_deco = new String (bytedeco, StandardCharsets.UTF_8);
			System.out.println(autoizacion_deco);
			//3 COMPARO 
			//4 SI ES canelo:secreto, le dejo pasar
			//5 SI NO, le mando a Parla
			
			if(autoizacion_deco.equals(NOMBRE_USUARIO + ":" + PASSWORD_USUARIO)) {
				System.out.println("Usuario autenticado");
				chain.doFilter(request, response);// PASA --> O BIEN VA A OTRO FILTRO O BIEN VA AL SERVLET
			}else {//5 SI NO, le mando a Parla
				System.out.println("Usuario NO autenticado credenciales incorrectas");
				HttpServletResponse responseHttp = (HttpServletResponse)response;
				responseHttp.sendRedirect("error.jsp");
				
			}	
		} else {
			
			System.out.println("Usuario NO autenticado SIN credenciales ");
			HttpServletResponse responseHttp = (HttpServletResponse)response;
			responseHttp.sendRedirect("error.jsp");
			
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
