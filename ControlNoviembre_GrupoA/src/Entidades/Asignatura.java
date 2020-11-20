package Entidades;

import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asignatura {
	@XmlTransient
	@Expose(serialize = false, deserialize = false) 
	private int id;
	@SerializedName("nombreAsignatura")
	@Expose
	private String nombre;
	@Expose	
	private int horas;
	@Expose
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
	
	public Asignatura(int id, String nombre, int horas, Profesor profesor) {
		this.id=id;
		this.nombre = nombre;
		this.horas = horas;
		this.profesor=profesor;
	}
	
	public Asignatura() {
		
	}
	
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", horas=" + horas + ", profesor=" + profesor + "]";
	}

	
	
	
	
	
}
