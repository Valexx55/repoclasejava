package bdjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class RepositorioIMC {
	
	//clase de acceso a datos
	// DAO Data Acces Object
	//Persistencia
	
	//TODO VAMOS A HACER LAS OPERACIONES CON BASE DATOS DE:
	
	
	//1 INSERTAR PACIENTE
	//INSERT INTO `bdimc`.`pacientes` (`nombre`, `edad`) VALUES ('JUAN', '41');
	
	//multilinea TextBlock java 14 """ 
	private static final String INSERTAR_PACIENTE="""
			INSERT INTO `bdimc`.`pacientes` 
			(`nombre`, `edad`) 
			VALUES (?, ?);
			""";
	//INSERT INTO `bdimc`.`historico_imcs` (`fecha`, `peso`, `altura`, `imc_num`, `imc_nom`, `idpaciente`) VALUES (CURDATE(), '50', '2', '60', 'IDEAL', 25);
	
	private static final String INSERTAR_REGISTRO_IMC="""
			INSERT INTO `bdimc`.`historico_imcs` 
			(`fecha`, `peso`, `altura`, `imc_num`, `imc_nom`, `idpaciente`) 
			VALUES (?, ?, ?, ?, ?, ?);
			""";
	
	public static void main(String[] args) throws SQLException {
		
		Paciente paciente = new Paciente(1, "Vinicius", 20);
		RepositorioIMC repositorioIMC = new RepositorioIMC();
		/*if (repositorioIMC.insertarPaciente(paciente))
			System.out.println("Registro insertado correctamente :)");
		else {
			System.out.println("Registro NO insertado :(");
		}*/
		
		RegistroIMC registroIMC = new RegistroIMC(0, new Date(), 20, 2, 70, TipoIMC.DELGADO, paciente);
		if (repositorioIMC.insertarRegistro(registroIMC))
			System.out.println("Registro insertado correctamente :)");
		else {
			System.out.println("Registro NO insertado :(");
		}
	}
	
	public boolean insertarPaciente (Paciente paciente) throws SQLException
	{
		boolean ok = false;
		Connection connection = DriverManager.getConnection(MainBaseDatos.CADENA_CONEXION, MainBaseDatos.USUARIO,MainBaseDatos.CONTRASENIA);
		//por defecto, la conexion es autocommit a trues
		//connection.setAutoCommit(false);
		// connection = DriverManager.getConnection(MainBaseDatos.CADENA_CONEXION, MainBaseDatos.USUARIO,MainBaseDatos.CONTRASENIA);
		
		try (connection;)//Try con recursos 9 --> variables final efectivo! sólo asignadas una vez
		{
			PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_PACIENTE);
			preparedStatement.setString(1, paciente.getNombre());
			preparedStatement.setInt(2, paciente.getEdad());
			
			int res = preparedStatement.executeUpdate();//el número de filas afectadas
			ok = res == 1;//he modificado 1 registros
			//connection.commit();//confirmo
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		return ok;
	}
	//2 INSERTAR REGISTRO HISTORICO DE IMC
	
	public boolean insertarRegistro (RegistroIMC registroIMC) throws SQLException
	{

		boolean ok = false;
		Connection connection = DriverManager.getConnection(MainBaseDatos.CADENA_CONEXION, MainBaseDatos.USUARIO,MainBaseDatos.CONTRASENIA);
		
		// connection = DriverManager.getConnection(MainBaseDatos.CADENA_CONEXION, MainBaseDatos.USUARIO,MainBaseDatos.CONTRASENIA);
		
		try (connection;)//Try con recursos 9 --> variables final efectivo! sólo asignadas una vez
		{
			PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR_REGISTRO_IMC);
			//(`fecha`, `peso`, `altura`, `imc_num`, `imc_nom`, `idpaciente`)
			//de un tipo java.util.Date- tengo en JAVA
			//debo sacar el java.sql.Date - me pide setDate
			java.sql.Date fecha_bd = new java.sql.Date(registroIMC.getFecha_registro().getTime());
			preparedStatement.setDate(1, fecha_bd);
			preparedStatement.setFloat(2, registroIMC.getPeso());
			preparedStatement.setFloat(3, registroIMC.getAltura());
			preparedStatement.setFloat(4, registroIMC.getImc_num());
			preparedStatement.setString(5, registroIMC.getTipoIMC().name());
			preparedStatement.setInt(6, registroIMC.getPaciente().getId());
			
			int res = preparedStatement.executeUpdate();//el número de filas afectadas
			ok = res == 1;//he modificado 1 registros*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		return ok;
	
		
	}
	
	//3 CONSULTAR REGISTROS IMC TODOS //SELECT * FROM bdimc.historico_imcs;
	//4 CONSULTAR REGISTROS POR UN RANGO DE PESO
	//5 CONSULTAR LOS REGISTRO DE IMC DADO UN ID DE LA PACIENTE
	
	//COMPRAR (Usuario, Tarjeta, Fecha)
	//{TRANSACCIÓN 
		/**
		 * try {
		 * 0=) obtengo conexió
		 * 1) marca el asiento como reservado
		 * 2) efectua el pago
		 * 3) asiento contable
		 * 4) comit;
		 * }	catch ()
		 * {
		 * rollback;
		 */
	//}

}
