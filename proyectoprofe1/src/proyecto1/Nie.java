package proyecto1;

/**
 * NIE es un subtipo especial de Documento de Identidad
 * que además de los datos de un DNI, tiene un prefijo
 * X, Y o Z
 * @author valer
 *
 */
public class Nie extends Dni{
	
	private char prefijo;

	
	/**
	 * /*
		 * SI EL PREFIJO ES UNA X, SE CALCULA COMO UN DNI (SUSTITUIR LA X POR 0)
		 * SI EL PREFIJO ES UNA Y, SE TIENE QUE SUSITUIR POR UN 1 Y PONERLO DELANTE DEL NÚMERO
		 * Y698745 --> 1698745 % 23 --> letra
		 * SI EL PREFIJO ES UNA Z, SE TIENE QUE SUSITUIR POR UN 2 Y PONERLO DELANTE DEL NÚMERO
		 * Z698745 --> 2698745 % 23 --> letra
		 * */
	@Override//SOBREESCRIBIR -> Dar mi versión de un método heradado, que lo sustiuye -- POLIMORFISMO
	public char calcularLetra() {
			
		
		char letra_calculada = ' ';
		String numero_dni_texto = null;//los objetos siempre los inicializamos a null
		int numero_dni_nuevo = 0;
		int resto = 0;
			
		
			switch (this.prefijo) {
			case 'X': 
					letra_calculada = super.calcularLetra();//estoy invocando al calcular letra del padre, DNI
				break;
			case 'Y': 
				 //1 paso el numero a texto 
				 numero_dni_texto = String.valueOf(this.getNumero_dni());//conversion de tipos
				 //2 a ese texto, le concateno un 1 delante
				 numero_dni_texto = '1'+numero_dni_texto;
				 //3 ese texto, lo paso a número nuevamente
				 numero_dni_nuevo = Integer.parseInt(numero_dni_texto);
				 resto = numero_dni_nuevo%Dni.SECUENCIA_LETRAS.length();
				 letra_calculada = Dni.SECUENCIA_LETRAS.charAt(resto);
				
				break;
			case 'Z':
				
				//1 paso el numero a texto 
				 numero_dni_texto = String.valueOf(this.getNumero_dni());//conversion de tipos
				 //2 a ese texto, le concateno un 1 delante
				 numero_dni_texto = '2'+numero_dni_texto;
				 //3 ese texto, lo paso a número nuevamente
				 numero_dni_nuevo = Integer.parseInt(numero_dni_texto);
				 resto = numero_dni_nuevo%Dni.SECUENCIA_LETRAS.length();
				 letra_calculada = Dni.SECUENCIA_LETRAS.charAt(resto);
				
				
				break;
			
			}
				
		
		return letra_calculada;
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
