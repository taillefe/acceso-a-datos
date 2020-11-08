package modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

//orden de los campos
@XmlType(propOrder={"nombre", "importancia" })
/**
 * 
 * @author laura
 * clase Personaje, donde se definen los campos de los personajes para guardar sus datos en el archivo
 */
public class Personaje implements Serializable{
	
	//variables que definen las caracteristicas de cada personaje
	String nombre;
	TipoImportancia importancia;
	
	// definicion de un tipo de datos enumerado
	public enum TipoImportancia {
		PRINCIPAL, SECUNDARIO, RECURRENTE;
	}

	// constructor vacío
	public Personaje() {
		
	}
	//constructor
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
	}
}
