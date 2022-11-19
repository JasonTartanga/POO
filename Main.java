package coche;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Coches[] coche = new Coches[100];

		coche[0] = new Coches("1234ABCD", "Citroen", "Picasso", "Azul", 48, 78, 1250);
		coche[1] = new Coches("5678EFGH", "Ford", "AO·3X", "Verde", 58, 5, 1458);
		coche[2] = new Coches("9123IJKL", "Lexus", "Mercedes", "Rojo", 105, 95, 0123);
		coche[3] = new Coches("4567MNÑO", "Seat", "S3XY", "Blanco", 31, 1025, 25647);
		coche[4] = new Coches("8912PRQU", "Chevrolet", "Picasso", "Blanco", 8, 78, 3500);

		int opc;
		int numCoche = 5;
		do {

			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"1.Introducir Datos\n2.Mostrar\n3.Buscar x Marca\n4.Buscar x Color\n5.Media Centimetro Cubicos\n6.Ordenar x Caballos\n7.Sumar precios\n8.Modificar\n9.Resumen Color\n10.Salir"));

			switch (opc) {
			case 1:
				numCoche = introducirDatos(coche, numCoche);
				break;
			case 2:
				mostrar(coche, numCoche);
				break;
			case 3:
				listarMarca(coche, numCoche);
				break;
			case 4:
				listarColores(coche, numCoche);
				break;
			case 5:
				mediaCc(coche, numCoche);
				break;
			case 6:
				ordenarCaballos(coche, numCoche);
				break;
			case 7:
				sumarPrecios(coche, numCoche);
				break;
			case 8:
				modificar(coche, numCoche);
				break;
			case 9:

				break;
			case 10:
				JOptionPane.showMessageDialog(null, "Has decidido salir", "Adios", 2);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "ERROR", 1);
				break;
			}
		} while (opc != 10);
	}

	private static void modificar(Coches[] coche, int numCoche) {
		String matricula;
		int seguir = 0;
		boolean existe;

		do {
			existe = false;
			matricula = JOptionPane.showInputDialog(null, "Introduce una matricula");

			for (int i = 0; i < numCoche; i++) {
				if (coche[i].getMatricula().equalsIgnoreCase(matricula)) {
					JOptionPane.showMessageDialog(null, "Estas apunto de modificar el coche: " + matricula, "AVISO", 2);
					coche[i].setDatos(matricula);
					existe = true;
				}
			}
			if (!existe) {
				JOptionPane.showMessageDialog(null, "No se ha encontrado ningun coche con esa matricula", "ERROR", 1);
				listarMarca(coche, numCoche);
				seguir = JOptionPane.showConfirmDialog(null, "¿Quieres vovler a intentar introducir una matricula?");
			}
		} while (seguir != 1 && !existe);

	}

	private static void sumarPrecios(Coches[] coche, int numCoche) {
		int suma = 0;
		for (int i = 0; i < numCoche; i++) {
			suma += coche[i].getPrecio();
		}
		JOptionPane.showMessageDialog(null, "La suma de todas los precios es: " + suma);
	}

	private static void ordenarCaballos(Coches[] coche, int numCoche) {
		Coches[] coche1 = new Coches[100];

		for (int i = 0; i < numCoche; i++) {
			coche1[i] = coche[i];
		}

		for (int i = 0; i < numCoche; i++) {
			for (int j = i + 1; j < numCoche; j++) {
				if (coche1[j].getCaballos() > coche1[i].getCaballos()) {
					int intercambio = coche1[i].getCaballos();
					coche1[i].setCaballos(coche1[j].getCaballos());
					coche1[j].setCaballos(intercambio);
				}
			}
			coche1[i].mostrar();
		}
	}

	private static void mediaCc(Coches[] coche, int numCoche) {
		float media = 0;

		for (int i = 0; i < numCoche; i++) {
			media += coche[i].getCc();
		}
		JOptionPane.showMessageDialog(null, "La media de Centimetros Cubicos son: " + (media / numCoche));
	}

	private static void listarColores(Coches[] coche, int numCoche) {
		String color = JOptionPane.showInputDialog("Introduce un color");
		String color2 = JOptionPane.showInputDialog("Introduce otro color");

		for (int i = 0; i < numCoche; i++) {
			if (coche[i].getColor().equalsIgnoreCase(color) || coche[i].getColor().equalsIgnoreCase(color2)) {
				coche[i].mostrar();
			}
		}
	}

	private static void listarMarca(Coches[] coche, int numCoche) {
		String marca = JOptionPane.showInputDialog("Introduce marca");
		boolean existe = false;

		for (int i = 0; i < numCoche; i++) {
			if (coche[i].getMarca().equalsIgnoreCase(marca)) {
				coche[i].mostrar();
				existe = true;
			}
		}

		if (!existe) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado ningun coche con esa marca", "ERROR", 1);
		}
	}

	private static void mostrar(Coches[] coche, int numCoche) {
		for (int i = 0; i < numCoche; i++) {
			coche[i].mostrar();
		}
	}

	private static int introducirDatos(Coches[] coche, int numCoche) {
		String matricula;
		boolean existe;
		int seguir = 0;

		for (int i = 0; i < coche.length || seguir != 1; i++) {
			existe = false;
			matricula = JOptionPane.showInputDialog(null, "Introduce la matricula");

			for (int j = 0; j < numCoche; j++) {
				if (coche[j].getMatricula().equalsIgnoreCase(matricula)) {
					existe = true;
				}
			}
			if (!existe) {
				coche[i] = new Coches();
				coche[i].setDatos(matricula);
				numCoche++;
			}
			seguir = JOptionPane.showConfirmDialog(null, "¿Quieres introducir otro coche?");
		}
		return numCoche;
	}
}
