package ejercicio6;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Personas persona = new Personas();

		int opc;
		int IMC;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"1.Calcular IMC \n2.\n3.\n4.\n5."));

			switch (opc) {
			case 0:
				persona.setDatos();
				break;
			case 1:
				IMC = calcularIMC(persona);
				mesnajeIMC(IMC);
				break;
			case 2:

				break;
			case 10:
				persona.showDatos();
				break;
			case -1:
			JOptionPane.showMessageDialog(null, "Has decidido salir");
			default:
				
				break;
			}
		} while (opc != -1);
	}

	private static void mesnajeIMC(int IMC) {
		switch (IMC) {
		case -1:
			JOptionPane.showMessageDialog(null, "Peso ideal");
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "Estas por debajo de tu peso ideal");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Tienes sobrepeso");
			break;

		default:
			break;
		}
		
	}

	private static int calcularIMC(Personas persona) {
		float IMC = (float) (persona.getPeso() / Math.pow(persona.getAltura(), 2));
		if (IMC > 20) {
			return -1;
		} else if (IMC >= 20 && IMC <= 25) {
			return 0;
		} else {
			return 1;
		}

	}

}
