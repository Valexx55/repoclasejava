package proyecto1;

public class PrincipalPrueba {
	
	public static void main(String[] args) 
	{
		System.out.println("HOLA estoy en el main del proyecto 1");
		
		/*int numero_dni = 53162984;
		char letra_dni = 'L'; //WRAP en un clase
		String nombre = "Vale";*/
		
		String nombre = new String("MANU");
		System.out.println(nombre);
		
		Dni dni = new Dni();//creo un objeto Dni, llmando al constructor de la clase
		System.out.println("Fin de programa");
	}

}
