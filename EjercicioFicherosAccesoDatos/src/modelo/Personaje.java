package modelo;

public class Personaje {
	
	String nombre;
	String importancia;
	public enum TipoImportancia {
		Principal, Secundario, Recurrente;
	}

	public Personaje() {
		
	}
	public Personaje(String nombre, TipoImportancia Importancia) {
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
	
	public String getImportancia() {
		return importancia;
	}
	public void setImportancia(String importancia) {
		this.nombre = importancia;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + " + importancia =" + importancia +"]";
	};
	
	

}
