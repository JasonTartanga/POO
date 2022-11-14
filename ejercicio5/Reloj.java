package ejercicio5;

import javax.swing.JOptionPane;

public class Reloj {

	private int horas;
	private int minutos;
	private int segundos;
	private boolean esValido;

	public void preguntar() {
//Preguntar y validar horas	
		do {
			horas = Integer.parseInt(JOptionPane.showInputDialog("Introduce la hora"));
			if (horas >= 0 && horas <= 23) {
				esValido = true;
			} else {
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "INCORRECTO", 0);
			}
		} while (!esValido);
		esValido = false;

//Preguntar y validar minutos		
		do {
			minutos = Integer.parseInt(JOptionPane.showInputDialog("Introduce los minutos"));
			if (minutos >= 0 && minutos <= 59) {
				esValido = true;
			} else {
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "INCORRECTO", 0);
			}
		} while (!esValido);
		esValido = false;

//Preguntar y validar segundos		
		do {
			segundos = Integer.parseInt(JOptionPane.showInputDialog("Introduce los segundos"));
			if (segundos >= 0 && segundos <= 59) {
				esValido = true;
			} else {
				JOptionPane.showMessageDialog(null, "Introduce una opcion valida", "INCORRECTO", 0);
			}
		} while (!esValido);
	}

	public void mostrar(int num) {
		switch (num) {
		case 0:
			JOptionPane.showMessageDialog(null, horas + " : " + minutos + " : " + segundos);
			break;
		case 1:
			JOptionPane.showMessageDialog(null, horas + "am : " + minutos + " : " + segundos);
			break;
		case 2:
			horas -= 12;
			JOptionPane.showMessageDialog(null, horas + "pm : " + minutos + " : " + segundos);
			horas += 12;
			break;
		default:
			break;
		}
		
	}

	public Reloj() {

	}

	public Reloj(int horas, int minutos, int segundos) {
		super();
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

}
