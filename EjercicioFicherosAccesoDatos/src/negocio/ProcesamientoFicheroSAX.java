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
 * clase ProcesamientoFicheroSAX que hereda de ProcesamientoFichero
 * define los métodos 
 * -leerFichero 
 * -guardarFichero 
 * 
 *
 */

 public class ProcesamientoFicheroSAX extends ProcesamientoFichero{
	
	
	/** 
	 * 	método leerFichero, se usa para leer los datos de un fichero XML y devolver una lista con los objetos leídos
	 *  funciona como un analizador que genera una serie de eventos al tratar 
	 *  el documento, y esos eventos serán procesados por métodos
	 *  @param la ruta donde se encuentra el fichero a leer
	 *  @return devuelve una lista con los objetos Libro que se guardaban en el fichero
	 *  @throws controla las excepciones que se dan en todos los procedimientos y que se heredan 
	 *  		de la interface IProcedimientoFichero 
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
	 *  método guardarFichero se hace referencia a él pero no se desarrolla
	 */

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
	}//guardarFichero
}
