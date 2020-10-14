package modelo;

/**
 * 
 * @author Laura
 *
 */
public class Mascota {
	private String nombre;
	private String tipo;
	private int edad;
	private String genero;

	/**
	 * 
	 * @param nombre
	 * @param tipo
	 * @param edad
	 * @param genero
	 */
	public Mascota(String nombre, String tipo, int edad, String genero) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.edad = edad;
		this.genero = genero;
	}//Mascota

	public Mascota() {
		
	} //Mascota vacío
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}//setGenero

	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", tipo=" + tipo + ", edad=" + edad + ", genero=" + genero + "]";
	} //toString
	
	
	
	
	
	
	

}
