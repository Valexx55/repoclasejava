package edu.servlet.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import edu.servlet.Dni;

public class ListadoServiceImpl implements ListadoService {
	
	/*public static void main(String[] args) {
		
		ListadoService ls =  new ListadoServiceImpl();
		ls.obtenerListaDnis();
		
	}*/
	

	//TODO MODIFICAR ESTE SERIVCIO, PARA QUE DEVUELVA EL LISTADO DE DNIS
	@Override
	public List<Dni> obtenerListaDnis() {
		List<Dni> lista_dnis = null;
		Path path = null;
			//LEER DEL FICHERO DONDE SE GUARDAN LOS DNIS
			//Y CONFORMAR LA LISTA
			path = Path.of("C:\\Users\\valer\\Documents\\CAS\\WEB SERVICIES CON J2EE IFCD07\\repoprofe\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\miprimeraappweb\\listadnis.txt");
			 try {
				List<String> lineas= Files.readAllLines(path);
				for (String linea : lineas)
				{
					System.out.println(linea);
					//TENGO QUE PARSEAR - procesarla clasificando el contenido LA LÍNEA Y PASARLA A UN OBJETO DE DNI
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return lista_dnis;
	}

}
