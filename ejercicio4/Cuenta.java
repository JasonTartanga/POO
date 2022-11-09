package ejercicio4;

import javax.swing.JOptionPane;

public class Cuenta {

	private String titular;
	private float cantidad;

	public Cuenta() {

	}

	public Cuenta(String titular, float cantidad) {
		super();
		this.titular = titular;
		this.cantidad = cantidad;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public void setDatos() {
		titular = JOptionPane.showInputDialog("Introduce el nombre del titular");
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad inicial", 0));
	}

	public void ingresar(float ingreso) {
		if (ingreso == 0) {
			ingreso = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad que quieras ingresar"));
		}
		if (ingreso >= 0) {
			cantidad += ingreso;
		}
	}

	public void retirar(float retiro) {
		if ((cantidad - retiro) >= 0) {
			cantidad -= retiro;
		} else {
			cantidad = 0;
		}
	}

	public void mostrar() {
		JOptionPane.showMessageDialog(null, "Titular: " + titular + "\nCantidad: " + cantidad + "€", "TUS DATOS",
				JOptionPane.PLAIN_MESSAGE);
	}
}
