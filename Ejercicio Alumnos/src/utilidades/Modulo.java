package utilidades;

public class Modulo {

	private String nombre;
	private int nota;
	
	/*********************** METODOS **********************************/
	
	
	/*********************** METODOS **********************************/
	public Modulo() {
		super();
	}

	public Modulo(String nombre, int nota) {
		super();
		this.nombre = nombre;
		this.nota = nota;
	}

	/*********************** GETTERS && SETTERS **********************************/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
