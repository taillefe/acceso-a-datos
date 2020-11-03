package negocio;

import java.util.ArrayList;
import java.util.List;

import modelo.Libro;
import modelo.LibroGSON;
import modelo.Personaje;
import modelo.PersonajeGSON;

public class Utilidades {
	
	// método para pasar el listado de libros de la clase LibroGSON a un listado de libros de la clase Libro
	public List<Libro> mapearlibroGSONALibro(List<LibroGSON> listaLibrosGSON){
		List<Libro> listaLibros = new ArrayList<Libro>();
		Libro libro = new Libro();
		
		List<Personaje> listaPersonajes = new ArrayList<Personaje>();
		Personaje personaje = new Personaje();
		
		List<PersonajeGSON> listaPersonajesGSON = new ArrayList<PersonajeGSON>();
		PersonajeGSON personajeGSON = new PersonajeGSON();
	
		LibroGSON libroGSON = new LibroGSON();
		for (LibroGSON l : listaLibrosGSON) {
		
			libro.setTitulo(l.getTitulo());
			libro.setEditorial(l.getEditorial());
			libro.setAutor(l.getAutor());
			libro.setFecha(l.getFecha());
			libro.setGenero(l.getGenero());
			
			for (PersonajeGSON p : l.getPersonajes()) {
				personaje.setNombre(p.getNombre());
				personaje.setImportancia(p.getImportancia());
				
				listaPersonajes.add(personaje);
			}
			
			libro.setPersonajes(listaPersonajes);				
			listaLibros.add(libro);
		
		}
		return listaLibros;
	}
	
	
	// método para pasar el listado de libros de la clase Libro a un listado de libros de la clase LibroGSON
		public List<LibroGSON> mapearlibroALibroGSON(List<Libro> listaLibros){
			List<LibroGSON> listaLibrosGSON = new ArrayList<LibroGSON>();
			LibroGSON libroGSON = new LibroGSON();
			
			List<Personaje> listaPersonajes = new ArrayList<Personaje>();
			Personaje personaje = new Personaje();
			
			List<PersonajeGSON> listaPersonajesGSON = new ArrayList<PersonajeGSON>();
			PersonajeGSON personajeGSON = new PersonajeGSON();
		
			Libro libro = new Libro();
			for (Libro l : listaLibros) {
			
				libroGSON.setTitulo(l.getTitulo());
				libroGSON.setEditorial(l.getEditorial());
				libroGSON.setAutor(l.getAutor());
				libroGSON.setFecha(l.getFecha());
				libroGSON.setGenero(l.getGenero());
				
				for (Personaje p : l.getPersonajes()) {
					personajeGSON.setNombre(p.getNombre());
					personajeGSON.setImportancia(p.getImportancia());
					
					listaPersonajesGSON.add(personajeGSON);
				}
				
				libroGSON.setPersonajes(listaPersonajesGSON);				
				listaLibrosGSON.add(libroGSON);
			
			}
			return listaLibrosGSON;
		}
}
