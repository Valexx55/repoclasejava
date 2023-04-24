package imcweb.service;

public class IMC {

	//CALCULO - FÓRMULA
	
	public static float calcula (Paciente paciente)
	{
		float imc_num = 0;
			
			//peso / altura al cuadrado
			//alternativa al divisor //Math.pow(paciente.getAltura(), 2);
			imc_num = paciente.getPeso() / (paciente.getAltura() * paciente.getAltura());
		
		return imc_num;
	}
}

