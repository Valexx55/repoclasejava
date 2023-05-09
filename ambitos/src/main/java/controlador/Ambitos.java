package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ambitos
 */
@WebServlet("/Ambitos")
public class Ambitos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ambitos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//REQUEST
			//EXISTE EL ATRIBUTO NUMVECES EN LA REQUEST?
			if (null!=request.getAttribute("numveces"))
			 
			//SI EXISTE, LE SUMO UNO
			{
				request.setAttribute("numveces", (int)request.getAttribute("numveces")+1);
			}
			//SI NO EXISTE, LO CARGO A 1
			else {
				request.setAttribute("numveces", 1);
			}
		
		//SESSION
			HttpSession sesion = request.getSession(true);//si existe una sesion, me la recupera y si no, me crea una
			System.out.println("ID SESION = " +sesion.getId());
			if (null!=sesion.getAttribute("numvecessesion"))
				 
				//SI EXISTE, LE SUMO UNO
				{
					sesion.setAttribute("numvecessesion", (int)sesion.getAttribute("numvecessesion")+1);
				}
				//SI NO EXISTE, LO CARGO A 1
				else {
					sesion.setAttribute("numvecessesion", 1);
				}
		//CONTEXTO-APLICACION
			if (null!=getServletContext().getAttribute("numvecesapp"))
				 
				//SI EXISTE, LE SUMO UNO
				{
				getServletContext().setAttribute("numvecesapp", (int)getServletContext().getAttribute("numvecesapp")+1);
				}
				//SI NO EXISTE, LO CARGO A 1
				else {
					getServletContext().setAttribute("numvecesapp", 1);
				}
			//EXISTE EL ATRIBUTO NUMVECES EN LA APLICACION?
			//SI EXISTE, LE SUMO UNO
			//SI NO EXISTE, LO CARGO A 1
		request.getRequestDispatcher("ambitos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
