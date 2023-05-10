package imcweb.controller;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class EscuchaIncioYFin
 *
 */
@WebListener
public class EscuchaIncioYFin implements ServletContextListener {
	
	//uso/cargo la configuracion del properties
	private static Logger log = Logger.getLogger("mylog");

    /**
     * Default constructor. 
     */
    public EscuchaIncioYFin() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	log.debug("debug contextInitialized - INICIO DE LA APP!");
    	log.trace("traza contextInitialized - INICIO DE LA APP!");
    	log.info("info debug contextInitialized - INICIO DE LA APP!");
    	System.out.println("contextInitialized - INICIO DE LA APP!");
    	
    	ServletContext servletContext = sce.getServletContext();
    	
    	Date fecha_inicio = new Date();//esto me da la fecha actual
    	servletContext.setAttribute("FECHA_INICIO", fecha_inicio);
    	System.out.println(fecha_inicio);
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("contextDestroyed - FIN DEL PROGRAMA");
    	
    	ServletContext servletContext = sce.getServletContext();
    	Date fecha_inicio = (Date) servletContext.getAttribute("FECHA_INICIO");
    	System.out.println("fin programa iniciado " + fecha_inicio);
    	
    }

	
	
}
