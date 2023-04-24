package imcweb.controller;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EscuchaIncioYFin
 *
 */
@WebListener
public class EscuchaIncioYFin implements ServletContextListener {

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
