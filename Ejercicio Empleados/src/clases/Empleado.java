package clases;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class Empleado {

	protected String dni;
	private String nombre;
	private int mes;
	private int año;
	private float incremento;
	private float sueldoBase = 1000;

	final private String EMPRESA = "Eléctrica S.A";

	/**************** METODOS ***************/
	public int antiguedad() {
		Calendar calendario = Calendar.getInstance();
		int añoActual = calendario.get(Calendar.YEAR);
		int mesActual = calendario.get(Calendar.MONTH)+1;
		System.out.println(añoActual);
		System.out.println(mesActual);
		if (mesActual - mes >= 0) {
			año--;
		}
		return añoActual - año;
	}
	
	public float sueldoFinal() {
		float sueldoFinal = (sueldoBase + (sueldoBase * incremento) / 100);

		if (antiguedad() >= 6) {
			return sueldoFinal + 100;
		} else {
			return sueldoFinal;
		}
	}

	public void setDatos(Empleado crear) {
		nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce el mes de entrada"));
		año = Integer.parseInt(JOptionPane.showInputDialog("Introduce el año de entrada"));
		incremento = Integer.parseInt(JOptionPane.showInputDialog("Introduce el incremento"));
		if (crear instanceof Jefe) {
			((Jefe) crear).setDepartamento(JOptionPane.showInputDialog("Introduce el departamento"));
		}
	}

	public void getDatos(Empleado crear) {
		String mensaje = "Dni: " + dni + "\nNombre: " + nombre + "\nMes: " + mes + "\nAño: " + año + "\nIncremento: "
				+ incremento + "\nSueldo: " + sueldoFinal();

		if (!(crear instanceof Jefe)) {
			JOptionPane.showMessageDialog(null, mensaje, "EMPLEADO", 1);
		} else {
			JOptionPane.showMessageDialog(null, mensaje + "\nDepartamento: " + ((Jefe) crear).getDepartamento(), "JEFE",
					1);
		}
	}

	public void mostrarXNombre(Empleado empleado) {
		boolean esJefe;
		if (empleado instanceof Jefe) {
			esJefe = true;
		} else {
			esJefe = false;
		}
		
		JOptionPane.showMessageDialog(null, "DNI: " + dni + "\nAños: " + antiguedad() + "\n Es Jefe: " + esJefe);
	}

	/**************** CONSTRUCTOR ***************/
	public Empleado(String dni) {
		this.dni = dni;
	}

	public Empleado(String dni, String nombre, int mes, int año, float incremento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.mes = mes;
		this.año = año;
		this.incremento = incremento;
	}

	/**************** GETTERS && SETTERS ***************/
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public float getIncremento() {
		return incremento;
	}

	public void setIncremento(float incremento) {
		this.incremento = incremento;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public String getEMPRESA() {
		return EMPRESA;
	}

}
