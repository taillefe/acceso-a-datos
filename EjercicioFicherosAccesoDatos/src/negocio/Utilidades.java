package negocio;

import java.util.ArrayList;
import java.util.List;

import modelo.Libro;
import modelo.LibroGSON;
import modelo.Personaje;
import modelo.PersonajeGSON;

public class Utilidades {
	
	public List<Libro> mapearlibroGSON(List<LibroGSON> listaLibrosGSON){
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
			
							
			listaLibros.add(libro);
		
		}
		return listaLibros;
	}
}
