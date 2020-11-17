package modelo;

import modelo.LocalDateAdapter;
import java.io.Serializable;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


// para que los campos salgan en el orden que hemos decidido
@XmlType(propOrder={"titulo", "editorial" , "autor", "fecha", "genero", "personajes" })

/**
 * 
 * @author laura
 * clase libro donde se definen los campos que se van a usar para guardar los datos en el fichero
 * es Serializable para que pueda guardarse como binario
 */
public class Libro implements Serializable{
	
	//variables donde se guardan las características del libro
	String titulo;
	String editorial;
	String autor;
	LocalDate fecha;
	String genero;

	//Personajes es una lista de personajes que puede tener el libro
	private List<Personaje> personajes;
	
	// constructor vacío
	public Libro() {
		
	}
	
	// constructor
	public Libro(String titulo, String editorial, String autor, LocalDate fecha, String genero,
			List<Personaje> personajes) {
		super();
		this.titulo = titulo;
		this.editorial = editorial;
		this.autor = autor;
		this.fecha = fecha;
		this.genero = genero;
		this.personajes = personajes;
	}

	
	public String getTitulo() {
		return titulo;
	}
	@XmlElement
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}
	
	@XmlElement
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}
	
	@XmlElement
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public LocalDate getFecha() {
		return fecha;
	}

	@XmlElement	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return genero;
	}
	
	@XmlElement
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@XmlElementWrapper(name="personajes")  // crea una lista de personaje en personajes
    @XmlElement(name="personaje")
	public List<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", editorial=" + editorial + ", autor=" + autor + ", fecha=" + fecha
				+ ", genero=" + genero + ", personajes=" + personajes + "]";
	}
	
	
	

}
