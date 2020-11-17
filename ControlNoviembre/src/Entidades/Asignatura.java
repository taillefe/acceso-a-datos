package Entidades;

import java.io.Serializable;
/**
 * 
 * @author laura
 * 
 */
public class Asignatura implements Serializable{
	
	private int id;
	private String nombre;
	private int horas;
	private Profesor profesor;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", profesor=" + profesor + "]";
	}
	
	
	//constructor vacio
	public Asignatura() {
		
	}
	
	public Asignatura(int id, String nombre, int horas, Profesor profesor) {
		this.id=id;
		this.nombre = nombre;
		this.horas = horas;
		this.profesor=profesor; // profesor será un string con los datos del profesor
	}

	
	
	
	
	
}
