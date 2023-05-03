package bdjava;

import java.util.Date;

public class RegistroIMC {
	
	private int id;
	private Date fecha_registro;
	private float imc_num;
	private float altura;
	private float peso;
	private TipoIMC tipoIMC;
	private Paciente paciente;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public float getImc_num() {
		return imc_num;
	}
	public void setImc_num(float imc_num) {
		this.imc_num = imc_num;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public TipoIMC getTipoIMC() {
		return tipoIMC;
	}
	public void setTipoIMC(TipoIMC tipoIMC) {
		this.tipoIMC = tipoIMC;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public RegistroIMC(int id, Date fecha_registro, float imc_num, float altura, float peso, TipoIMC tipoIMC,
			Paciente paciente) {
		super();
		this.id = id;
		this.fecha_registro = fecha_registro;
		this.imc_num = imc_num;
		this.altura = altura;
		this.peso = peso;
		this.tipoIMC = tipoIMC;
		this.paciente = paciente;
	}
	
	public RegistroIMC() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RegistroIMC [id=" + id + ", fecha_registro=" + fecha_registro + ", imc_num=" + imc_num + ", altura="
				+ altura + ", peso=" + peso + ", tipoIMC=" + tipoIMC + ", paciente=" + paciente + "]\n";
	}
	
	

}
