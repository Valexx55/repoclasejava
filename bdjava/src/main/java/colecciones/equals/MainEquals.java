package colecciones.equals;

public class MainEquals {
	
	public static void main(String[] args) {
		
		Dni dni = new Dni(53130984, 'H', "VALERIANO");
		Dni dni2 = new Dni(53130984, 'H', "VALERIANO");
		//dni2 = dni;
		//NO DEBO COMPARAR CON == SI SON OBJETOS
		//SÓLO PARA TIPOS PRIMITVOS int, boolean, char
		
		if (dni.equals(dni2))
		{
			System.out.println("SON IGUALES");
		} else {
			System.out.println("SON DISTINTOS");
		}
		
		//2 OBJETOS QUE EQUALS ME DICEN SON IGUALES, DEBEN TENER EL MISMO 
		//HASHCODE
		System.out.println("DNI 1 hashcode "+ dni.hashCode());
		System.out.println("DNI 2 hashcode " +dni2.hashCode());
		
	}

}
