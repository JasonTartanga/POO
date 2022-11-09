package ejercicio3;

import javax.swing.JOptionPane;

public class Persona {

	private String nombre;
	private int edad;
	private String dni;

	public Persona() {

	}

	public Persona(String nombre, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Persona preguntar() {
		nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
		dni = JOptionPane.showInputDialog("Introduce tu DNI");
		return null;
	}

	public void mostrar() {
		JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + dni, "TUS DATOS",
				JOptionPane.PLAIN_MESSAGE);
	}

	public boolean esMayorDeEdad() {
		if (edad >= 18) {
			return true;
		} else {
			return false;
		}
	}
}
