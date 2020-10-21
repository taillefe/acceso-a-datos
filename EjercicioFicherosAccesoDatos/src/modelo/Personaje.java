package modelo;

public class Personaje {
	
	String nombre;
	String genero;
	enum Importancia {
		Principal, Secundario, Recurrente;
	}
	public Personaje(String nombre, String genero) {
		super();
		this.nombre = nombre;
		this.genero = genero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", genero=" + genero + "]";
	};
	
	

}
