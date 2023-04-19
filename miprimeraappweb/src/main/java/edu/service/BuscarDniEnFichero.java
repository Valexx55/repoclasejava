package edu.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.servlet.Dni;

public class BuscarDniEnFichero {
	
	
	private static Dni lineaFichero2Dni (String linea)
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
	
	/**
	 * Busqueda de un dni dentro del fichero, dado su número
	 * 
	 * @param cadenaDni es el número del dni que busco
	 * @return null si no encuentro el DNI asociado a es número o el DNI si existe 
	 * en el fichero
	 */
	public static Dni buscarNumeroDniEnFichero (String cadenaDni)
	{
		Dni dnibuscado = null;
		boolean encontrado = false;
		int numdniBuscado = Integer.parseInt(cadenaDni);
			
		//TRY CON RECUROS TRY WITH RESOURCES -- LOS RECURSOS SE CIERRAN SOLOS
		 try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\valer\\Documents\\CAS\\WEB SERVICIES CON J2EE IFCD07\\repoprofe\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\miprimeraappweb\\listadnis.txt")))
		 {
			//List<String> lineas= Files.readAllLines(path);
			 //leer lineas, mienteras que no aparezca el dni buscado y no llegue al final del fichero
			 String linea = null;
			 Dni dni_aux = null;
			  while ((linea = br.readLine())!=null && !encontrado)
			  {
				   dni_aux = lineaFichero2Dni(linea);
				   if (numdniBuscado == dni_aux.getNumero_dni())
				   {
					   encontrado = true;
					   dnibuscado = dni_aux;
				   }
				   
			  }
			  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return dnibuscado;
	}

}
