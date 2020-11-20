package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Entidades.Asignatura;
import Entidades.Profesor;

public class ProcesamientoXMLJSON implements IProcesamiento{

	@Override
	public ArrayList<Asignatura> leerAsignaturas(String ruta) throws JAXBException, ParserConfigurationException, SAXException, IOException {
		// TODO Leer según lo indicado en el apartado 3 del exámen
		
		//Leer por DOM
		ArrayList<Asignatura> asigDOM= UtilFichero.leerDOM(ruta);

		System.out.println("Leidas con DOM");
		for(Asignatura a:asigDOM) {
			System.out.println(a);
		}
		
		//Con SAX
		
		ArrayList<Asignatura> asigSAX = UtilFichero.leerSAX(ruta);

		System.out.println("Leidas con SAX");
		for(Asignatura a:asigSAX) {
			System.out.println(a);
		}
		
		
		
		//Con JAXB
		ArrayList<Asignatura> asignaturas = UtilFichero.leerJAXB(ruta);
		return asignaturas;
		
		
		
		
	}

	@Override
	public void guardarAsignaturas(String ruta,ArrayList<Asignatura> asignaturas) throws IOException {
		//En JSON
		UtilFichero.guardarJSON(asignaturas, ruta);
		
		
		//En DOM
		UtilFichero.guardarDOM(asignaturas, ruta+".xml");
	}

	@Override
	public void guardarProfesores(ArrayList<Profesor> profesores,String ruta) throws JAXBException {
		// TODO Guardar según lo indicado en el apartado 4 del exámen
		UtilFichero.escribirProfesoresJAXB(profesores, ruta);
	}
	
	
	@Override
	public void imprimirAsignaturas(String ruta) {
		// No implementar nada
		
	}

}
