package clases;

public class Jefe extends Empleado {

	private String departamento;

	/**************** METODOS ***************/
	
	
	
	/**************** CONSTRUCTORES ***************/
	public Jefe(String dni) {
		super(dni);
		this.dni = dni;
	}

	public Jefe(String dni, String nombre, int mes, int año, float incremento, String departamento) {
		super(dni, nombre, mes, año, incremento);
		this.departamento = departamento;
	}

	/**************** GETTERS && SETTERS ***************/
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
