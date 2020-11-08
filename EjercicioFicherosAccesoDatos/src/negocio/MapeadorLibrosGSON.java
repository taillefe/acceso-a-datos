package negocio;


import java.util.ArrayList;
import java.util.List;

import modelo.Libro;
import modelo.LibroGSON;
import modelo.Personaje;
import modelo.PersonajeGSON;

/**
 * 
 * @author laura
 *  clase MapeadorLibrosGSON que define los métodos 
 * -mapearLibroGSONALibro
 * -mapearLibroALibroGSON
 *
 */
public class MapeadorLibrosGSON {

		// método para pasar el listado de libros de la clase LibroGSON a un listado de libros de la clase Libro
		public static List<Libro> mapearLibroGSONALibro(List<LibroGSON> listaLibrosGSON){
			List<Libro> listaLibros = new ArrayList<Libro>();
			Libro libro = new Libro();
			
			List<Personaje> listaPersonajes = new ArrayList<Personaje>();
			Personaje personaje = new Personaje();
			// por cada libro
			for (LibroGSON l : listaLibrosGSON) {
			
				libro.setTitulo(l.getTitulo());
				libro.setEditorial(l.getEditorial());
				libro.setAutor(l.getAutor());
				libro.setFecha(l.getFecha());
				libro.setGenero(l.getGenero());
				// por cada personaje			
				for (PersonajeGSON p : l.getPersonajes()) {
					personaje.setNombre(p.getNombre());
					personaje.setImportancia(p.getImportancia());
					
					listaPersonajes.add(personaje);
					personaje = new Personaje();
				}
				
				libro.setPersonajes(listaPersonajes);				
				listaLibros.add(libro);
				// inicializar la listaPersonajes  y el libro para el siguiente libro
				listaPersonajes = new ArrayList<Personaje>();
				libro = new Libro();
			}
			return listaLibros;
		} // mapearlibroGSONALibro
		
		
		// método para pasar el listado de libros de la clase Libro a un listado de libros de la clase LibroGSON
			public static List<LibroGSON> mapearLibroALibroGSON(List<Libro> listaLibros){
				List<LibroGSON> listaLibrosGSON = new ArrayList<LibroGSON>();
				LibroGSON libroGSON = new LibroGSON();
				
				List<PersonajeGSON> listaPersonajesGSON = new ArrayList<PersonajeGSON>();
				PersonajeGSON personajeGSON = new PersonajeGSON();
				// por cada libro
				for (Libro l : listaLibros) {
				
					libroGSON.setTitulo(l.getTitulo());
					libroGSON.setEditorial(l.getEditorial());
					libroGSON.setAutor(l.getAutor());
					libroGSON.setFecha(l.getFecha());
					libroGSON.setGenero(l.getGenero());
					// por cada personaje
					for (Personaje p : l.getPersonajes()) {
					
						personajeGSON.setNombre(p.getNombre());
						personajeGSON.setImportancia(p.getImportancia());
						
						listaPersonajesGSON.add(personajeGSON);
						personajeGSON = new PersonajeGSON();
							
					}
					
					libroGSON.setPersonajes(listaPersonajesGSON);
				
					listaLibrosGSON.add(libroGSON);
				
					// inicializar la listaPersonajesGSON  y el libroGSON para el siguiente libro
					listaPersonajesGSON = new ArrayList<PersonajeGSON>();
					libroGSON = new LibroGSON();
				}
				return listaLibrosGSON;
			} // mapearlibroALibroGSON


	
	
	
	

}
