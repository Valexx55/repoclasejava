package proyecto1.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MainFicheros {

	public static void main(String[] args) /*throws IOException*/ {
		
		//APIS "CLÁSICAS" --> java.io // INPUT OUTPUT
			// File, FileWriter, FileReader, BufferedWriter ...
		
		//API FICHEROS "MODERNAS" --> NIO2  New Input Output
		
			// Path , Files
			// Path REPRESENTA un fichero o una carpeta
		    // Files SIRVE para trabjar con Paths (ficheros o carpetas)
		
		//vamos a trabjar con un fichero y vamos ver
		//si existe, no hago nada --> informo que existe
		//si no existe, lo voy a crear
		
		Path path = Path.of("./nuevo.txt");
		//Path path = Path.of("./consejos.txt");
		
		boolean existe = Files.exists(path);
		
		System.out.println("El path es "  + path);
		
		if (existe)
		{
			System.out.println("El fichero existe, vamos a escribir algo");
			try {
				String salto_linea = System.getProperty("line.separator");
				//System.out.println((int)salto_linea.charAt(0));
				//System.out.println((int)salto_linea.charAt(1));
				//Files.writeString(path, "\"HOLA DON PEPITO\"\n", StandardOpenOption.APPEND);
				Files.writeString(path, "HOLA DON PEPITO" + salto_linea, StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
		{
			System.out.println("El fichero NO existe, lo creo");
			try {
				Files.createFile(path);
				System.out.println("FICHERO CREADO");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Error creando el fichero");
			}
		}
		
		
		
	}
}
