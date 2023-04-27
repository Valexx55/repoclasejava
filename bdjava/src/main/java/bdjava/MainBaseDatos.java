package bdjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainBaseDatos {
	
	public static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/bdimc?serverTimezone=UTC";
	public static final String USUARIO = "root";
	public static final String CONTRASENIA = "root";
	
	private static final String CONSULTA_SELECCION_TODOS_PACIENTES = "SELECT * FROM bdimc.pacientes;";
	
	
	//Paciente paciente = listaPacientes.stream().min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad())).get();
	
	//programación funcional Streams lambda
	private static Paciente obtenerMenorVersionAdrian (List<Paciente> listaPacientes)
	{
		Paciente paciente = null;
		
			paciente = listaPacientes.stream().min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad())).get();
		
		return paciente;
	}
	
	
	private static Paciente obtenerMenorVersionClasica (List<Paciente> listaPacientes)
	{
		Paciente paciente_menor = null;
		int edad_menor = 1000;
		
			for (Paciente p: listaPacientes)
			{
				if (p.getEdad()<edad_menor)
				{
					paciente_menor= p;
					edad_menor = p.getEdad();
				}
			}
			
		return paciente_menor;
	}
	
	public static void main(String[] args) throws Exception {
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		//TODO acceder a la base de datos a leer la tabla de pacientes
		
		//0 . CARGAR EL DRIVER - en versiones antiguas de JDBC Class.forName
		
		//1 . OBTENGO LA CONEXIÓN - DriverManager
		//2 . Defino la consulta/operación/query/atacar - Statement - Select
		//3 . Procesar la respuesta - ResultSet
		//4 . Liberemos recursos - Cerrar la conexión, cierro todo - TRY con RECURSOS
		
		//final efectivo - "constante - solo se le asigna un valor una vez"
		Connection connection = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
		try (connection;) 
		{
			PreparedStatement instruccion = connection.prepareStatement(CONSULTA_SELECCION_TODOS_PACIENTES);
			ResultSet resultados =  instruccion.executeQuery();
			System.out.println("consulta ejecutada");
			int idaux;
			int edadaux;
			String nombreaux; //el ResultSet es como un puntero al registro / fila actual
			Paciente paciente_aux;
			while (resultados.next()) {
				 idaux = resultados.getInt("id");
				 edadaux = resultados.getInt("edad");
				 nombreaux = resultados.getString("nombre");
				 paciente_aux = new Paciente(idaux, nombreaux, edadaux);
				 System.out.println("Nombre = "  + nombreaux + " idaux " + idaux + " edadaux " + edadaux );
				 listaPacientes.add(paciente_aux);
				
			}
			
			//connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Paciente pacienteMenor = obtenerMenorVersionClasica (listaPacientes);
		System.out.println("EL PACIENTE MENOR " + pacienteMenor.toString());
		
		/*finally {
			if (connection!=null)
			{
				try {
					connection.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("Error al librear recursos");
				}
				
			}
			
		}*/
		
	}//main

}//clase
