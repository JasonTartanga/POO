package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clases.Alumno;

public class Main {

	public static void main(String[] args) {
		List<Alumno> alumnos = new ArrayList<>();

		int opc;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("OPC"));

			if (alumnos.size() != 0 || !(opc > 1 && opc < 19)) {
				switch (opc) {
				case 1:
					introducir(alumnos);
					break;
				case 2:
					mostrar(alumnos);
					break;
				case 3:
					mostrarNota(alumnos);
					break;
				case 4:
					modificarNota(alumnos);
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

					break;
				case 12:

					break;
				case 13:

					break;
				case 14:

					break;
				case 15:

					break;
				case 16:

					break;
				case 17:

					break;
				case 18:

					break;
				case 19:
					JOptionPane.showMessageDialog(null, "Has decidido salir", "ADIOS", 1);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "ERROR", 0);
					break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay alumnos introducidos", "FALLOS", 1);
			}
		} while (opc != 15);

	}

	private static void modificarNota(List<Alumno> alumnos) {
		String nif;
		String modulo;
		int nota;
		boolean existe = false;
		boolean tiene = false;

		nif = JOptionPane.showInputDialog("Introduce el nif");
		modulo = JOptionPane.showInputDialog("Introduce el modulo");

		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {
				existe = true;
				for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
					if (alumnos.get(i).getModulos().get(j).getNombre().equalsIgnoreCase(modulo)) {

						if (alumnos.get(i).getModulos().get(j).getNota() == 0) {
							JOptionPane.showMessageDialog(null,
									"No se puede modificar porque aun no se ha introducido.\nPero puede introducir una nota.");
						}
						nota = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nota"));
						tiene = true;
						if (nota >= 0 && nota <= 10) {
							alumnos.get(i).getModulos().get(j).setNota(nota);
						} else {
							JOptionPane.showMessageDialog(null, "Nota debe ser >= 1 y <= 10", "ERROR", 0);
						}
					}

				}

			}

		}
		if (!existe) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado a este alumno", "ERROR", 0);
		} else {
			if (!tiene) {
				JOptionPane.showMessageDialog(null, "No tiene ese modulo", "ERROR", 0);
			}
		}
	}

	private static void mostrarNota(List<Alumno> alumnos) {
		String nif = JOptionPane.showInputDialog("Introduce tu NIF");

		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {
				for (int j = 0; j < alumnos.get(i).getModulos().size(); j++) {
					if (alumnos.get(i).getModulos().get(j).getNota() == 0) {
						JOptionPane.showMessageDialog(null,
								"Modulo: " + alumnos.get(i).getModulos().get(j).getNombre() + "\nNota: " + "SIN NOTA",
								alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellido(), 2);

					} else {
						JOptionPane.showMessageDialog(null,
								"Modulo: " + alumnos.get(i).getModulos().get(j).getNombre() + "\nNota: "
										+ alumnos.get(i).getModulos().get(j).getNota(),
								alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellido(), 2);
					}
				}
			}
		}

	}

	private static void mostrar(List<Alumno> alumnos) {
		for (Alumno alumno : alumnos) {
			alumno.mostrar();
		}
	}

	private static void introducir(List<Alumno> alumnos) {
		Alumno crear;
		String nif;
		int seguir = 0;
		boolean existe;

		for (int i = alumnos.size(); i <= alumnos.size() || seguir == 0; i++) {
			nif = JOptionPane.showInputDialog("Introduce tu nif");
			existe = false;

			for (int j = 0; j < alumnos.size(); j++) {
				if (alumnos.get(j).getNif().equalsIgnoreCase(nif)) {
					JOptionPane.showMessageDialog(null, "Ese nif ya existe", "ERROR", 0);
					existe = true;
					j = alumnos.size() + 1;
				}
			}
			if (!existe) {
				crear = new Alumno(nif);
				crear.setDatos();
				alumnos.add(crear);
			}
			seguir = JOptionPane.showConfirmDialog(null, "¿Quieres continuar introduciendo alumnos?");

			if (seguir == 1) {
				i = alumnos.size() + 1;
			}
		}

	}

}
