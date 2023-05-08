package imcweb.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FiltroConsultaRangoPeso
 */
@WebFilter("/ConsultarRangoPeso")
public class FiltroConsultaRangoPeso extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroConsultaRangoPeso() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("ANTES de FiltroConsultaRangoPeso");
		//TOMO TIEMPO T0
		long tiempoInicialMs = System.currentTimeMillis();
		chain.doFilter(request, response);//PASA --> O BIEN VA A OTRO FILTRO O BIEN VA AL SERVLET
		//TOMO TIEMPO T1
		long tiempoFinalMs = System.currentTimeMillis();
		//resto T1-T0 -> me dice lo que tardó
		long tiempoTotal = tiempoFinalMs-tiempoInicialMs;
		System.out.println("HA TARDADO " + tiempoTotal);
		System.out.println("DESPUÉS de FiltroConsultaRangoPeso");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
