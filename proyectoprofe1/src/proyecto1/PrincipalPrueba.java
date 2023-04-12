package proyecto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PrincipalPrueba {

	/**
	 * 
	 * HACED UNA APP QUE CREE TANTOS DNIS COMO NOMBRES RECIBA POR PARÁMETRO
	 * 
	 * NOMBRES, POR PARÁMETRO
	 * 
	 * ESOS NOMBRES, SERÁN LOS NOMBRES DE CADA DNI
	 * 
	 * EL NÚMERO, ALEATORIO RANDOM USAR LA FUNCIÓN PARA GENERAR UN NÚMERO ALEATORIO
	 * 
	 * LA LETRA, LA QUE CORRESPONDA
	 * 
	 * APLICAR EL ALGORITMO DEL MINISTERIO, PARA SACAR LA LETRA DE ESE NUMERO
	 * OBTENIDO AUTOMÁTICAMENTE
	 * 
	 * UNA VEZ TENGAMOS Nombre, Número y Letra, ya podemos construir el Objeto DNI
	 */

	public static void main(String[] nombres) {

		// Y7863318 (T)
		/*
		 * Scanner scanner = new Scanner(System.in); scanner.nextFloat()
		 */
		Dni nie_ari = new Nie(7863318, "Ariana", 'Y'); // T
		char letra = nie_ari.calcularLetra();
		nie_ari.setLetra_dni(letra);

		boolean correcto = Dni.esDniCorrecto(nie_ari);
		System.out.println(correcto);

		// el objeto nie_ari es

		// a) Un NIE
		// b) UN DNI
		// c) Ambos x

		Dni dni_frank = new Dni(6662884, "Frank"); // 6924792N
		Nie nie_novia_frank = new Nie(6924792, "MAngela", 'Y');

		// casting -- CONVERTIR UN OBJETO NIE A UN OBJETO DNI
		// si el nie_novia_frank es un Dni, lo convierto
		if (nie_novia_frank instanceof Dni) {
			Dni dni_convertido = (Dni) nie_novia_frank;// -- SUPERCASTING
		}
		
		if (nie_novia_frank instanceof Dni d) { //pattern mathching - j16
			System.out.println(d);
		}

		// casting -- CONVERTIR UN OBJETO DNI A UN OBJETO NIE
		// Nie nie_convertido = (Nie) dni_convertido;//-- INFRACASTING

		if (dni_frank instanceof Object) {

			Object objeto_fran = (Object) dni_frank;
		}

		if (nie_novia_frank instanceof Object)
		{
			Object object_novia = (Object) nie_novia_frank;
		}
		

		var nuevonumero = 37.6; //java 11 - inferncia --lo podemos usar como varialbe local
		
		var var_dni = new Dni(6662884, "Frank"); // 6924792N;
		
		if (var_dni instanceof Dni)
		{
			System.out.println("var dni es un DNI");
		}
		
		float numero_decimal_real = (float) 3.45;
		float numero_decimal_real1 = 3.45f;
		float n = 5.03f;

		String palabra = new String("expresion");
		System.out.println(palabra.length());

		palabra = new String("real");
		System.out.println(palabra.length());

		int numero = Integer.parseInt("346");
		System.out.println(numero);

		Integer objeto_num = 8;
		objeto_num.parseInt("98");

		/*
		 * System.out.println("La letra del NIE de ARi es = " + letra);
		 * 
		 * Dni nie_val = new Nie(53130984, "Vale", 'X');//H letra =
		 * nie_val.calcularLetra(); System.out.println("La letra del NIE de Val es = " +
		 * letra);
		 * 
		 * Random random = new Random(); Dni dni_nuevo = null; //genéricos <> List<Dni>
		 * lista_dnis = new ArrayList<Dni>();//<> operador diamante for (String nombre :
		 * nombres) //recorro la lista de nombres que recibo como entrada { //TODO si
		 * estoy en un número par, creo un DNI //TODO si estoy en un número impar, creo
		 * un NIE //TODO sobrescribir el método calcularLetra, para que se tenga en
		 * cuenta el prefijo //en el caso de NIE
		 * //https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-
		 * gestiones/dni/calculo-del-digito-de-control-del-nif-nie/
		 * 
		 * //5313098 - H //Z5313098 - S
		 * 
		 * int numdni_aleatorio = random.nextInt(Dni.NUM_MAX_DNI);//calculo un número
		 * aleatorio dni_nuevo =new Dni(numdni_aleatorio, nombre);//creo un dni con el
		 * nombre actual y el número char letra_calculada =
		 * dni_nuevo.calcularLetra();//calculo la letra de ese número
		 * dni_nuevo.setLetra_dni(letra_calculada);//le asigno la letra calculada a ese
		 * DNI
		 * 
		 * lista_dnis.add(dni_nuevo);
		 * 
		 * 
		 * }
		 */

		/*
		 * for (Dni documento : lista_dnis) { System.out.println(documento.getNombre() +
		 * " " + documento.getNumero_dni() + " "+ documento.getLetra_dni()); }
		 */

		// TODO: ver el nuevo SWTICH de JAVA 14

		/**
		 * public static String calcularLetraDNI(int ndni) { String letra = ""; int
		 * nletra = ndni % 23;
		 * 
		 * switch(nletra) { case 0: letra = "T"; break; case 1: letra = "R"; break; case
		 * 2: letra = "W"; break; case 3: letra = "A"; break; case 4: letra = "G";
		 * break; case 5: letra = "M"; break; case 6: letra = "Y"; break; case 7: letra
		 * = "F"; break; case 8: letra = "P"; break; case 9: letra = "D"; break; case
		 * 10: letra = "X"; break; case 11: letra = "B"; break; case 12: letra = "N";
		 * break; case 13: letra = "J"; break; case 14: letra = "Z"; break; case 15:
		 * letra = "S"; break; case 16: letra = "Q"; break; case 17: letra = "V"; break;
		 * case 18: letra = "H"; break; case 19: letra = "L"; break; case 20: letra =
		 * "C"; break; case 21: letra = "K"; break; case 22: letra = "E"; break;
		 * default: } return letra; }
		 */
	}

}
