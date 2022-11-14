package ejercicio6;

import javax.swing.JOptionPane;

public class Personas {

	private String nombre = "";
	private int edad = 0;
	private String dni;
	private char sexo = 'M';
	private float peso = 0;
	private float altura = 0;

	final private char SEXO_POR_DEFECTO = 'M';

	private String[] opciones = { "Hombre", "Mujer" };

	public void setDatos() {
		nombre = JOptionPane.showInputDialog("Introduce tu nombre", "");
		edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad", 0));
		dni = JOptionPane.showInputDialog("Introduce tu DNI");
		sexo = (char) JOptionPane.showOptionDialog(null, "¿Que sexo eres?", null, 0, 3, null, opciones, 0);
		peso = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu peso", 0));
		altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura", 0));
	}

	public void showDatos() {
		JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + dni + "\nSexo: "
				+ sexo + "\nPeso: " + peso + "\nAltura: " + altura);
	}

	public Personas() {

	}

	public Personas(String nombre, int edad, char sexo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}

	public Personas(String nombre, int edad, String dni, char sexo, float peso, float altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

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

}
