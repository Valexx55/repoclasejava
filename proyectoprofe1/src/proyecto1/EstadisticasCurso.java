package proyecto1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * En esta clase vamos a programar un par de métodos sobre las estadísticas del
 * curso
 * 
 * @author valer
 *
 */
public class EstadisticasCurso {

	// TODO vamos a hacer 2 métodos
	/*
	 * 1- Haced un método que, basadnonos en las opionones de lo sunos nos imprima
	 * por pantalla el mínimo, el máximo, la media y la moda, respecto del nivel de
	 * dificultad apreciado
	 *
	 * 2- Entedemos que el curso va bien, si el 80% de los alumnos estiman la
	 * dificultad entre los niveles 2 y 4. Haced un método que nos diga, si el curso
	 * va bien o no
	 * 
	 */

	// int opinion_alumno_1 = 1;

	static int[] opiniones_alumnos = { 4, 4, 2, 2, 4, 2, 1, 4, 3, 2, 2, 4, 2, 4, 1, 4, 1 };
	// static List<Integer> lista_opiniones = List.of(4, 4, 2, 2, 4 , 2 , 1, 4 , 3,
	// 2 , 2, 4, 2, 4, 1, 4, 1);

	public static void main(String[] args) {

		boolean cursook = cursoVaBien(opiniones_alumnos);
		boolean cursookm = cursoVaBienMohamed(opiniones_alumnos);
		boolean cursooka = cursoVaBienAdri(opiniones_alumnos);
		System.out.println("CURSO VA BIEN = " + cursook);
		System.out.println("CURSO VA BIEN = " + cursookm);
		System.out.println("CURSO VA BIEN = " + cursooka);

		generarInformeEstadisticosCursoJuan(opiniones_alumnos);
		generarInformeEstadisticosCursoSofia(opiniones_alumnos);

	}

	public static void generarInformeEstadisticosCurso(int[] opiniones) {
		// obtener el maximo e imprimirlo
		// recorrer el array y quedarme con el máximo
		// obtener el mínimo e imprimirlo
		//// recorrer el array y quedarme con el mínimo
		// obtener la media e imprimirla
		// recorrer el array, id sumando los valores y dividirlo entre la cantidad de
		// elemntos, imprimirla

		// obtener la moda e imprimirla
		// recorrer el array, id contando el número de apariciones de cada valor (1 a 5)
		// , y quedarme con el que más

	}

	public static boolean cursoVaBien(int[] opiniones) {
		boolean vabien = false;
		int opinionesEntre2y4 = 0;
		int opinion_actual = 0;

		// recorrer el array, id contando las opiniones que están en 2 y 4
		for (int indice = 0; indice < opiniones.length; indice++) {
			System.out.println(opiniones[indice]);
			opinion_actual = opiniones[indice];
			if ((opinion_actual >= 2) && (opinion_actual <= 4)) {
				opinionesEntre2y4 = opinionesEntre2y4 + 1;// sumo uno a la variable
				// opinionesEntre2y4++;//otro forma alternativa de sumar uno
			}
		}
		System.out.println("Entre 2 y cuatro, tengo, " + opinionesEntre2y4);

		// comprobobar si ese número es más o igual del 80% del total o menos
		float porcentaje_entre_2_y_4 = (opinionesEntre2y4 * 100 / opiniones.length);
		System.out.println("Porcetaje = " + porcentaje_entre_2_y_4);

		if (porcentaje_entre_2_y_4 >= 80) {
			vabien = true;
		} else {
			vabien = false;
		}

		return vabien;
	}

	public static boolean cursoVaBienMohamed(int[] opiniones) {
		boolean vabien = false;
		int opinionEnRango2_4 = 0;

		// recorrer el array, id contando las opiniones que están en 2 y 4
		for (int i = 0; i < opiniones.length; i++) {
			int j = opiniones[i];
			if (j >= 2 && j <= 4) {
				opinionEnRango2_4++;
			}
			;
		}

		// comprobobar si ese número es más o igual del 80% del total o menos
		if (opinionEnRango2_4 * 100 / opiniones.length >= 80) {
			vabien = true;
		}
		;

		return vabien;
	}

	public static boolean cursoVaBienAdri(int[] opiniones) {
		boolean vaBien = false;

		/*
		 * IntStream intStream = Arrays.stream(opiniones); intStream.
		 */
		List<Integer> listaOpiniones = Arrays.stream(opiniones).boxed().collect(Collectors.toList());

		Long numeroOpinionesEntre2Y4 = listaOpiniones.stream().filter(opinion -> (opinion >= 2 && opinion <= 4))
				.count();

		vaBien = numeroOpinionesEntre2Y4 >= opiniones.length * 0.8 ? true : false;

		System.out.println("El porcentaje es: " + numeroOpinionesEntre2Y4 * 100 / opiniones.length);

		return vaBien;
	}

	public static void generarInformeEstadisticosCursoJuan(int[] opiniones) {
		int maximo = opiniones[0];
		int minimo = opiniones[0];
		int suma = 0;
		float media;

		// obtener el maximo e imprimirlo
		// recorrer el array y quedarme con el valor mas alto

		for (int i = 0; i < opiniones.length; i++) {
			if (maximo < opiniones[i]) {
				maximo = opiniones[i];
			}
		}

		System.out.println("El valor maximo es: " + maximo);

		// obtener el minimo e imprimirlo
		// recorrer el array y quedarme con el valor mas bajo
		for (int i = 0; i < opiniones.length; i++) {
			if (minimo > opiniones[i]) {
				minimo = opiniones[i];
			}
		}

		System.out.println("El valor minimo es: " + minimo);

		// obtener la media e imprimirla
		// recorrer el array sumando los valores y dividirlos entre la cantidad de
		// elementos
		for (int i = 0; i < opiniones.length; i++) {
			suma = suma + opiniones[i];
		}
		media = suma / opiniones.length;

		System.out.println("La media es: " + media);

		// obtener la moda e imprimirla
		// recorrer el array contando el numero de apariciones de cada valor y quedarse
		// con el mas repetido
		for (int i = 0; i < opiniones.length; i++) {

		}
	}

	public static int obtenerMayor(int[] opiniones) {
		int mayor = opiniones[0];

		for (int i = 0; i < opiniones.length; i++) {
			if (opiniones[i] > mayor) {
				mayor = opiniones[i];
			}
		}

		return mayor;
	}

	public static int obtenerMenor(int[] opiniones) {
		int menor = opiniones[0];

		for (int i = 0; i < opiniones.length; i++) {
			if (opiniones[i] < menor) {
				menor = opiniones[i];
			}
		}

		return menor;
	}

	public static float obtenerMedia(int[] opiniones) {
		float media = 0;
		int suma_de_opiniones = 0;
		int cantidad_de_opiniones = opiniones.length;

			for (int i = 0; i < opiniones.length; i++) {
				suma_de_opiniones = suma_de_opiniones + opiniones[i];
			}
			media = suma_de_opiniones / cantidad_de_opiniones;

		return media;
	}
	
	public static int obtenerModa (int[] opiniones)
	{
		int moda = 0;
		int maximas_veces_repetido = 0;

			for (int i = 0; i < opiniones.length; i++) {
				int repeticiones = 0;
				for (int j = 0; j < opiniones.length; j++) {
					if (opiniones[i] == opiniones[j]) {
						repeticiones++;
					}
					if (repeticiones > maximas_veces_repetido) {
						moda = opiniones[i];
						maximas_veces_repetido = repeticiones;
					}
				}
			}

		return moda;
	}

	public static void generarInformeEstadisticosCursoSofia(int[] opiniones) {
		// Máximo
		int mayor = obtenerMayor(opiniones);
		int menor = obtenerMenor(opiniones);
		float media = obtenerMedia(opiniones);
		int moda = obtenerModa(opiniones);

		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
		System.out.println("Media: " + media);
		System.out.println("Moda: " + moda);

	}

	// DEFINO UN MÉTODO
	// DARLE UN NOMBRE - camelCase
	// ID la entrada -
	// ID la salida -

}
