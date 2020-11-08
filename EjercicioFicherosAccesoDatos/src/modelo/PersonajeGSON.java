package modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import modelo.Personaje.TipoImportancia;

/**
 * 
 * @author laura
 * clase PersonajeGSON es un duplicado de la clase Personaje que se usa para 
 * el procesamiento del fichero JSONGSON
 */
public class PersonajeGSON implements Serializable{
	

	@SerializedName("nombre")
	@Expose String nombre;
	
	@SerializedName("importancia")
	@Expose	TipoImportancia importancia;
	
	//El enumerado TipoImportancia se define en Personaje 
//	public enum TipoImportancia {
//		PRINCIPAL, SECUNDARIO, RECURRENTE;
//	}

	// constructor vacío
	public PersonajeGSON() {
	}
	
	//constructor
	public PersonajeGSON(String nombre, TipoImportancia importancia) {
		super();
		this.nombre = nombre;
		this.importancia = importancia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoImportancia getImportancia() {
		return importancia;
	}
	public void setImportancia(TipoImportancia importancia) {
		this.importancia = importancia;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + " + importancia =" + importancia +"]";
	}
}
