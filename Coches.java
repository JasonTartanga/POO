package coche;

import javax.swing.JOptionPane;

public class Coches {

	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int caballos;
	private int cc;
	private float precio;
	
	public void setDatos(String matricula) {
		this.matricula = matricula;
		marca = JOptionPane.showInputDialog("Introduce la marca");
		modelo = JOptionPane.showInputDialog("Introduce el modelo");
		color = JOptionPane.showInputDialog("Introduce el color");
		caballos = Integer.parseInt(JOptionPane.showInputDialog("Introduce los caballos"));
		cc = Integer.parseInt(JOptionPane.showInputDialog("Introduce los cc"));
		precio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio"));
	}
	
	public void mostrar() {
		JOptionPane.showMessageDialog(null, "Matricula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo + "\nColor: " + color + "\nCaballos: " + caballos + "\nCC: " + cc + "\nPrecio: " + precio);
	}
	public Coches() {
		
	}

	public Coches(String matricula) {
		this.matricula = matricula;

	}
	
	public Coches(String matricula, String marca, String modelo, String color, int caballos, int cc, float precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.caballos = caballos;
		this.cc = cc;
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
		
}
