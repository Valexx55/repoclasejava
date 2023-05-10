package propiedades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * TENEMOS 3 FICHEROS DE PROPIEDADES CON LA MISMA HISTORIA EN DISTINTOS IDIOMAS
 * 
 * RECIBIMOS POR ARGUMNETOS, EL IDIOMA ELEGIDO - ESPAÑOL (es) - INGLÉS (en) -
 * ITALIANO (it)
 * 
 * EL FICHERO, con independencia del idiona, TIENE las siguientes
 * propiedades/claves:
 * 
 * start: contiene el inicio del cuento body: la parte principal end: el final
 * outfile: nombre de un fichero
 * 
 * TODO: Construir un fichero de salida con el idioma elegido
 * 
 * 
 * 
 * @author USUARIO
 *
 */


public class MainCuento {

	public static void main(String[] args) throws Exception, IOException {
		
		System.out.println(args);
		//args[0] puede ser it, en, es
		for (String parametro : args)
		{
			System.out.println(parametro);
		}
		
		Properties properties  = new Properties();
		//File f = new File ("story_es.properties");
		//System.out.println(f.toPath().toAbsolutePath());
		
		properties.load(new FileReader("./story_es.properties"));
		String propiedadCuento =  properties.getProperty("body");
		System.out.println(propiedadCuento);
		
		
	}
}
