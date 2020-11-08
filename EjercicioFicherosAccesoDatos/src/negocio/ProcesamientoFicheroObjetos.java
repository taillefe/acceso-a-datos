package negocio;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Personaje;

import modelo.Libro;

/**
 * 
 * @author laura
 * clase ProcesamientoFicheroObjetos 
 * que lee y guarda los datos en ficheros binarios usando una interfaz serializable
 * define los métodos 
 * -leerFichero 
 * -guardarFichero 
 * 
 *
 */
public class ProcesamientoFicheroObjetos extends ProcesamientoFichero{

	/** 
	 * 	método leerFichero, se usa para leer los datos de un fichero y devolver una lista con los objetos leídos
	 *   la ruta donde se encuentra el fichero a leer
	 *   devuelve una lista con los objetos Libro que se guardaban en el fichero
	 *  excepciones IOException, ClassNotFoundException
	 *  		
	 */

	public List<Libro> leerFichero(String ruta) throws IOException, ClassNotFoundException {
		
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		
		FileInputStream fis = new FileInputStream(ruta);
		ObjectInputStream ois = new ObjectInputStream(fis);

		// leemos el fichero como un todo
		try
		{
		
			while (true) { 	
				listaLibros.add((Libro) ois.readObject());
			}
		}catch(EOFException e){
			// cuando da error de lectura de fin de fichero, salir
			ois.close();
			return listaLibros;
		}
	
	}//leerFichero
	
	/**
	 * 
	 * 	método guardarFichero, guarda los datos que se le pasan por parámetro en una lista de objetos Libro, 
	 * 			en el fichero del que tambien se le pasan los datos de la ruta donde se encuentra
	 *  parametros 
	 *  	la lista con los objetos Libro que se guardarán en el fichero
	 *  	la ruta del fichero donde se van a guardar los datos
	 *  devuelve IOException
	 *  		
	 */
	public void guardarFichero(List<Libro> listaLibros, String ruta) throws IOException {
		
		// se abre  un fichero para escribir en él
		FileOutputStream fos = new FileOutputStream(ruta);                                                 
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(Libro l : listaLibros) {
	    	oos.writeObject(l);
		}	
	    	oos.close();
	} // guardarFichero


	

}

	
