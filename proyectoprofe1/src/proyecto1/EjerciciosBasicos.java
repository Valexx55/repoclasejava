package proyecto1;

import java.io.IOException;

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
 * 3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO esPar 4) HACER UN
 * MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO
 * mayorDeEdad 5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI
 * EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE clasificarNota 6)
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
		boolean pertenece = perteneceACadena("hola me gusta el jamón", 'j');// parámetros actuales
		System.out.println("Pertenece = " + pertenece);
		pertenece = perteneceACadena("hola", 'p');// parámetros actuales
		System.out.println("Pertenece = " + pertenece);
		pertenece = perteneceACadena("optimizado", 'm');// parámetros actuales
		System.out.println("Pertenece = " + pertenece);

	}
}