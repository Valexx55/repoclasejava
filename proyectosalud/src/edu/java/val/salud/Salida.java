package edu.java.val.salud;

public class Salida {

	
	//INFORMAR DEL RESULTADO
	public static void informarIMC (float imc)
	{
		TipoIMC tipo = TipoIMC.traducirIMC(imc);
		System.out.println("SU IMC es " + imc + "-" + tipo );
	}
}
