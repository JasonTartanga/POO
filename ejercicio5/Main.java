package ejercicio5;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Reloj reloj = new Reloj();
		String[] opciones = { "Formato 12h", "Formato 24h", "Cambiar horas" };
		int opc = 0;
		

		reloj.preguntar();
		do {
			opc = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?", "Introduce una opcion valida", 0, 3, null,
					opciones, 0);

			switch (opc) {
			case 0:
				formato12h(reloj);
				break;
			case 1:
				formato24h(reloj);
				break;
			case 2:
				reloj.preguntar();
				break;
			case -1:
				JOptionPane.showMessageDialog(null, "Has decidido salir");
			default:
				break;
			}

		} while (opc != -1);
	}

	private static void formato12h(Reloj reloj) {
		if (reloj.getHoras() > 12) {
			reloj.mostrar(2);
		} else {
			reloj.mostrar(1);
		}
	}

	private static void formato24h(Reloj reloj) {
		reloj.mostrar(0);

	}

}
