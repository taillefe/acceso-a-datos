package Modelo;



	import java.io.IOException;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;

	import org.xml.sax.Attributes;
	import org.xml.sax.SAXException;
	import org.xml.sax.helpers.DefaultHandler;

import Entidades.Asignatura;
import Entidades.Profesor;


	
	/**
	 * 
	 * @author laura
	 * clase usada en ProcesamientoXMLSAX
	 * que define los métodos
	 *	y obtenerResultado 
	 */
	public class ParseadorAsignaturasSAX extends DefaultHandler{
		
		private ArrayList<Asignatura> listaAsignaturas;
		private Profesor profesor;
		private Asignatura asignatura;
		private String valorElemento;
		
		enum tiposNodo{
			LISTAASIGNATURAS,
			ASIGNATURA,
			ID,
			NOMBRE,
			HORASASIGNADAS,
			PROFESOR,
			ID_PROF,
			NOMBRE_PROF,
			APELLIDOS
		
		}
		
		/**
		 * definición de constructor vacío
		 */
		public ParseadorAsignaturasSAX() {
			super();
		}
		

		/**
		 * startDocument
		 * excepciones SAXException
		 *  
		 */
		@Override
		public void startDocument() throws SAXException {
			listaAsignaturas = new ArrayList<Asignatura>(); // creo el listado de los libros
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
				case ASIGNATURA:
					asignatura = new Asignatura();
				//	profesor = new Profesor();//creo el profesor de cada asignatura
					break;
				case PROFESOR:
					profesor = new Profesor(); // creo el profesor
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
				case ASIGNATURA:
					listaAsignaturas.add(asignatura);
					break;
				case ID: // si es de la asignatura
					
					asignatura.setId(Integer.valueOf(valorElemento)); 
					
					// si es del profesor
					//profesor.setId(Integer.valueOf(valorElemento));
					break;
				case NOMBRE:
					//si es de la asignatura
					asignatura.setNombre(valorElemento);
				// si es del profesor
				//	profesor.setNombre(valorElemento);
					break;
				case HORASASIGNADAS:
					asignatura.setHoras(Integer.valueOf(valorElemento));
					
					break;
				case PROFESOR: 
					asignatura.setProfesor(profesor);
					break;
				case ID_PROF:
					
					
					
				case NOMBRE_PROF:
					
				
					
				case APELLIDOS:
					profesor.setApellidos(valorElemento);
					
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
		 * @return listadoAsignaturas
		 */
		public ArrayList<Asignatura> obtenerResultado(){
			return listaAsignaturas;
		}


	
	
}
