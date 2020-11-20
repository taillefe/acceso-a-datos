package Modelo;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Entidades.Asignatura;
import Entidades.Profesor;

public interface IProcesamiento {
	public ArrayList<Asignatura> leerAsignaturas(String ruta) throws JAXBException, ParserConfigurationException, SAXException, IOException;
	public void imprimirAsignaturas(String ruta) throws IOException;
	public void guardarAsignaturas(String ruta,ArrayList<Asignatura> asignaturas) throws IOException;
	public void guardarProfesores(ArrayList<Profesor> profesores,String ruta) throws IOException, JAXBException;
}
