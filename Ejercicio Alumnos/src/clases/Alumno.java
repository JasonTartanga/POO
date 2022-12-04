package clases;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import utilidades.Modulo;

public class Alumno {

	private String nif;
	private String nombre;
	private String apellido;
	private String ciclo;
	private boolean esRepetidor;
	private List<Modulo> modulos = new ArrayList<>();

	final private int NOTA_PREDETERMIADA = 0;

	/*********************** METODOS **********************************/

	public void setDatos() {
		Modulo crear;
		String modulo;
		int repetidor;
		int seguir;
		boolean exsiste;

		nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		apellido = JOptionPane.showInputDialog("Introduce tu apellido");
		ciclo = JOptionPane.showInputDialog("Introduce tu ciclo");

		repetidor = JOptionPane.showConfirmDialog(null, "Eres repetidor");
		if (repetidor == 0) {
			esRepetidor = true;
		} else {
			esRepetidor = false;
		}

		do {
			modulo = JOptionPane.showInputDialog("Introduce un modulo");
			exsiste = false;

			for (int i = 0; i < modulos.size(); i++) {
				if (modulos.get(i).getNombre().equalsIgnoreCase(modulo)) {
					JOptionPane.showMessageDialog(null, "El modulo introducido ya existe", "ERROR", 0);
					exsiste = true;
					i = modulos.size() + 1;
				}
			}
			if (!exsiste) {
				crear = new Modulo(modulo, NOTA_PREDETERMIADA);
				modulos.add(crear);
			}
			seguir = JOptionPane.showConfirmDialog(null, "¿Quieres introducir otro modulo?");
		} while (seguir == 0);
	}

	public void mostrar() {
		String modulos1 = "";
		for (int i = 0; i < modulos.size(); i++) {
			modulos1 += " ".concat(modulos.get(i).getNombre());
		}
		JOptionPane.showMessageDialog(null, "NIF: " + nif + "\nNombre: " + nombre + "\nApellido: " + apellido
				+ "\nCiclo: " + ciclo + "\nRepetidor: " + esRepetidor + "\nModulos: " + modulos1);
	}

	public void mostrarNota() {
		
	}

	/*********************** CONSTRUCTORES **********************************/

	public Alumno(String nif) {
		this.nif = nif;
	}

	public Alumno(String nif, String nombre, String apellido, String ciclo, boolean esRepetidor) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciclo = ciclo;
		this.esRepetidor = esRepetidor;
	}

	/*********************** GETTERS && SETTERS **********************************/
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

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

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isEsRepetidor() {
		return esRepetidor;
	}

	public void setEsRepetidor(boolean esRepetidor) {
		this.esRepetidor = esRepetidor;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public int getNOTA() {
		return NOTA_PREDETERMIADA;
	}

	public int getNOTA_PREDETERMIADA() {
		return NOTA_PREDETERMIADA;
	};

}
