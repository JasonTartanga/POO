package main;

import java.util.ArrayList;
import java.util.List;

import clases.Empleado;
import utilidades.Utilidades;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		List<Empleado> empleados = new ArrayList<>();

		int opc;

		do {
			opc = Integer
					.parseInt(JOptionPane.showInputDialog("1. Introducir\n2.\n3.\n4.\n5.\n6.\n7.\n8.\n9.\n10.\n11"));
			switch (opc) {
			case 1:
				introducir(empleados);
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;
			case 10:

				break;
			case 11:
				JOptionPane.showMessageDialog(null, "Has decidido salir", "Adios", 2);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "ERROR", 0);
				break;
			}
		} while (opc != 11);

	}

	private static void introducir(List<Empleado> empleados) {
		Empleado crear;
		String dni = null;
		boolean existe = false;
		boolean continuar;

		for (Empleado empleado : empleados) {
			dni = Utilidades.intrducirCadena("Introduce tu DNI");
			existe = Utilidades.buscarDni(empleados, dni);

		}
		if (!existe) {
			crear = new Empleado();
			crear.setDatos(dni);
			empleados.add(crear);
		}
	}

}
