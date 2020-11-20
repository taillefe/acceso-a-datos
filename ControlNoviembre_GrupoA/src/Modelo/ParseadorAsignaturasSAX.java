package Modelo;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Entidades.Asignatura;
import Entidades.Profesor;

public class ParseadorAsignaturasSAX extends DefaultHandler {
	private ArrayList<Asignatura> listado;
	private Asignatura asignatura;
	private Profesor profesor;
    private String valorElemento;
    
    private boolean seteadoId=false;
    
    enum tiposNodo{
    	LISTAASIGNATURAS,
    	ASIGNATURA,
    	ID,
    	NOMBRE,
    	HORASASIGNADAS,
    	APELLIDOS,
    	PROFESOR
    	
    }
    
	public ParseadorAsignaturasSAX() {
		super();
	}
	
	@Override
	public void startDocument() throws SAXException {
		listado= new ArrayList<Asignatura>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(localName!=null) {
			switch(tiposNodo.valueOf(localName.toUpperCase())) {
				case ASIGNATURA:
					asignatura = new Asignatura();
					break;
				case PROFESOR:
					profesor = new Profesor();
					break;
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName!=null) {
			switch(tiposNodo.valueOf(localName.toUpperCase())) {
				case ASIGNATURA:
					listado.add(asignatura);
					break;
				case NOMBRE:
					if(asignatura.getNombre()==null)
							asignatura.setNombre(valorElemento);
						else
							profesor.setNombre(valorElemento);;
					break;
				case ID:
					if(seteadoId==false) {
						seteadoId=true;
						asignatura.setId(Integer.valueOf(valorElemento));
					}
					else {
						profesor.setId(Integer.valueOf(valorElemento));
						seteadoId=false;
					}
					break;
				case HORASASIGNADAS:
					asignatura.setHoras(Integer.valueOf(valorElemento));
					break;
				case APELLIDOS:
					profesor.setApellidos(valorElemento);
					break;
				case PROFESOR:
					asignatura.setProfesor(profesor);
					break;
			}
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		valorElemento= new String(ch,start,length);
	}
	
	public ArrayList<Asignatura> obtenerResultado() {
		return listado;
	}

}
