package modelo;

import modelo.LocalDateAdapter;
import java.io.Serializable;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


public class LibroGSON implements Serializable{

	@SerializedName("titulo")
	@Expose
	private String titulo;
	
	@SerializedName("editorial")
	@Expose
	private	String editorial;
	
	@SerializedName("autor")
	@Expose
	private String autor;
	
	@SerializedName("fecha")
	@Expose
	private LocalDate fecha;
	
	@SerializedName("genero")
	@Expose
	private String genero;

	@SerializedName("personajes")
	@Expose
	private List<PersonajeGSON> personajes;
	
	public LibroGSON() {
		
	}
	
	public LibroGSON(String titulo, String editorial, String autor, LocalDate fecha, String genero,
			List<PersonajeGSON> personajes) {
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
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}
	
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}
	
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public LocalDate getFecha() {
		return fecha;
	}

	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getGenero() {
		return genero;
	}
	
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
//	@XmlElementWrapper(name="personajes")
 //   @XmlElement(name="personaje")
	public List<PersonajeGSON> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<PersonajeGSON> personajes) {
		this.personajes = personajes;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", editorial=" + editorial + ", autor=" + autor + ", fecha=" + fecha
				+ ", genero=" + genero + ", personajes=" + personajes + "]";
	}
	
	
	

}
