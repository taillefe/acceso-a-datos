package modelo;

import java.time.LocalDate;
import java.util.List;

public class Libro {
	
	String titulo;
	String editorial;
	String autor;
	LocalDate fecha;
	String genero;
	List<Personaje> personajes;
	
	public Libro() {
		
	}
	
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