package modelo.entidades;

import java.util.List;



public class Ciclo {
	
	int id;
	String nombre;
	String grado;
	
	private List<Asignatura> listaAsignaturas;

	public Ciclo(int id, String nombre, String grado, List<Asignatura> listaAsignaturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.grado = grado;
		this.listaAsignaturas = listaAsignaturas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	@Override
	public String toString() {
		return "Ciclo [id=" + id + ", nombre=" + nombre + ", grado=" + grado + ", listaAsignaturas=" + listaAsignaturas
				+ "]";
	}
	
	

	
	

}
