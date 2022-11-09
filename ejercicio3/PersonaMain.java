package ejercicio3;

import javax.swing.JOptionPane;

public class PersonaMain {

	public static void main(String[] args) {

		Persona[] persona = new Persona[4];

		persona[0] = new Persona("Jason", 18, "79398882F");
		persona[1] = new Persona("Adrian", 17, "22739534K");
		persona[2] = new Persona("Manolas", 10, "129846579Q");
		persona[3] = new Persona("Kileer", 22, "X5389643L");

		int opc;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null,
					"1-Preguntar \n2-Mostrar legales \n3-Encontrar via DNI \n4-Mostrar \n5-Salir",
					"       ------- INTRODUCE UNA OPCION -------", JOptionPane.QUESTION_MESSAGE));

			switch (opc) {
			case 1:
				preguntar(persona);
				break;

			case 2:
				esMayorDeEdad(persona);
				break;

			case 3:
				buscar(persona);
				break;

			case 4:
				mostrar(persona);
				break;

			case 5:
				JOptionPane.showMessageDialog(null, "Has decidido salir");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			}

		} while (opc != 5);

	}

	/*
	 * private static void preguntar(Persona[] persona) { for (int i = 0; i <
	 * persona.length; i++) { persona[i] = new Persona();
	 * persona[i].preguntar().toUppercase(); } }
	 */
	private static void preguntar(Persona[] persona) {
		persona[0] = new Persona("Jason", 18, "79398882F");
		persona[1] = new Persona("Adrian", 17, "22739534K");
		persona[2] = new Persona("Manolas", 10, "129846579Q");
		persona[3] = new Persona("Kileer", 22, "X5389643L");
	}

	private static void mostrar(Persona[] persona) {
		for (int i = 0; i < persona.length; i++) {
			persona[i].mostrar();
		}
	}

	private static void esMayorDeEdad(Persona[] persona) {
		int mayor = 0;
		
		for (int i = 0; i < persona.length; i++) {
			if (persona[i].getEdad() > mayor) {
				mayor = i;
			}
		}persona[mayor].mostrar();
	}

	private static void buscar(Persona[] persona) {
		String buscar;
		boolean encontrado = false;
		buscar = JOptionPane.showInputDialog("Introduce el DNI").toUpperCase();

		for (int i = 0; i < persona.length; i++) {
			if (persona[i].getDni().equalsIgnoreCase(buscar)) {
				persona[i].mostrar();
				encontrado = true;
			}
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "No se ha encontrado a nadie con ese DNI", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
