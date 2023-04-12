package proyectosalud;

import java.util.Scanner;

public class PrincipalIMCGerado {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //1 pedir peso
        System.out.print("Introduzca su peso en kg: ");
        float peso = scanner.nextFloat();
        
        //2 pedir estatura
        System.out.print("Introduzca su estatura en metros: ");
        float estatura = scanner.nextFloat();
        
        //3 calcular el imc
        float imc = peso / (estatura * estatura);
        
        //4 informar
        String categoria;
        if (imc < 16) {
            categoria = "Desnutricion";
        } else if (imc < 18) {
            categoria = "Delgado";
        } else if (imc < 25) {
            categoria = "Ideal";
        } else if (imc < 31) {
            categoria = "Sobrepeso";
        } else {
            categoria = "Obesidad";
        }
        System.out.println("Su IMC es: " + imc);
        System.out.println("Categoria: " + categoria);
        
        //scanner.close();
    }//fin main


}//fin clase
