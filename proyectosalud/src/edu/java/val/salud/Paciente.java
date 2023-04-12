package edu.java.val.salud;

public class Paciente {
	
	private float peso;
	private float altura;
	
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public Paciente(float peso, float altura) {
		super();
		this.peso = peso;
		this.altura = altura;
	}
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	
//	public static Paciente generarPacienteAlto ()
//	{
//		Paciente p = new Paciente();
//		p.setAltura(3f);
//		
//		return p;
//	}
//	
	

}
