package imcweb.service;

/**
 * Esta clase, contiene los datos dinámicos o variables
 * para mostrar en el JSP del calculo del imc
 * 
 * @author valer
 *
 */
public class InfoSalidaImc {
	
	private String imc_nom;//nombre
	private float imc_num;//numero
	private String foto;//ruta
	
	
	public String getImc_nom() {
		return imc_nom;
	}
	public void setImc_nom(String imc_nom) {
		this.imc_nom = imc_nom;
	}
	public float getImc_num() {
		return imc_num;
	}
	public void setImc_num(float imc_num) {
		this.imc_num = imc_num;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public InfoSalidaImc(String imc_nom, float imc_num, String foto) {
		super();
		this.imc_nom = imc_nom;
		this.imc_num = imc_num;
		this.foto = foto;
	}
	
	public InfoSalidaImc() {
		// TODO Auto-generated constructor stub
	}

}
