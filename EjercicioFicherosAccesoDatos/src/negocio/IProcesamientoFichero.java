package negocio;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Libro;

/**
 * 
 * @author laura
 * Interface de los procesamientos de Fichero que se usan en este proyecto
 * -leerFichero
 * -guardarFichero
 * 
 */
public interface IProcesamientoFichero {
	/**
	 * 
	 * @param ruta del fichero
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws JAXBException
	 * @throws TransformerException
	 */
	public  List<Libro> leerFichero(String ruta) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException, JAXBException, TransformerException;

	/**
	 * 
	 * @param listaLibros
	 * @param ruta
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 * @throws JAXBException
	 */
	public   void guardarFichero( List<Libro> listaLibros, String ruta) throws IOException, ParserConfigurationException, TransformerException, JAXBException;


}
