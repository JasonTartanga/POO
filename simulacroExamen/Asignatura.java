package ejercicio1;

import javax.swing.JOptionPane;

public class Asignatura {

	private String nombre;
	private String curso;
	private int matriculados;
	private int suspensos;

// Metodos
	public void setDatos() {
		matriculados = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de matriculados", 0));
		suspensos = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de suspensos", 0));

	}

	public void mostrar() {
		JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nCurso: " + curso + "\nMatriculados: "
				+ matriculados + "\nSuspensos: " + suspensos);
	}

	public void mostrarAsignatura() {
		JOptionPane.showMessageDialog(null, "Curso: " + curso + "\nAsignatura: " + nombre + "\nPorcentaje Aprovados: "
				+ porcentajeAprobados() + "%");
	}

	public float porcentajeAprobados() {
		return (numeroAprobados() * 100) / matriculados;
	}

	public int numeroAprobados() {
		return matriculados - suspensos;
	}

//Constructores	
	public Asignatura(String nombre, String curso) {
		this.nombre = nombre;
		this.curso = curso;
	}

	public Asignatura(String nombre, String curso, int matriculados, int suspensos) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.matriculados = matriculados;
		this.suspensos = suspensos;
	}

//ToString
	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", curso=" + curso + ", matriculados=" + matriculados + ", suspensos="
				+ suspensos + "]";
	}

// Getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(int matriculados) {
		this.matriculados = matriculados;
	}

	public int getSuspensos() {
		return suspensos;
	}

	public void setSuspensos(int suspensos) {
		this.suspensos = suspensos;
	}
}
