package proyecto1.test;

import java.util.ArrayList;
import java.util.List;

public class MainAntonio {
	
	public static void main(String[] args) {
		
		if (new ArrayList<>() instanceof List)
		{
			System.out.println("Sí es una instancia de lista");
		} else 
		{
			System.out.println("NO es una instancia de lista");
		}
	}
	

	//PREGUNTA DE ANTONIO CARMONA
	/*
	 * 
	 * Given the following structure, which snippets of code return true? (Choose three.)

		interface Friendly {}
		abstract class Dolphin implements Friendly {}
		class Animal implements Friendly {}
		class Whale extends Object {}
		public class Fish {}
		class Coral extends Animal {}
		
		A. new Coral() instanceof Friendly
		B. null instanceof Object
		C. new Coral() instanceof Object
		D.  new Fish() instanceof Friendly
		E. new Whale() instanceof Object
		F. new Dolphin() instanceof Friendly
	 */
	//SOLUCIONES : A C E

}
