package bdjava.mapas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import bdjava.MainBaseDatos;
import bdjava.Paciente;
import bdjava.RegistroIMC;
import bdjava.RepositorioIMC;
import bdjava.TipoIMC;

public class MainMaps {

	
	//List<T> listamapas;
	
	public static void main(String[] args) throws Exception {
		
		//quiero crear un mapa donde tenga el paciente de la base de datos
		//asociado a sus registros
		
		//Map<Integer, V>
		//Map<Integer, List<RegistroIMC>> mapPacientes = null;
		//List<RegistroIMC> listaP1 = mapPacientes.get(1);
		//mapPacientes = obtenerRegistroPaciente(1); 
		//en los mapas las claves no se repiten
		//System.out.println(mapPacientes);
		//System.out.println("NUMERO DE CLAVES " + mapPacientes.keySet().size());
		
		//¿?Cunatos registros tiene el paciente 1?ç
		//System.out.println("El paciente 1 tiene " + mapPacientes.get(1).size() + " registros");
		
		//SOLUOCION ADRI
		RepositorioIMC repositorioIMC = new RepositorioIMC();
		
		Map<Integer, List<RegistroIMC>> mapaIdPacienteRegistrosIMC = new HashMap<Integer, List<RegistroIMC>>();
		
		Map<Paciente, List<RegistroIMC>> mapaPacienteRegistrosIMC = new HashMap<>();
		//recuperamos todos los pacientes de la bbdd
		List<Paciente> listaPacientes = repositorioIMC.leerTodosLosPacientes();

		//por cada paciente recuperamos sus registros IMC y los añadimos a el mapa
		for(Paciente p : listaPacientes) {
			List<RegistroIMC> registrosIMCPorUsuario = repositorioIMC.leerRegistrosIMCPorPaciente(p.getId());
			mapaIdPacienteRegistrosIMC.put(p.getId(), registrosIMCPorUsuario);
			System.out.println(p);
			mapaPacienteRegistrosIMC.put(p, registrosIMCPorUsuario);
		}
		
		//System.out.println("MAPA ADRI " + mapaIdPacienteRegistrosIMC);
		
		Set<Integer> claves = mapaIdPacienteRegistrosIMC.keySet();
		Iterator<Integer> it =  claves.iterator();
		int id_paciente;
		List<RegistroIMC> listaRegistrosAux;
		while (it.hasNext())
		{
			id_paciente = it.next();
			System.out.println("PACIENTE " + id_paciente );
			listaRegistrosAux = mapaIdPacienteRegistrosIMC.get(id_paciente);
			System.out.println(listaRegistrosAux);
		}
				
		//[id=1, nombre=VINICIUS, edad=20]
		Paciente vini =  new Paciente();
		vini.setId(1);
		vini.setNombre("VINICIUS");
		vini.setEdad(20);
		
		Paciente rafa =  new Paciente();
		rafa.setId(35);
		rafa.setNombre("RAFA");
		rafa.setEdad(50);
		
		List<RegistroIMC> lr1 = mapaPacienteRegistrosIMC.get(vini);
		
		List<RegistroIMC> lr2 = mapaPacienteRegistrosIMC.get(rafa);
		
		
		//mapaIdPacienteRegistrosIMC.hashCode()--> dirección de memoria del objeto
		
		//RepositorioIMC repositorioIMC =  new RepositorioIMC();
		/*List<RegistroIMC> listaRegistros = repositorioIMC.leerTodosRegistrosIMC();
		
		Map<Integer, List<RegistroIMC>> m = listaRegistros.stream().collect(Collectors.groupingBy(r -> r.getPaciente().getId()));
		System.out.println("\n\n\nMAPA VALE TOTAL = " + m);*/
		
		
		
		/*Map<Paciente, List<RegistroIMC>> mapPacientes2 = null;
		List<RegistroIMC> listaP2 = mapPacientes2.get(new Paciente());*/
	}

	private static Map<Integer, List<RegistroIMC>> obtenerRegistroPaciente (int idpaciente)
	{
		Map<Integer, List<RegistroIMC>> mapaDev = null;
		
			List<RegistroIMC> listaRegistroPaciente = obtenerListaRegistrosPaciente(idpaciente);
			mapaDev = new HashMap<Integer, List<RegistroIMC>>();
			mapaDev.put(idpaciente, listaRegistroPaciente);
		
		return mapaDev;
	}
	
	private static List<RegistroIMC> obtenerListaRegistrosPaciente (int idpaciente)
	{
		List<RegistroIMC> listaRegs = null;
		
		{
			listaRegs = new ArrayList<RegistroIMC>();
			
			
			try (Connection connection = DriverManager.getConnection(MainBaseDatos.CADENA_CONEXION, MainBaseDatos.USUARIO, MainBaseDatos.CONTRASENIA);) 
			{
				PreparedStatement instruccion = connection.prepareStatement(MainBaseDatos.CONSULTA_SELECCION_REGISTRO_POR_ID);
				instruccion.setInt(1, idpaciente);
				ResultSet resultados =  instruccion.executeQuery();
				System.out.println("consulta ejecutada");
				//id fecha peso altura imc num imc nom
				int idaux;
				Date fecha;
				float peso, altura, imc_num;
				TipoIMC imc_nom;
				
				RegistroIMC registroIMCAux = null;
				
				while (resultados.next()) {
					 idaux = resultados.getInt(1);
					 fecha = resultados.getDate(2);
					 peso = resultados.getFloat(3);
					 altura = resultados.getFloat(4);
					 imc_num = resultados.getFloat(5);
					 imc_nom = TipoIMC.valueOf(resultados.getString(6));
					 
					 registroIMCAux = new RegistroIMC(idaux, fecha, imc_num, altura, peso, imc_nom, null);
					 listaRegs.add(registroIMCAux);
					
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			
		}
		
		return listaRegs;
	}
	
	
	
}
