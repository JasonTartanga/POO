package ejercicio4;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

//Variables, array, y personas predefinidas
		int opc = 0;
		int cuentasCreadas = 0;

		Cuenta[] cuenta = new Cuenta[50];

		cuenta[0] = new Cuenta("Jason", 720);
		cuenta[1] = new Cuenta("Adrian", 69);
		cuenta[2] = new Cuenta("Manolas", 420);
		cuenta[3] = new Cuenta("Kileerr", 11);
		cuenta[4] = new Cuenta("Maik", 1000);
		cuentasCreadas = 5;

//Creamos menu y preguntamos opcion
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"1.Introducir cuentas\n2.Cantidad de cuentas\n3.Ingresar mediante titular\n4.Comision\n5.Mayor saldo\n6.Superiores a saldo introducido\n7.Titular concreto\n8.Buscar por grupod de caracteres\n9.Mostrar cuentas ordenadas\n10.Salir"));

//Menu
			switch (opc) {

			case 1:
				cuentasCreadas = crear(cuenta, cuentasCreadas);
				break;
			case 2:
				mostrar(cuenta, cuentasCreadas);
				break;
			case 3:
				ingresarEspecifico(cuenta, cuentasCreadas);
				break;
			case 4:
				comision(cuenta, cuentasCreadas);
				break;
			case 5:
				mayorSaldo(cuenta, cuentasCreadas);
				break;
			case 6:
				saldoSuperior(cuenta, cuentasCreadas);
				break;
			case 7:
				titularConcreto(cuenta, cuentasCreadas);
				break;
			case 8:
				titularSemiConcreto(cuenta, cuentasCreadas);
				break;
			case 9:
				ordenar(cuenta, cuentasCreadas);
				break;
			case 10:
			case -1:
				JOptionPane.showMessageDialog(null, "Has decidido salir", "SALIR", JOptionPane.WARNING_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} while (opc != 10);
	}

//Introducir cuentas, 50 como maximo, aunque no obligatorio. Poder detener cuando se decida
	private static int crear(Cuenta[] cuenta, int cuentasCreadas) {
		int continuar = 0;

		do {
			cuenta[cuentasCreadas] = new Cuenta();
			cuenta[cuentasCreadas].setDatos();
			continuar = JOptionPane.showConfirmDialog(null, "¿Crear otra cuenta?");
			cuentasCreadas++;
		} while (cuentasCreadas >= 50 || continuar == 0);
		return cuentasCreadas;
	}

//Mostrar todas las cuentas introducidas
	private static void mostrar(Cuenta[] cuenta, int cuentasCreadas) {
		for (int i = 0; i < cuentasCreadas; i++) {
			cuenta[i].mostrar();
		}
	}

//Ingresar una cantidad a un titular concreto
	private static void ingresarEspecifico(Cuenta[] cuenta, int cuentasCreadas) {
		int opc;

		String buscar = JOptionPane.showInputDialog("Introduce un titular");

		for (int i = 0; i < cuentasCreadas; i++) {
			if (cuenta[i].getTitular().equalsIgnoreCase(buscar)) {
				opc = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?", "OPCIONES", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Ingresar", "Retirar" }, "Ingresar");
				switch (opc) {
				case 0:
					cuenta[i].ingresar(
							Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad a ingresar")));
					break;
				case 1:
					cuenta[i].retirar(Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad a retirar")));
					break;
				}
			}
		}
	}

//Retirar de todas las cuentas 12€ como comision
	private static void comision(Cuenta[] cuenta, int cuentasCreadas) {

		for (int i = 0; i < cuentasCreadas; i++) {
			cuenta[i].retirar(12);
		}
	}

//Muestra la cuenta de mayor saldo
	private static void mayorSaldo(Cuenta[] cuenta, int cuentasCreadas) {
		float mayorSaldo = 0;
		int mayorTitular = 0;

		for (int i = 0; i < cuentasCreadas; i++) {
			if (cuenta[i].getCantidad() > mayorSaldo) {
				mayorTitular = i;
			}
		}
		cuenta[mayorTitular].mostrar();
	}

//Muestra las cuentas que tengan un saldo supperior a uno introducido por teclado
	private static void saldoSuperior(Cuenta[] cuenta, int cuentasCreadas) {
		float saldoSuperior = Integer.parseInt(JOptionPane.showInputDialog("Introduce el saldo minimo"));

		for (int i = 0; i < cuentasCreadas; i++) {
			if (cuenta[i].getCantidad() > saldoSuperior) {
				cuenta[i].mostrar();
			}
		}
	}

//Muestra la cuenta de un titular concreto
	private static void titularConcreto(Cuenta[] cuenta, int cuentasCreadas) {
		String buscar = JOptionPane.showInputDialog("Introduce un titular");
		boolean existeTitular = false;

		for (int i = 0; i < cuentasCreadas; i++) {
			if (cuenta[i].getTitular().equalsIgnoreCase(buscar)) {
				cuenta[i].mostrar();
				existeTitular = true;
			}
		}
		if (!existeTitular) {
			JOptionPane.showMessageDialog(null, "El titular: " + buscar + " no existe", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

//Muestra las cuentas de los tutylares que contengan un grupo de letras
	private static void titularSemiConcreto(Cuenta[] cuenta, int cuentasCreadas) {
		String caracteres = JOptionPane.showInputDialog("Introduce un titular");
		boolean existeTitular = false;

		for (int i = 0; i < cuentasCreadas; i++) {
			if ((cuenta[i].getTitular().toUpperCase()).contains(caracteres.toUpperCase())) {
				cuenta[i].mostrar();
				existeTitular = true;
			}
		}
		if (!existeTitular) {
			JOptionPane.showMessageDialog(null, "El titular con los caracteres: " + caracteres + " no existe", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

//Ordena las cuentas segun su saldo
	private static void ordenar(Cuenta[] cuenta, int cuentasCreadas) {
		Cuenta[] cuenta2 = new Cuenta[50];

		for (int i = 0; i < cuentasCreadas; i++) {
			cuenta2[i] = new Cuenta(cuenta[i].getTitular(), cuenta[i].getCantidad());
		}

		for (int i = 0; i < cuentasCreadas; i++) {
			for (int j = i + 1; j < cuentasCreadas; j++) {
				if (cuenta2[j].getCantidad() > cuenta2[i].getCantidad()) {
					float intercambioCantidad = cuenta2[i].getCantidad();
					cuenta2[i].setCantidad(cuenta2[j].getCantidad());
					cuenta2[j].setCantidad(intercambioCantidad);

					String intercambioTitular = cuenta2[i].getTitular();
					cuenta2[i].setTitular(cuenta2[j].getTitular());
					cuenta2[j].setTitular(intercambioTitular);
				}
			}
			cuenta2[i].mostrar();
		}
	}
}
