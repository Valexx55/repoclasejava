package streams;

import java.util.ArrayList;
import java.util.List;

public class MainStreams {

	//TODO sobre esta coleeccion de listacursos, intentad, usando Streams
	//las siguientes operaciones
	
	//1 obtener la cantidad de cursos con duración mayor a 5 horas
	//2 obtener la cantidad de cursos con duración MENOR A 2 HORAS
	//3 Listar el título de aquellos cursos con más de 50 videos
	
	//4 Mostrar la duración total de los cursos
	
	//5 Mostrar el titulo de los 3 cursos con mayor duración
	//6 Mostrar todos aquellos cursos cuya duración supere el promedio de duración en horas del conjunto
	
	public static void main(String[] args) {
		
		List<Curso> listaCursos = new ArrayList<>();
		listaCursos.add(new Curso("JAVA 18", 1.5f, 22, 3));
		listaCursos.add(new Curso("ANGULAR", 35.5f, 65, 83));
		listaCursos.add(new Curso("SPRING", 120.5f, 36, 23));
		listaCursos.add(new Curso("KAFKA", 250.5f, 18, 33));
		listaCursos.add(new Curso("MAGNOLIA", 4.5f, 15, 54));
		
		//listaCursos.stream()
	}
}
