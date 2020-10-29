package negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import modelo.Libro;

public class ProcesamientoFicheroSAX {
	
	public List<Libro> leerFichero(String ruta) throws IOException {
	
		List<Libro> listaLibros = new ArrayList();
	
		XMLReader lector = XMLReaderFactory.createXMLReader();
		ParseadorLibrosSAX parser = new ParseadorLibrosSAX();
		lector.setContentHandler(parser);
		InputSource fichero = new InputSource(ruta);
		lector.parse(fichero);;
		listaLibros = parser.obtenerResultado();

}
}
