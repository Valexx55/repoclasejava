package edu.java.val.salud;

/**
 * @author valer
 *
 */
public class PrincipalIMC {

	
	public static void main(String[] args) {
		
		//1 pedir peso Scanner - float / double
		//2 pedir estatura - float / double
		//3 calcular el imc - float / double - String / Enum
		//4 informar Sysout
		
		float peso = Entrada.obtenerPeso();
		float altura = Entrada.obtenerAltura();
		Paciente paciente = new Paciente(peso, altura);
		float imc_num = IMC.calcula(paciente);
		Salida.informarIMC(imc_num);

	}

}
