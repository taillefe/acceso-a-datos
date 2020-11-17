package Entidades;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(propOrder={"id", "nombre" , "apellidos" }) // orden
/**
 * laura
 *
 */
public class Profesor implements Serializable {
	private int id;
	@XmlElement   // se indica que es un elemento
	private String nombre;
	@XmlElement   // se indica que es un elemento
	private String apellidos;

	
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
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
}
