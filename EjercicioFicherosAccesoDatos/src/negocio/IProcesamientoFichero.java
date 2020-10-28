package negocio;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Libro;


public interface IProcesamientoFichero {
	
	public  List<Libro> leerFichero(String ruta) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException;

	
	public   void guardarFichero( List<Libro> listaLibros, String ruta) throws IOException, ParserConfigurationException, TransformerException;


}
