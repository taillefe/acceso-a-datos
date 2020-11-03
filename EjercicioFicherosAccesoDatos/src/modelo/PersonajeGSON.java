package modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PersonajeGSON implements Serializable{
	

	@SerializedName("nombre")
	@Expose String nombre;
	@SerializedName("importancia")
	@Expose	TipoImportancia importancia;
	public enum TipoImportancia {
		PRINCIPAL, SECUNDARIO, RECURRENTE;
	}

	public PersonajeGSON() {
		
	}
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
	};
	
	

}
