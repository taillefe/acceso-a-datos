package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import Entidades.Asignatura;
import Entidades.Profesor;
import Entidades.Profesores;


/**
 * 
 * @author laura
 *
 */
public class ProcesamientoXMLJSON implements IProcesamiento{

	@Override
	/**
	 * leerAsignatura
	 */
	public ArrayList<Asignatura> leerAsignaturas(String ruta) {
		// TODO Leer según lo indicado en el apartado 3 del exámen
		ArrayList<Asignatura> listaAsignaturas = new ArrayList();
		
		XMLReader lector = null;
		try {
			lector = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParseadorAsignaturasSAX parser = new ParseadorAsignaturasSAX();
		lector.setContentHandler(parser);
		InputSource fichero = new InputSource(ruta);
		try {
			lector.parse(fichero);
		} catch (IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		listaAsignaturas = parser.obtenerResultado();
		
		return listaAsignaturas;
	
	
	}

	
	@Override
	/**
	 * guardarAsignaturas
	 */
	public void guardarAsignaturas(String ruta,ArrayList<Asignatura> asignaturas) {
		// TODO guardar según lo indicado en el apartado 3 del exámen
	}

	@Override
	/**
	 * guardarProfesores
	 */
	public void guardarProfesores(ArrayList<Profesor> profesores,String ruta) throws IOException, JAXBException {
		// TODO Guardar según lo indicado en el apartado 4 del exámen
		
		File file = new File(ruta);
		if (!file.exists()) {
			file.createNewFile();
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(Profesores.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Profesores p = new Profesores();
		
		p.setListaProfesores(profesores);
		System.out.println ("p "+p);
	
		jaxbMarshaller.marshal(p,file);

	}
	
	
	@Override
	/**
	 * imprimirAsignaturas
	 */
	public void imprimirAsignaturas(String ruta) {
		// No implementar nada
		
	}

}
