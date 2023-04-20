package proyecto1.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainRestaurantes {
	
	public static void main(String[] args) {
		
		Restaurante restaurante0 = new Restaurante("El Cazador", 20);
		Restaurante restaurante1 = new Restaurante("Linares", 38);
		Restaurante restaurante2 = new Restaurante("McDonalds", 10);
		Restaurante restaurante3 = new Restaurante("Paragüas", 70);
		
		List<Restaurante> listaRestaurantes = new ArrayList<>(); //List.of(restaurante, restaurante1, restaurante2, restaurante3);
		
		listaRestaurantes.add(restaurante0);
		listaRestaurantes.add(restaurante1);
		listaRestaurantes.add(restaurante2);
		listaRestaurantes.add(restaurante3);
		
		System.out.println(listaRestaurantes);
		Collections.shuffle(listaRestaurantes);//reordenad como le da le gana// barajar
		System.out.println(listaRestaurantes);
		
		Comparator<Restaurante> comparadorPrecio = new ComparadorRestaurantesPorPrecio();
		Collections.sort(listaRestaurantes, comparadorPrecio);//USANDO EL ORDEN TOTAL
		System.out.println("DATOS ORDENADOS POR PRECIO de menor a mayor");
		System.out.println(listaRestaurantes);
		System.out.println("DATOS ORDENADOS POR NOMBRE orden alfabético");
		Collections.sort(listaRestaurantes);
		System.out.println(listaRestaurantes);
		
		//nombre canónico paquete+clase
		//[proyecto1.colecciones.Restaurante@36baf30c, 
		//proyecto1.colecciones.Restaurante@7a81197d, 
		//proyecto1.colecciones.Restaurante@5ca881b5, 
		//proyecto1.colecciones.Restaurante@24d46ca6]
		
		
	}

}
