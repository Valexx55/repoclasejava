package colecciones.equals;

/**
 * Esta clase representa un DNI español.
 * 
 * @author valer
 * @since version 1
 * @version 3
 * 
 * 
 * Las clases sencillas de Java, que tiene sus atributos y los métodos de acceso y el constructor
 * (que generalmente modelan algún dato de mi app)
 * se les llama JAVA BEANS, BEANS, POJO - Plain Old Java Object-
 *
 */
public class Dni {

	
	
	public final static String SECUENCIA_LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public final static int NUM_MAX_DNI = 99999999;//Atributo definido a nivel de clase: común a todos los objetos
	//ATRIBUTOS-propiedades-fields-campos : PRIVADOS!!! acceder por los métodos de acceso -Getters y Setters
	//NORMA_ DISEÑO
	private int numero_dni;
	private char letra_dni;
	private String nombre;
	
	//MÉTODOS -- funciones - qué operaciones puedo hacer con el dni
	//firmar
	//identificar
	//mostrar
	//calcularLetra
	//dniValido
	//dniCaducado
	
	
	static
	{
		System.out.println("HOLA ESTOY EN LA SECCIÓN STATIC");
	}
	
	//constructor
	public Dni() {
		System.out.println("Estoy el en constructor por defecto");
	}
	
	

	public Dni(int numero_dni, String nombre) {
		super();
		this.numero_dni = numero_dni;
		this.nombre = nombre;
	}


	public char calcularLetra()
	{
		char letra_calculda=' ';
			
			int resto = this.numero_dni%Dni.SECUENCIA_LETRAS.length();
			letra_calculda = Dni.SECUENCIA_LETRAS.charAt(resto);
		
		return letra_calculda;
	}

	public int getNumero_dni() {
		return this.numero_dni;
	}

	public void setNumero_dni(int numero_dni) {
		this.numero_dni = numero_dni;
	}

	public char getLetra_dni() {
		return this.letra_dni;
	}

	public void setLetra_dni(char letra_dni) {
		this.letra_dni = letra_dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return this.numero_dni + "-" + this.letra_dni + "-" + this.nombre;
	}
	
	public static boolean esDniCorrecto(Dni dni) {
		boolean dni_correcto = false;
		char letra_calculada = ' ';	
		
			letra_calculada =  dni.calcularLetra();
			dni_correcto = (letra_calculada == dni.getLetra_dni());
			
		return dni_correcto;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
			//quién comparo - this con obj
			if (obj!=null)
			{
				if (obj instanceof Dni dni2)//si obj es un DNI, se hace el casting a dni2
				{
					 iguales = this.numero_dni==dni2.numero_dni && 
							   (this.nombre.equals(dni2.nombre)) &&
							   this.letra_dni == dni2.letra_dni;
					
				}
			}
		
		return iguales;
	}
}
