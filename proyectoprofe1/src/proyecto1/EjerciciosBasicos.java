package proyecto1;

import java.util.Scanner;

/**
 * 
 * LISTA DE EJERCICIOS DE REPASO A LA PARTE DE INICIACIÓN EN JAVA:

1) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA SI ESE CARACTER PERTENECE A LA CADENA O NO
2) HACER UN MÉTODO QUE RECIBA UNA CADENA Y UN CARACTER Y DIGA C⁄ANTAS VECES APARECE ESE CARACTER EN LA CADENA
3) HACER UN MÉTODO QUE DADO UN NÚMERO, DIGA SI ES PAR O NO
4) HACER UN MÉTODO QUE LE PIDA AL USUARIO SU EDAD Y LE DIGA SI ES MAYOR DE EDAD O NO
5) HACER UN MÉTODO QUE RECIBA UNA NOTA DE 0 A 10 Y DIGA SI EQUIVALE A UN APROBADO, BIEN, NOTABLE, O SOBRESALIENTE
6) HACER UN MÉTODO QUE RECIBA UNA CADENA Y LA DEVUELVA ALREVÉS
7) HACER UN PROGRAMA QUE MUESTRE LA SECUENCIA 3, 6, 9, 12, 15 ...99
 *
 *
 *	// DEFINO UN MÉTODO
 *	// DARLE UN NOMBRE - camelCase
 *	// ID la entrada -
 *	// ID la salida -
 *
 *	//pensar el los pasos en esapñol en psuedocódigo
 */
public class EjerciciosBasicos {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//para leer de teclado
		System.out.println("Introduzca edad");
		int edad = scanner.nextInt();
		System.out.println("Edad introducida "+ edad);
	}

}
