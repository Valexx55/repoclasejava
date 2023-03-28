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

	public Nie(char prefijo) {
		super();
		this.prefijo = prefijo;
	}
	
	

}
