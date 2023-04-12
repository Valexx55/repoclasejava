package edu.java.val.salud;

import java.util.Scanner;

public class Entrada {

	//MÉTODOS PARA TOMAR LOS DATOS 
	
	public static float obtenerPeso ()
	{
		float peso_intro = 0;
		Scanner scanner = null;
		
			scanner = new Scanner(System.in);
			System.out.println("Introduzca su peso (kg)");
			peso_intro = scanner.nextFloat();
			//scanner.close();
		
		return peso_intro;
	}
	
	public static float obtenerAltura ()
	{
		float altura_intro = 0;
		Scanner scanner = null;
		
			scanner = new Scanner(System.in);
			System.out.println("Introduzca su altura (m) -use la coma como decimal-");
			altura_intro = scanner.nextFloat();
			//scanner.close();
			
		return altura_intro;
	}
}
