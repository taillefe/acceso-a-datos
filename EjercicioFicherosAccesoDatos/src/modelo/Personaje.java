package modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"nombre", "importancia" })
public class Personaje implements Serializable{
	

	String nombre;
	TipoImportancia importancia;
	
	public enum TipoImportancia {
		PRINCIPAL, SECUNDARIO, RECURRENTE;
	}

	public Personaje() {
		
	}
	public Personaje(String nombre, TipoImportancia importancia) {
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
