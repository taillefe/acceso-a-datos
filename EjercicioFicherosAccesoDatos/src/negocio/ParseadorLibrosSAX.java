package negocio;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import modelo.Libro;

public class ParseadorLibrosSAX extends DefaultHandler{
	
	private ArrayList<Libro> listadoLibros;
	private Libro libro;
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
	
	public ParseadorLibrosSAX() {
		super();
	}
	

	
	@Override
	public void startDocument() throws SAXException {
		listadoLibros = new ArrayList<Libro>();
	
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName != null) {
			switch(tiposNodo.valueOf(localName.toUpperCase())) {
			case LIBRO:
				libro = new Libro();
				break;
			}
	
		}
		
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName != null) {
			switch (tiposNodo.valueOf(localName.toUpperCase())) {
			case LIBRO:
				listado.add(libro);
				break;
			case TITULO:
				libro.titulo = valorElemento;
				break;
			case EDITORIAL:
			case AUTOR:
			case FECHA:
			case GENERO:
			case PERSONAJES:
			case PERSONAJE:
			case NOMBRE:
			case IMPORTANCIA:
			}
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	}
	
}
