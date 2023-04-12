package proyecto1.excepciones;

public class MainExcepciones {
	
	public static void main(String[] args) {
	
		try {
			String cadena0 = "GF4";
			 if (isNumeric(cadena0))
			 {
				 System.out.println("la cadena" + cadena0 +" SÍ es un número");
			 } else {
				 System.out.println("la cadena " + cadena0 +"  NO es un número");
			 }
			int numero =  Integer.parseInt("36"); //al lanzar una expceción de tipo Runtime a mí , Java no me obliga a capturarla
			System.out.println("NUMERO = " + numero);
			String cadena = "HOLA";
			cadena.charAt(3);
			String cadena2 = "";
			cadena2.length();
		}catch (NumberFormatException | StringIndexOutOfBoundsException e1) {
			//LOG4J - apache Logback
			System.err.println("Se ha producido un error numérico o me he salido del string " +  e1.getMessage());
			e1.printStackTrace();//imprimir la traza de la execepción
			
		}catch (NullPointerException e) {
			//LOG4J - apache Logback
			System.err.println("Se ha producido un error de null " +  e.getMessage());
			e.printStackTrace();//imprimir la traza de la execepción
			
		}catch (Throwable e) {
			//LOG4J - apache Logback
			System.err.println("Se ha producido un error genérico " +  e.getMessage());
			e.printStackTrace();//imprimir la traza de la execepción
			
		}
		
	}
	
	private static boolean isNumeric(String cadena) throws NumberFormatException {

        boolean resultado = false;

	        try {
	            Integer.parseInt(cadena);
	            resultado = true;
	        } catch (NumberFormatException excepcion) {
	            resultado = false;//caputra
	            throw excepcion;//propaga
	        }

        return resultado;
    }

}
