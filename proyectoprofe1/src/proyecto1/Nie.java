package proyecto1;

/**
 * NIE es un subtipo especial de Documento de Identidad
 * que además de los datos de un DNI, tiene un prefijo
 * X, Y o Z
 * @author valer
 *
 */
public class Nie extends Dni{
	
	char prefijo;

	
	
	@Override//SOBREESCRIBIR -> Dar mi versión de un método heradado, que lo sustiuye -- POLIMORFISMO
		public char calcularLetra() {
			// TODO Auto-generated method stub
			return super.calcularLetra();
		}
	
	public Nie() {
		// TODO Auto-generated constructor stub
	}
	
	public Nie(char prefijo) {
		super();
		this.prefijo = prefijo;
	}

	public Nie(int numero_dni, String nombre, char prefijo) {
		super(numero_dni, nombre);//new Dni (numero, nombre)
		this.prefijo = prefijo;
	}
	
	public Nie(int numero_dni, char letra_dni, String nombre, char prefijo) {
		super(numero_dni, letra_dni, nombre);
		this.prefijo = prefijo;
	}

	
	
	

}
