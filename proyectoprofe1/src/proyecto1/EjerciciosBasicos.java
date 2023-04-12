package proyecto1;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:
 * 
 * 1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER
 * PERTENECE A LA CADENA O NO perteneceACadena 2) HACER UN MÉTODO QUE RECIBA UNA
 * CADENA Y UN CARACTER Y DIGA CÚANTAS VECES APARECE ESE CARACTER EN LA CADENA
 * 2.1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA la última
 * posición donde aparece ese caracter en esa cadena. Si no está, devuelve -1
 * 
 * "hola" a --> 3 "maja" a --> 3 "conejo" i --> -1
 * 
 * 
 * 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar
 * 
 * 4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE
 * EDAD O NO mayorDeEdad 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA
 * SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota 6)
 * HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS invertirCadena 7)
 * HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99 deTresEnTres
 *
 *
 * // DEFINO UN MÉTODO // DARLE UN NOMBRE - camelCase // ID la entrada - // ID
 * la salida -
 *
 * //pensar el los pasos en esapñol en psuedocódigo
 */
public class EjerciciosBasicos {
	
	/**
	 * 
	 */
	public static void deTresEnTres2 ()
	{
		String secuencia = "3";
		
			for(int i=6; i<=99; i=i+3) {
				secuencia = secuencia + ", "+ i;//al ser inmutable el string, cada vez que lo modifico, intrermante se crea otro
			}
		
			System.out.println(secuencia);
	}
	
	public static void deTresEnTres3 ()
	{
		StringBuilder secuencia = new StringBuilder("3");
		
			for(int i=6; i<=99; i=i+3) {
				secuencia.append(", "+ i); //al ser mutable, se modifica siempre la misma variable
			}
		
			System.out.println(secuencia);
	}


	
	
	public static void deTresEnTres ()
	{
		int numero = 3;
		do {
			System.out.println(numero);
			numero = numero + 3;
		}while (numero<=99);
	}

	public static String invertirCadena1(String cadena) {
		String cadena_reves = "";//NO PUEDO "METER MANO" operar con un objeto que vale NULL porque me da fallo

		for (int i = cadena.length() - 1; i >= 0; i = i - 1) {
			cadena_reves = cadena_reves + cadena.charAt(i);
		}

		return cadena_reves;
	}

	public static String invertirCadena2(String cadena) {
		String cadena_reves = null;
		StringBuilder sb = new StringBuilder(cadena);
		
			 cadena_reves = sb.reverse().toString();
		
		return cadena_reves;
	}

	public static String traducirNotaNumericaNuevoSwitchJava14(int nota) {
		String nota_alfabetica = null;

		// más breve
		// no hace break
		// usa la flecha
		// el propio switch devuelve un valor
		// yield "asignar"

		nota_alfabetica = switch (nota) {
		case 0, 1, 2, 3, 4 -> "SUSPENSO";
		case 5 -> "APROBADO";
		case 6 -> "BIEN";
		case 7, 8 -> "NOTABLE";
		case 9, 10 -> "SOBRESALIENTE";
		default -> {// obligado poner llaves, cuando tengo más de 2 instrucciones
			System.out.println("El usuario introdujo una nota desconcida");
			yield "DESCONOCIDO";// obligado en este caso, poner yield precediendo al valor devuelto
		}
		};

		return nota_alfabetica;
	}

	public static String traducirNotaNumerica(int nota) {
		String nota_alfabetica = null;

		switch (nota) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			nota_alfabetica = "SUSPENSO";
			break;// NECESARIO pq si no continúa por los casos siguientes
		case 5:
			nota_alfabetica = "APROBADO";
			break;
		case 6:
			nota_alfabetica = "BIEN";
			break;
		case 7:
		case 8:
			nota_alfabetica = "NOTABLE";
			break;
		case 9:
		case 10:
			nota_alfabetica = "SOBRESALIENTE";
			break;
		}

		return nota_alfabetica;
	}

	public static boolean esMayorDeEdad() {
		boolean mayor_edad = false;
		int edad_introducida = 0;

		System.out.println("Introduce tu edad");
		Scanner scanner = new Scanner(System.in);// leemos de la entrada estandar
		edad_introducida = scanner.nextInt();

		mayor_edad = (edad_introducida >= 18);

		return mayor_edad;

	}

	public static boolean esNumeroPar(int numero) {
		boolean espar = false;

		/*
		 * if (numero % 2==0) { espar = true; }
		 *//*
			 * lse //sino { espar = false; }
			 */

		int resto = numero % 2;

		if (resto == 0) {
			espar = true;
		} else {
			espar = false;
		}

		// resto = numero % 2;

		// espar = (resto ==0);

		return espar;
	}

	/**
	 * Este método devuelve la última posición donde aparece el caracter recibido en
	 * la cadena
	 * 
	 * @param cadena   la cadena donde tengo que buscar
	 * @param caracter la letra buscada
	 * @return -1 si no está el caracter en la cadena o la posición última en caso
	 *         contrario
	 */
	public static int ultimaLetra(String cadena, char caracter_buscado) {
		int ultima_poscion = -1;
		int posicion = cadena.length() - 1;
		boolean aparecido = false;
		char caracter_actual = ' ';

		// mientras no aparezca y no llegue al 0
		while ((!aparecido) && (posicion >= 0)) {
			caracter_actual = cadena.charAt(posicion);
			if (caracter_actual == caracter_buscado) {
				aparecido = true;
				ultima_poscion = posicion; // me tengo que quedar con la última posición!
			} else {
				posicion = posicion - 1; // posicion--;
			}
		}

		return ultima_poscion;

	}

	/**
	 * Este método nos informa de si una letra está en una cadena
	 * 
	 * @param cadena   la cadena de de entrada
	 * @param caracter la letra de entrada
	 * @return true si el caracter está en la cadena o false si no
	 */
	public static boolean perteneceACadena(String cadena, char caracter_buscado)// parámetros formales
	{

		boolean esta = false;
		int longitud = 0;
		int indice = 0;
		char actual = ' ';

		longitud = cadena.length();

		// mientras no aparezca el caracter y no llegue al final
		while ((indice < longitud) && (!esta)) // esta==false
		{
			actual = cadena.charAt(indice);
			if (actual == caracter_buscado) {
				esta = true;
			} else {
				indice = indice + 1; // si no está, voy a la siguiente
			}
		}

		return esta;
	}

	public static int numVecesCharEnCadena(String palabra, char letra) {

		int nveces = 0;
		int string_length = palabra.length();

		for (int i = 0; i < string_length; i++) // recorro
		{
			if (palabra.charAt(i) == letra)// si la letra coincide
			{
				nveces++; // sumo
			}
		}

		return nveces;

	}

	public static void main(String[] args) throws IOException {

		// EjerciciosBasicos prueba = new EjerciciosBasicos();

		// 1
//		boolean pertenece = perteneceACadena("hola me gusta el jamón", 'j');// parámetros actuales
//		System.out.println("Pertenece = " + pertenece);
//		pertenece = perteneceACadena("hola", 'p');// parámetros actuales
//		System.out.println("Pertenece = " + pertenece);
//		pertenece = perteneceACadena("optimizado", 'm');// parámetros actuales
//		System.out.println("Pertenece = " + pertenece);
//		
//		
//		int ulti_pos = ultimaLetra("REAL MADRID", 'D');
//		System.out.println("ULTI_POS = " + ulti_pos);
//		ulti_pos = ultimaLetra("REAL MADRID", 'z');
//		System.out.println("ULTI_POS = " + ulti_pos);
//		
//		boolean esnumeroPar =  esNumeroPar(57);
//		System.out.println("Es par = " + esnumeroPar);
//		esnumeroPar =  esNumeroPar(88);
//		System.out.println("Es par = " + esnumeroPar);
//		
//		boolean esmayor = esMayorDeEdad();
//		System.out.println("El usurio es mayor = ? " + esmayor);

//		String nota = traducirNotaNumerica(0);
//		String nota_nuevo = traducirNotaNumericaNuevoSwitchJava14(0);
//		System.out.println(nota_nuevo);
//		System.out.println(nota_nuevo);
		
//	    String cad_reves1 = invertirCadena1("VALE");
//	    String cad_reves2 =invertirCadena2("ANDREA");
//	    System.out.println(cad_reves1);
//	    System.out.println(cad_reves2);
		/*
		 * nota = traducirNotaNumerica(5); System.out.println(nota); nota =
		 * traducirNotaNumerica(6); System.out.println(nota); nota =
		 * traducirNotaNumerica(8); System.out.println(nota); nota =
		 * traducirNotaNumerica(10); System.out.println(nota);
		 */
	    
	    deTresEnTres();
	    deTresEnTres2();

	}
}