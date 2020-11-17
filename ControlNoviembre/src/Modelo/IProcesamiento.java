package Modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import Entidades.Asignatura;
import Entidades.Profesor;
/**
 * 
 * @author Laura
 *
 */
public interface IProcesamiento {
	/**
	 * 
	 * @param ruta
	 * @return
	 */
	public ArrayList<Asignatura> leerAsignaturas(String ruta);
	/**
	 * 
	 * @param ruta
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void imprimirAsignaturas(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException;
	/**
	 * 
	 * @param ruta
	 * @param asignaturas
	 * @throws IOException
	 */
	public void guardarAsignaturas(String ruta,ArrayList<Asignatura> asignaturas) throws IOException;
	/**
	 * 
	 * @param profesores
	 * @param ruta
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws JAXBException
	 */
	public void guardarProfesores(ArrayList<Profesor> profesores,String ruta) throws FileNotFoundException, IOException, JAXBException;
}
