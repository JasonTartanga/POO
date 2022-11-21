package ejercicio1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Asignatura[] asignatura = new Asignatura[100];

		asignatura[0] = new Asignatura("PRG", "1DAM", 25, 5);
		asignatura[1] = new Asignatura("PRG", "2DAM", 25, 9);
		asignatura[2] = new Asignatura("BDA", "1DAM", 25, 10);
		asignatura[3] = new Asignatura("LMS", "1DAM", 25, 1);
		asignatura[4] = new Asignatura("LMS", "2DAM", 25, 0);
		asignatura[5] = new Asignatura("FOL", "1DAM", 25, 25);

		int opc;
		int numAsignaturas = 6;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"1. Introducir asignaturas\n2. Mostrar porcentaje\n3. Ordenar\n4. Modificar\n5. Mostrar\n6. Salir"));

			switch (opc) {
			case 1:
				numAsignaturas = introducirAsignaturas(asignatura, numAsignaturas);
				break;
			case 2:
				porcentajeAprovados(asignatura, numAsignaturas);
				break;
			case 3:
				ordenarAprovados(asignatura, numAsignaturas);
				break;
			case 4:
				modificar(asignatura, numAsignaturas);
				break;
			case 5:
				mostrar(asignatura, numAsignaturas);
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Has decidido salir", "ERROR", 2);
				break;

			default:
				break;
			}
		} while (opc != 6);

	}

	private static void mostrar(Asignatura[] asignatura, int numAsignaturas) {
		if (numAsignaturas != 1) {
			for (int i = 0; i < numAsignaturas; i++) {
				asignatura[i].mostrar();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay ninguna asignatura creada", "ERROR", 0);
		}
	}

	private static void modificar(Asignatura[] asignatura, int numAsignaturas) {
		if (numAsignaturas != 1) {
			String nombre = JOptionPane.showInputDialog("Introduce una asignatura");
			String[] opciones = { "Nº Alumnos", "Nº Suspensos", "Ambos" };
			int opc;

			for (int i = 0; i < numAsignaturas; i++) {
				if (asignatura[i].getNombre().equalsIgnoreCase(nombre)) {
					opc = JOptionPane.showOptionDialog(null, "¿Que quires modificar?", asignatura[i].getCurso(), 0, 3,
							null, opciones, 0);
					switch (opc) {
					case 0:
						asignatura[i].setMatriculados(
								Integer.parseInt(JOptionPane.showInputDialog("Introduce el nuevo numero de Alumnos")));
						break;
					case 1:
						asignatura[i].setSuspensos(Integer
								.parseInt(JOptionPane.showInputDialog("Introduce el nuevo numero de Suspensos")));
						break;
					case 2:
						asignatura[i].setMatriculados(
								Integer.parseInt(JOptionPane.showInputDialog("Introduce el nuevo numero de Alumnos")));
						asignatura[i].setSuspensos(Integer
								.parseInt(JOptionPane.showInputDialog("Introduce el nuevo numero de Suspensos")));
						break;
					case -1:
						i = numAsignaturas;
						break;

					default:
						break;
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay ninguna asignatura creada", "ERROR", 0);
		}
	}

	private static void ordenarAprovados(Asignatura[] asignatura, int numAsignaturas) {
		if (numAsignaturas != 1) {
			Asignatura[] asignatura1 = new Asignatura[numAsignaturas];

			for (int i = 0; i < numAsignaturas; i++) {
				asignatura1[i] = asignatura[i];
			}

			for (int i = 0; i < numAsignaturas; i++) {
				for (int j = i + 1; j < numAsignaturas; j++) {
					if (asignatura1[j].numeroAprobados() > asignatura1[i].numeroAprobados()) {
						Asignatura intercambio = asignatura1[i];
						asignatura1[i] = asignatura1[j];
						asignatura1[j] = intercambio;
					}
				}
				asignatura1[i].mostrar();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay ninguna asignatura creada", "ERROR", 0);
		}

	}

	private static void porcentajeAprovados(Asignatura[] asignatura, int numAsignaturas) {
		if (numAsignaturas != 1) {
			String curso = JOptionPane.showInputDialog("Introduce un curso:");
			boolean existe = false;

			for (int i = 0; i < numAsignaturas; i++) {
				if (asignatura[i].getCurso().equalsIgnoreCase(curso)) {
					asignatura[i].mostrarAsignatura();
					existe = true;
				}
			}
			if (!existe) {
				JOptionPane.showMessageDialog(null, "No se encuentra el curso: " + curso, "ERROR", 0);
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay ninguna asignatura creada", "ERROR", 0);
		}
	}

	private static int introducirAsignaturas(Asignatura[] asignatura, int numAsignaturas) {
		int seguir = 0;
		for (int i = 0; i < numAsignaturas && seguir != 1; i++) {
			asignatura[i] = new Asignatura();
			asignatura[i].setDatos();
			seguir = JOptionPane.showConfirmDialog(null, "¿Continuar introduciendo asignaturas?");
			numAsignaturas++;
		}
		return numAsignaturas;
	}

}
