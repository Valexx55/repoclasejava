package imcweb.model;

//es el tipo de dato perfecto para usar cuando un valor, está acotado en un rango limitado de valores
//vamos a definir un método que traduzca un valor numérico a uno nominal TipoIMC
public enum TipoIMC {
	DESNUTRIDO, DELGADO, IDEAL, SOBREPESO, OBESO;

	// métodos
	public static TipoIMC traducirIMC(float imc) {
		TipoIMC tipo_imc = null;

		if (imc < 16) {
			
			tipo_imc = TipoIMC.DESNUTRIDO;
			
		} else if ((imc >= 16) && (imc < 18)) 
			{
				tipo_imc = TipoIMC.DELGADO;
				
			} else if ((imc >= 18) && (imc < 25)) 
				{
					tipo_imc = TipoIMC.IDEAL;
				} else if ((imc >= 25) && (imc < 31)) 
					{
						tipo_imc = TipoIMC.SOBREPESO;
					} else  
						{
							tipo_imc = TipoIMC.OBESO;
						}

		return tipo_imc;
	}

}
