package negocio;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import modelo.Libro;
import modelo.Personaje;
/**
 * 
 * @author laura
 * clase usada en ProcesamientoFicheroSAX
 * que define los métodos startDocument, startElement, endElement, characters
 *	y obtenerResultado 
 */
public class ParseadorLibrosSAX extends DefaultHandler{
	
	private ArrayList<Libro> listadoLibros;
	private ArrayList<Personaje> listadoPersonajes;
	private Libro libro;
	private Personaje personaje;
	private String valorElemento;
	
	enum tiposNodo{
		LIBROS,
		LIBRO,
		TITULO,
		EDITORIAL,
		AUTOR,
		FECHA,
		GENERO,
		PERSONAJES,
		PERSONAJE,
		NOMBRE,
		IMPORTANCIA
	}
	
	/**
	 * definición de constructor vacío
	 */
	public ParseadorLibrosSAX() {
		super();
	}
	

	/**
	 * startDocument
	 * excepciones SAXException
	 *  
	 */
	@Override
	public void startDocument() throws SAXException {
		listadoLibros = new ArrayList<Libro>(); // creo el listado de los libros
	}
	
	/**
	 * startElement
	 * @param  uri,  localName,  qName, attributes
	 *  excepciones SAXException
	 * 
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName != null) {
			switch(tiposNodo.valueOf(localName.toUpperCase())) {
			case LIBRO:
				libro = new Libro();
				listadoPersonajes = new ArrayList<Personaje>();//creo el listado de personajes aqui para cada libro
				break;
			case PERSONAJE:
				personaje = new Personaje(); // creo el personaje
				break;
			}
	
		}
		
	}
	
	/**
	 * endElement
	 * @param  uri,  localName,  qName
	 * excepciones SAXException
	 * 
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName != null) {
			switch (tiposNodo.valueOf(localName.toUpperCase())) {
			case LIBRO:
				listadoLibros.add(libro);
				break;
			case TITULO:
				libro.setTitulo(valorElemento);
				break;
			case EDITORIAL:
				libro.setEditorial(valorElemento);
				break;
			case AUTOR:
				libro.setAutor(valorElemento);
				break;
			case FECHA: // se parsea el dato obtenido como String del fichero a LocalDate
				libro.setFecha(LocalDate.parse(valorElemento, DateTimeFormatter.ofPattern("d/M/yyyy")));
				break;
			case GENERO:
				libro.setGenero(valorElemento);
				break;
			case PERSONAJES:
				libro.setPersonajes(listadoPersonajes);
				break;
			case PERSONAJE:
				listadoPersonajes.add(personaje);
				break;
			case NOMBRE:
				personaje.setNombre(valorElemento);
				break;
			case IMPORTANCIA: 
				personaje.setImportancia(Personaje.TipoImportancia.valueOf(valorElemento.toUpperCase()));
				break;
			}
		}
	}
	
	/**
	 * characters
	 * @param  ch,  start,  length
	 * excepciones SAXException
	 * 
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		valorElemento = new String(ch,start,length);
	}
	
	/**
	 * obtener resultado
	 * @return listadoLibros
	 */
	public ArrayList<Libro> obtenerResultado(){
		return listadoLibros;
	}
}
