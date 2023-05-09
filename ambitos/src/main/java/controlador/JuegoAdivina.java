package controlador;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JuegoAdivina
 */
@WebServlet("/JuegoAdivina")
public class JuegoAdivina extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final int MAX_VIDAS = 5;//el número de intentos 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JuegoAdivina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession(false);//
		
		if ((session!=null)&&(session.getAttribute("num_secreto")!=null)) //caso especial, tiene sesión, pero ha perdido
		{
			String mensaje_respuesta = "";
			System.out.println("el usuario tiene una partida en curso");
			int num_usuario  = Integer.parseInt(request.getParameter("numero"));
			int num_secreto = (int) session.getAttribute("num_secreto");
			if (num_secreto==num_usuario)
			{
				System.out.println("HA ACERTADO el número!");
				mensaje_respuesta ="HAS GANADO CHAMPION";
				session.invalidate();//vacía el saco de la sessión 
				
			}else {
				System.out.println("HA FALLADO el número!");
				int vidas = (int) session.getAttribute("vidas");
				if (vidas==0)
				{
					System.out.println("HA AGOTADO los intentos");
					mensaje_respuesta ="GAME OVER FIN DE PARITDA - El número era " +num_secreto;
					session.invalidate();//vacía el saco de la sessión 
					//? actualizar intentos
					
				} else {
					System.out.println("LE QUEDAN INTENTOS los intentos");
					vidas = vidas-1;
					session.setAttribute("vidas", vidas);
					//https://lineadecodigo.com/java/el-operador-ternario-en-java/
					mensaje_respuesta =  (num_secreto > num_usuario) ? "El numero buscado es MAYOR" : "El numero buscado es MENOR";
					
				}
			}
			request.setAttribute("mensaje_respuesta", mensaje_respuesta);
		} else {
			System.out.println("debemos iniciar una nueva partida");
			//creo sesión
			session = request.getSession();//creo una sesion nueva
			//genero número secreto
			Random random = new Random();
			int numero_secreto = random.nextInt(100) + 1;//[0, 100)
			System.out.println("Numero secreoto generado " + numero_secreto);
			session.setAttribute("num_secreto", numero_secreto);
			//inicio vidas
			session.setAttribute("vidas", MAX_VIDAS);
			System.out.println("Usuario empieza con " + MAX_VIDAS + " vidas");
			
			
		}
		//le mando la salida de un JSP
		request.getRequestDispatcher("juego.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
