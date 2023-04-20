package proyecto1.colecciones;

import java.util.Comparator;

//CUANDO IMPLEMENTO COMPARATOR EN UN CLASE APARTE, SE LLAMAN ORDEN TOTAL
public class ComparadorRestaurantesPorPrecio implements Comparator<Restaurante> {

	// si el 1 es mayor que el 2, devuelvo un número positivo
	// si el 2 es mayor que el 1, devuelvo un número negativo
	// si son iguales, 0

	@Override
	public int compare(Restaurante r1, Restaurante r2) {
		int resultado_compracion = 0;

		resultado_compracion =  r1.getPrecioMedio()-r2.getPrecioMedio();//con esto ordeno de menor a mayor precio asc
		//resultado_compracion =  r2.getPrecioMedio()-r1.getPrecioMedio();//con esto ordeno de mayor a menor desc
			
			/*if (r1.getPrecioMedio() > r2.getPrecioMedio()) {
				resultado_compracion = 1;
			} else if (r1.getPrecioMedio() < r2.getPrecioMedio()) {
				resultado_compracion = -1;
			} else {
				//resultado_compracion = 0;
			}*/

		return resultado_compracion;
	}

}
