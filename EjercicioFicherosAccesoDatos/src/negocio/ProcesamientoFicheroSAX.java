package negocio;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import modelo.Libro;


/**
 * 
 * @author laura
 * clase ProcesamientoFicheroSAX analiza los datos y genera eventos que son
 * procesados por métodos
 * define los métodos 
 * -leerFichero 
 * -guardarFichero 
 *
 */

 public class ProcesamientoFicheroSAX extends ProcesamientoFichero{
	
	
	/** 
	 * 	método leerFichero, se usa para leer los datos de un fichero XML y devolver una lista con los objetos leídos
	 *  funciona como un analizador que genera una serie de eventos al tratar 
	 *  el documento, y esos eventos serán procesados por métodos
	 *  parametros la ruta donde se encuentra el fichero a leer
	 *  devuelve una lista con los objetos Libro que se guardaban en el fichero
	 *  excepciones IOException, SAXException
	 *  		
	 */

	public List<Libro> leerFichero(String ruta) throws IOException, SAXException {
	
		List<Libro> listaLibros = new ArrayList();
	
		XMLReader lector = XMLReaderFactory.createXMLReader();
		ParseadorLibrosSAX parser = new ParseadorLibrosSAX();
		lector.setContentHandler(parser);
		InputSource fichero = new InputSource(ruta);
		lector.parse(fichero);;
		listaLibros = parser.obtenerResultado();
		
		return listaLibros;

	}//leerFichero

	/**
	 * 
	 * 	método guardarFichero, en este caso solo se implementa la cabecera. porque SAX 
	 *  se utiliza en este caso solo para leer el fichero XML
	 *  excepciones IOException, ParserConfigurationException, TransformerException
	 *  		
	 */

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
	}//guardarFichero
}
