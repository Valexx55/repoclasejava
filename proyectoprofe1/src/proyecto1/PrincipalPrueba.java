package proyecto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PrincipalPrueba {
	
	/**
	 * 
	 * HACED UNA APP QUE CREE TANTOS DNIS 
	 * COMO NOMBRES RECIBA POR PARÁMETRO
	 * 
	 * NOMBRES, POR PARÁMETRO
	 * 
	 * ESOS NOMBRES, SERÁN LOS NOMBRES DE CADA DNI
	 * 
	 * EL NÚMERO, ALEATORIO RANDOM
	 * USAR LA FUNCIÓN PARA GENERAR UN NÚMERO ALEATORIO 
	 * 
	 * LA LETRA, LA QUE CORRESPONDA
	 * 
	 * APLICAR EL ALGORITMO DEL MINISTERIO, PARA SACAR LA LETRA
	 * DE ESE NUMERO OBTENIDO AUTOMÁTICAMENTE
	 * 
	 * UNA VEZ TENGAMOS Nombre, Número y Letra, ya podemos construir el Objeto DNI
	 */
	
	public static void main(String[] nombres) 
	{
		
		
		Random random = new Random();
		Dni dni_nuevo = null;
		//genéricos <>
		List<Dni> lista_dnis = new ArrayList<Dni>();//<> operador diamante
		for (String nombre : nombres) //recorro la lista de nombres que recibo como entrada 
		{
			//TODO si estoy en un número par, creo un DNI
			//TODO si estoy en un número impar, creo un NIE
			//TODO sobrescribir el método calcularLetra, para que se tenga en cuenta el prefijo 
			//en el caso de NIE
			//https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/
			
			//5313098 - H
			//Z5313098 - S
			
			int numdni_aleatorio = random.nextInt(Dni.NUM_MAX_DNI);//calculo un número aleatorio
			dni_nuevo =new Dni(numdni_aleatorio, nombre);//creo un dni con el nombre actual y el número
			char letra_calculada = dni_nuevo.calcularLetra();//calculo la letra de ese número
			dni_nuevo.setLetra_dni(letra_calculada);//le asigno la letra calculada a ese DNI
			
			lista_dnis.add(dni_nuevo);
			
		
		}
		
		for (Dni documento : lista_dnis)
		{
			System.out.println(documento.getNombre() + " " + documento.getNumero_dni() + " "+ documento.getLetra_dni());
		}
		
		//TODO: ver el nuevo SWTICH de JAVA 14
		
		/**
		 * 	public static String calcularLetraDNI(int ndni)
	{
	String letra = "";
	int nletra = ndni % 23;
		
		switch(nletra) {
		  case 0:
			  letra = "T";
		    break;
		  case 1:
			  letra = "R";
		    break;
		  case 2:
			  letra = "W";
			    break;
		  case 3:
			  letra = "A";
			    break;
		  case 4:
			  letra = "G";
		    break;
		  case 5:
			  letra = "M";
		    break;
		  case 6:
			  letra = "Y";
			    break;
		  case 7:
			  letra = "F";
			    break;
		  case 8:
			  letra = "P";
		    break;
		  case 9:
			  letra = "D";
		    break;
		  case 10:
			  letra = "X";
			    break;
		  case 11:
			  letra = "B";
			    break;
		  case 12:
			  letra = "N";
		    break;
		  case 13:
			  letra = "J";
		    break;
		  case 14:
			  letra = "Z";
			    break;
		  case 15:
			  letra = "S";
			    break;
		  case 16:
			  letra = "Q";
			    break;
		  case 17:
			  letra = "V";
			    break;
		  case 18:
			  letra = "H";
		    break;
		  case 19:
			  letra = "L";
		    break;
		  case 20:
			  letra = "C";
			    break;
		  case 21:
			  letra = "K";
			    break;
		  case 22:
			  letra = "E";
			    break;
		  default:
		}
		return letra;
	}
		 */
	}

}
