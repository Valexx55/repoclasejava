package proyecto1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 
 * En esta clase vamos a programar un par de métodos sobre las estadísticas del
 * curso
 * 
 * @author valer
 *
 */
public class EstadisticasCurso {
	
	final static int PORCENTAJE_CALIDAD = 80; //CONSTANTE

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
	
	//COMPLEJIDAD O(n)

	static int[] opiniones_alumnos = { 4, 4, 2, 2, 4, 2, 1, 4, 3, 2, 2, 4, 2, 4, 1, 4, 1 };
	// static List<Integer> lista_opiniones = List.of(4, 4, 2, 2, 4 , 2 , 1, 4 , 3,
	// 2 , 2, 4, 2, 4, 1, 4, 1);

	public static void main(String[] args) {
		
		//PORCENTAJE_CALIDAD = 30; //Da fallo porque un dato definido como final como Constante, no se puede modficar

		boolean cursook = cursoVaBien(opiniones_alumnos);
		boolean cursookm = cursoVaBienMohamed(opiniones_alumnos);
		boolean cursooka = cursoVaBienAdri(opiniones_alumnos);
		System.out.println("CURSO VA BIEN = " + cursook);
		System.out.println("CURSO VA BIEN = " + cursookm);
		System.out.println("CURSO VA BIEN = " + cursooka);

		System.out.println("****ESTADISTICOS JUAN*******\n");
		generarInformeEstadisticosCursoJuan(opiniones_alumnos);
		System.out.println();
		System.out.println("****ESTADISTICOS SOFIA*******\n");
		generarInformeEstadisticosCursoSofia(opiniones_alumnos);
		System.out.println();
		System.out.println("****ESTADISTICOS VALE*******\n");
		generarInformeEstadisticosCursoVal(opiniones_alumnos);
		
		
		
		/*int moda_val =  obtenerModaVal(opiniones_alumnos);
		System.out.println("La moda es "+ moda_val);*/

		/*boolean vabien = cursoVaBienValStream(opiniones_alumnos);
		System.out.println("El curso según val va " + vabien);
		int modavale  = obtenerModaValStream(opiniones_alumnos);
		System.out.println("Moda vale = " +modavale);*/

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

		if (porcentaje_entre_2_y_4 >= PORCENTAJE_CALIDAD) {
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
		if (opinionEnRango2_4 * 100 / opiniones.length >= PORCENTAJE_CALIDAD) {
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
		float suma = 0;
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
		float suma_de_opiniones = 0;
		int cantidad_de_opiniones = opiniones.length;

		for (int i = 0; i < opiniones.length; i++) {
			suma_de_opiniones = suma_de_opiniones + opiniones[i];
		}
		media = suma_de_opiniones / cantidad_de_opiniones;

		return media;
	}

	public static int obtenerModa(int[] opiniones) {
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
	
	//ocurrences en inglés es el número de veces o apariciones de un dato
	public static int cuentaNevecesOpinion (int[] opiniones, int opinion_buscada)
	{
		int nveces = 0;
			
			for (int opinion_actual : opiniones) //for each
			{
				if (opinion_actual == opinion_buscada)
				{
					nveces++;
				}
			}
		
		return nveces;
	}
	
	
	/**
	 * Esta funciones obtiene el dato estadístico de la moda dado un array de enteros
	 * La moda es el valor más repetido - con "más ocurrences" -
	 * 
	 * @param opiniones el array de entrada que contiene las opiones
	 * @return la moda. en caso de que haya igualdad entre varios, devuelve el primero
	 */
	public static int obtenerModaVal(int[] opiniones) {
		int moda = 0;
		int max_repetida = 0;
		int num_repectiones = 0;
		
		
			for (int nopinion=1; nopinion<=5 ;nopinion++)
			{
				num_repectiones = cuentaNevecesOpinion(opiniones, nopinion);
				if (num_repectiones>max_repetida)
				{
					max_repetida = num_repectiones;
					moda = nopinion;
				}
			}
		
		return moda;
	}
	
	
	public static void generarInformeEstadisticosCursoVal(int[] opiniones)
	{
		//hacer el maximo, min, media con Stremas/kambdas/programación funcional
		IntSummaryStatistics estadisticas = Arrays.stream(opiniones).summaryStatistics();
		
		int max = estadisticas.getMax();
		int min = estadisticas.getMin();
		double media = estadisticas.getAverage();
		int moda = obtenerModaVal(opiniones);
		
		System.out.println("MAX = "+ max);
		System.out.println("MIN = "+ min);
		System.out.println("MEDIA AVG = "+ media);
		System.out.println("MODA = "+ moda);
		
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

	public static boolean cursoVaBienValStream(int[] opiniones) {
		boolean vaBien = false;

		vaBien = Arrays.stream(opiniones)// creo un fujo de int
				.boxed()// lo paso de int a Integer, "lo envuelvo", para poder aplicar los operadores de
						// Stream<Integer>
				.collect // uso una operación de reducción: de una lista/colección, pasaremos a un valor
				(Collectors.teeing(
						// genero una lista sólo con las que están entr 2 y 4
						Collectors.filtering(opinion -> opinion >= 2 && opinion <= 4, Collectors.toList()),
						// cuento todos
						Collectors.counting(),
						// los resultados anteriores, se cargan respectivamente en los parámetros
						// lista2y4, total
						(lista2y4, total) -> {
							// lo que devuelto aquí, es el resultado final de collect: un boolean
							// si el tamaño de la lista entre 2 y 4, es más del 80 por cierto, verdadero
							// si no, falso :)
							return (lista2y4.size() >= total * 0.8);
						}));

		return vaBien;
	}

	public static int obtenerModaValStream(int[] opiniones) {
		int moda = 0;
		
			moda = Arrays.stream(opiniones)//creo un fujo de int
			.boxed()
			.collect(Collectors.groupingBy(opi-> opi))//HAGO UN MAPA DONDE LA CLAVE ES LA OPINIÓN
			.values()//ME QUEDO CON LAS LISTAS (VALOR DEL MAPA)
			.stream()
			.max(Comparator.comparing(List::size))
			.get()//mE QUEDO CON LA LISTA MÁS LARGA
			.get(0);//ME QUEDO CON EL PRIMERO 
				

		return moda;
	}



}
