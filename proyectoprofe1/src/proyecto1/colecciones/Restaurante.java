package proyecto1.colecciones;

//SI DEFINO EL CRITERIO DE ORDEN COMPARE DENTRO DE LA CLASE ORDEN NATURAL
public class Restaurante  implements Comparable<Restaurante> {

	private String nombre;
	private int precioMedio;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecioMedio() {
		return precioMedio;
	}

	public void setPrecioMedio(int precioMedio) {
		this.precioMedio = precioMedio;
	}

	public Restaurante(String nombre, int precioMedio) {
		super();
		this.nombre = nombre;
		this.precioMedio = precioMedio;
	}

	@Override
	public String toString() {
		return "Restaurante [nombre=" + this.nombre + ", precioMedio=" + this.precioMedio + "]";
	}

	// comparo o con this

	@Override
	public int compareTo(Restaurante o) {
		// VAMOS A ORDENAR POR NOMBRE , tengo que comprar String
		// si this es emayor, me devuelve positivo
		// si o es mayor, negativo
		// si son iguales 0
		int resultado_comp = 0;

		resultado_comp = this.nombre.compareTo(o.getNombre());

		return resultado_comp;
	}

}
