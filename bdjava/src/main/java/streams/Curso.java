package streams;

public class Curso {
	
	private String titulo;
	private float duracion;
	private int alumnos;
	private int videos;
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	public int getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(int alumnos) {
		this.alumnos = alumnos;
	}
	public int getVideos() {
		return videos;
	}
	public void setVideos(int videos) {
		this.videos = videos;
	}
	public Curso(String titulo, float duracion, int alumnos, int videos) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.alumnos = alumnos;
		this.videos = videos;
	}
	
	
	
	

}
