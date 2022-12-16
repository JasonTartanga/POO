package clases;

import java.time.LocalDate;

import utilidades.Utilidades;

public class Empleado {

	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNac;
	private LocalDate fechaAlta;
	private int numSorteo;

	/******************** METODO ********************/
	public void setDatos(String dni) {
		this.dni = dni;
		nombre = Utilidades.intrducirCadena("Introduce tu nombre");
		apellido = Utilidades.intrducirCadena("Introduce tu nombre");
		fechaNac = Utilidades.introducirFecha("Introduce tu fecha de nacimiento");
		fechaAlta = Utilidades.introducirFecha("Introduce tu fecha de alta");
		numSorteo = Utilidades.numeroAleatorio(1, 100);
	}

	/******************** CONSTRUCTOR ********************/
	public Empleado() {

	}

	/******************** GETTERS && SETTERS ********************/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public LocalDate getFechaalta() {
		return fechaAlta;
	}

	public void setFechaalta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getNumSorteo() {
		return numSorteo;
	}

	public void setNumSorteo(int numSorteo) {
		this.numSorteo = numSorteo;
	}

}
