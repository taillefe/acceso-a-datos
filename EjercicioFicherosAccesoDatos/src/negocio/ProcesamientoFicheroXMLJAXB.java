package negocio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Libro;
import modelo.Libros;

/**
 * 
 * @author laura
 * clase ProcesamientoFicheroXMLJAXB que hereda de ProcesamientoFichero
 * define los m�todos 
 * -leerFichero 
 * -guardarFichero 
 * 
 *
 */

public class ProcesamientoFicheroXMLJAXB extends ProcesamientoFichero {

	/** 
	 * 	m�todo leerFichero, se usa para leer los datos de un fichero y devolver una lista con los objetos le�dos
	 *  @param la ruta donde se encuentra el fichero a leer
	 *  @return devuelve una lista con los objetos Libro que se guardaban en el fichero
	 *  @throws controla las excepciones que se dan en todos los procedimientos y que se heredan 
	 *  		de la interface IProcedimientoFichero 
	 *  		
	 */
	
	@Override
	public List<Libro> leerFichero(String ruta)
			throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException, JAXBException,TransformerException {

		File file = new File (ruta);
		ArrayList<Libro> libros =new ArrayList<Libro>();
		if (file.exists()) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Libros.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			Libros listaLibros =(Libros) jaxbUnmarshaller.unmarshal(file);
			libros = (listaLibros != null ? listaLibros.getListaLibros() : new ArrayList<Libro>());
			
		}else {
			System.out.println("No se ha encontrado el fichero indicado");
		}

		
		return libros;
	} //leerFichero

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException, JAXBException {
		
		File file = new File(ruta);
		if (!file.exists()) {
			file.createNewFile();
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(Libros.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Libros li = new Libros();
		li.setListaLibros((ArrayList<Libro>) listaLibros);
		jaxbMarshaller.marshal(li,file);
		
	} //guardarFichero
	
	
	

}
