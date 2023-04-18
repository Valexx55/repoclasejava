package proyecto1.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import proyecto1.Dni;



public class ListadoServiceImpl implements ListadoService {
	
	public static void main(String[] args) {
		
		ListadoService ls =  new ListadoServiceImpl();
		ls.obtenerListaDnis();
		
	}
	

	//TODO MODIFICAR ESTE SERIVCIO, PARA QUE DEVUELVA EL LISTADO DE DNIS
	@Override
	public List<Dni> obtenerListaDnis() {
		List<Dni> lista_dnis = null;
		Path path = null;
			//LEER DEL FICHERO DONDE SE GUARDAN LOS DNIS
			//Y CONFORMAR LA LISTA
			path = Path.of("./listadnis.txt");
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
