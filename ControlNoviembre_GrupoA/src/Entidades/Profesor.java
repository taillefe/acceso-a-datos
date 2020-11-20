package Entidades;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.annotations.Expose;

public class Profesor implements Serializable{
	
	@Expose(deserialize=false, serialize=false)
	private int id;
	@Expose
	private String nombre;
	@Expose
	private String apellidos;

	@XmlTransient
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Profesor(int id, String nombre, String apellidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Profesor() {
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Profesor->{id: %d Nombre:%s Apellidos:%s}", getId(),getNombre(),getApellidos());
	}
}
