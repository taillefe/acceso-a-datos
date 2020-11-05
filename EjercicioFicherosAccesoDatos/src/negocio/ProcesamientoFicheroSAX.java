package negocio;

import java.io.IOException;
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
 *	clase ProcesamientoFicheroSAX
 *	En este caso solo lo hemos utilizado para leer un fichero XML
 *  el método guardarFichero se hace referencia a él pero no se desarrolla
 *  funciona como un analizador que genera una serie de eventos al tratar 
 *  el documento, y esos eventos serán procesados por métodos
 *
 */
public class ProcesamientoFicheroSAX extends ProcesamientoFichero{
	
	public List<Libro> leerFichero(String ruta) throws IOException, SAXException {
	
		List<Libro> listaLibros = new ArrayList();
	
		XMLReader lector = XMLReaderFactory.createXMLReader();
		ParseadorLibrosSAX parser = new ParseadorLibrosSAX();
		lector.setContentHandler(parser);
		InputSource fichero = new InputSource(ruta);
		lector.parse(fichero);;
		listaLibros = parser.obtenerResultado();
		
		return listaLibros;

}

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
	}
}
