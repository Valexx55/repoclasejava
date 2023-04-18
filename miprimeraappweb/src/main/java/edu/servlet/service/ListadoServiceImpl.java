package edu.servlet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import edu.servlet.Dni;

public class ListadoServiceImpl implements ListadoService {
	
	/*public static void main(String[] args) {
		
		ListadoService ls =  new ListadoServiceImpl();
		ls.obtenerListaDnis();
		
	}*/
	
	private Dni lineaFichero2Dni (String linea)
	{
		Dni dni = null;
		String [] array_dni = null;
		
			array_dni = linea.split("-");//10-X-MESSI
			int num_dni = Integer.parseInt(array_dni[0]);
			char letra = array_dni[1].charAt(0);//letra
			String nombre = array_dni[2];//nombre
    		dni = new Dni(num_dni, letra, nombre);
		
		return dni;
	}

	//TODO MODIFICAR ESTE SERIVCIO, PARA QUE DEVUELVA EL LISTADO DE DNIS
	@Override
	public List<Dni> obtenerListaDnis() {
		List<Dni> lista_dnis = null;
		Path path = null;
		Dni dni_aux = null;
			
			//path = Path.of("./listadnis.txt");
			 path = Path.of("C:\\Users\\valer\\Documents\\CAS\\WEB SERVICIES CON J2EE IFCD07\\repoprofe\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\miprimeraappweb\\listadnis.txt");
			 try {
				List<String> lineas= Files.readAllLines(path);
				lista_dnis = new ArrayList<Dni>();
				for (String linea : lineas)
				{
					System.out.println(linea);
					dni_aux = lineaFichero2Dni(linea);
					lista_dnis.add(dni_aux);
				}
				System.out.println("LISTA DNIS = "+lista_dnis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return lista_dnis;
	}
	

}
