package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JOptionPane;

import clases.Empleado;

public class Utilidades {

	public static String intrducirCadena(String mensaje) {
		String cadena;

		cadena = JOptionPane.showInputDialog(mensaje);
		return cadena;
	}

	public static int introducirEntero(String mensaje) {
		int entero = 0;
		String cadena;
		boolean correcto = true;

		do {
			cadena = intrducirCadena(mensaje);

			try {
				entero = Integer.parseInt(cadena);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "No has introducido un numero entero", "ERROR", 0);
				correcto = false;
			}
		} while (!correcto);

		return entero;
	}

	public static LocalDate introducirFecha(String mensaje) {
		String fechaString;
		boolean existe;
		LocalDate fecha = null;

		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		do {
			existe = true;
			fechaString = JOptionPane.showInputDialog(mensaje + " (dd-mm-aaaa)");

			try {
				fecha = LocalDate.parse(fechaString, formateador);
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "Formato incorecto", "ERROR", 0);
				existe = false;
			}
		} while (!existe);
		return fecha;

	}

	public static int numeroAleatorio(int maximo, int minimo) {
		int random = (int) ((Math.random() * maximo - minimo + 1) + minimo);
		return random;
	}

	public static boolean esBoolean(String mensaje) {
		int respuesta;

		do {
			respuesta = JOptionPane.showConfirmDialog(null, mensaje);

		} while (respuesta != 0 && respuesta != 1);

		if (respuesta == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean buscarDni(List<Empleado> arryList, String dni) {
		for (Empleado i : arryList) {
			if (i.getDni().equalsIgnoreCase(dni)) {
				JOptionPane.showMessageDialog(null, "Este DNI ya existe", "FALLO", 2);
				return true;
			}
		}
		return false;
	}

}