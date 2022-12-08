package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clases.Empleado;
import clases.Jefe;

public class Main {

	public static void main(String[] args) {

		List<Empleado> empleados = new ArrayList<>();

		Empleado a = new Jefe("1234", "Jason", 8, 2018, 12, "PRG");
		Empleado b = new Empleado("1235", "Adrian", 7, 2016, 25);
		Empleado c = new Empleado("1236", "Costin", 12, 2018, 5);
		Empleado d = new Jefe("1237", "Imanol", 9, 2004, 12, "BDA");
		Empleado e = new Empleado("1238", "Mikel", 7, 2021, 58);
		Empleado f = new Jefe("1239", "Yolo", 3, 2020, 32, "PRG");
		empleados.add(a);
		empleados.add(b);
		empleados.add(c);
		empleados.add(d);
		empleados.add(e);
		empleados.add(f);
		int opc;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"0. Introducir\n1. Mostrar\n2. Mostrar Jefe\n3. Buscar x departamento\n4. Buscar x nombre\n5.Buscar x Salario\n6. Buscar x Antiguedad\n7. Dar de baja\n8. Listado de Departamentos\n9. Salir"));

			switch (opc) {
			case 0:
				introducir(empleados);
				break;
			case 1:
				mostrar(empleados);
				break;
			case 2:
				mostrarJefes(empleados);
				break;
			case 3:
				mostrarDepartamento(empleados);
				break;
			case 4:
				buscarXNombre(empleados);
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
				JOptionPane.showMessageDialog(null, "Has decidido salir", "ADIOS", 1);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "ERROR", 0);
				break;
			}
		} while (opc != 9);

	}

	private static void buscarXNombre(List<Empleado> empleados) {
		String nombre = JOptionPane.showInputDialog("Introduce un nombre");
		boolean existe = false;

		for (Empleado empleado : empleados) {
			if (empleado.getNombre().equalsIgnoreCase(nombre)) {
				empleado.mostrarXNombre(empleado);
				existe = true;
			}
		}
		if (!existe) {
			JOptionPane.showMessageDialog(null, "No existe ese Empleado", "FALLO", 2);
		}
	}

	private static void mostrarDepartamento(List<Empleado> empleados) {
		String departamento = JOptionPane.showInputDialog("Introduce un departamento");
		String mostrar = "";
		boolean existe = false;

		for (Empleado jefe : empleados) {
			if (jefe instanceof Jefe) {
				if (((Jefe) jefe).getDepartamento().equalsIgnoreCase(departamento)) {
					mostrar += jefe.getNombre() + "\n";
					existe = true;
				}
			}
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mostrar, "JEFE/S del departamento " + departamento, 1);
		} else {
			JOptionPane.showMessageDialog(null, "No hay ningun Jefe para ese departamento", "FALLO", 2);
		}

	}

	private static void mostrarJefes(List<Empleado> empleados) {
		for (Empleado jefe : empleados) {
			if (jefe instanceof Jefe) {
				jefe.getDatos(jefe);
			}
		}

	}

	private static void mostrar(List<Empleado> empleados) {
		for (Empleado empleado : empleados) {
			empleado.getDatos(empleado);
		}

	}

	private static void introducir(List<Empleado> empleados) {
		Empleado crear;
		String dni;
		String[] opc = { "Empleado", "Jefe" };
		int seguir = 0;

		for (int i = empleados.size(); i <= empleados.size() || seguir == 0; i++) {
			dni = JOptionPane.showInputDialog("Introduce el DNI");
			if (buscarDNI(dni, empleados) >= 0) {
				JOptionPane.showMessageDialog(null, "Ese DNI ya existe", "ERROR", 0);
			} else {
				if (JOptionPane.showOptionDialog(null, "¿Que eres?", "Elije", 0, 3, null, opc, 0) == 0) {
					crear = new Empleado(dni);
				} else {
					crear = new Jefe(dni);
				}
				crear.setDatos(crear);
				empleados.add(crear);
			}
			seguir = JOptionPane.showConfirmDialog(null, "¿Quieres continuar introduciendo?");
			if (seguir == 1) {
				i = empleados.size() + 1;
			}
		}

	}

	private static int buscarDNI(String dni, List<Empleado> empleados) {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getDni().equalsIgnoreCase(dni)) {
				return i;
			}
		}
		return -1;
	}
}
