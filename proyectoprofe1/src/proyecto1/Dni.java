package proyecto1;

/**
 * Esta clase representa un DNI español.
 * 
 * @author valer
 * @since version 1
 * @version 3
 * 
 *
 */
public class Dni {

	//ATRIBUTOS-propiedades-fields-campos
	int numero_dni;
	char letra_dni;
	String nombre;
	
	//MÉTODOS -- funciones - qué operaciones puedo hacer con el dni
	//firmar
	//identificar
	//mostrar
	//calcularLetra
	//dniValido
	//dniCaducado
	
	//constructor
	public Dni() {
		System.out.println("Estoy el en constructor por defecto");
	}

	public Dni(int numero_dni, char letra_dni, String nombre) {
		super();
		this.numero_dni = numero_dni;
		this.letra_dni = letra_dni;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		//this es el objeto llamante
		System.out.println("en toString");
		return "Dni [numero_dni=" + this.numero_dni + ", letra_dni=" + this.letra_dni + ", nombre=" + this.nombre + "]";
	}
	
	
	
	
}
