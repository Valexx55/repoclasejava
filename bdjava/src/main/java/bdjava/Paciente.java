package bdjava;

import colecciones.equals.Dni;

public class Paciente {
	
	private int id;
	private String nombre;
	private int edad;

	public Paciente() {
		super();
	}

	public Paciente(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
			//quién comparo - this con obj
			if (obj!=null)
			{
				if (obj instanceof Paciente paciente)//si obj es un DNI, se hace el casting a dni2
				{
					 iguales = this.id == paciente.id;
					
				}
			}
		
		return iguales;
	}
	
	@Override
	public int hashCode() {
		
		return this.id;
	}


}
