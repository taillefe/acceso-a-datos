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

public class ProcesamientoFicheroObjetos extends ProcesamientoFichero{
	
	
	public void guardarFichero(List<Libro> listaLibros, String ruta) throws IOException {
		
		// se abre  un fichero para escribir en él
		FileOutputStream fos = new FileOutputStream(ruta);                                                 
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(Libro l : listaLibros) {
	    
	    	oos.writeObject(l);
	    	System.out.println("escribir libros : " + l);
	    	
		}	
	    	oos.close();
	} // guardarFichero



	public List<Libro> leerFichero(String ruta) throws IOException, ClassNotFoundException {
		
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		
		FileInputStream fis = new FileInputStream(ruta);
		ObjectInputStream ois = new ObjectInputStream(fis);

		//  de esta forma leemos el fichero como un todo y lo devolvemos en un arraylist
		//	listaLibros = (ArrayList<Libro>) ois.readObject();
		
		try
		{
			//while (fis.available() != 0)	{
			while (true) { 	
				listaLibros.add((Libro) ois.readObject());
				System.out.println("leer lista : " + listaLibros);
				
			}
		}catch(EOFException e){
			// cuando da error de lectura de fin de fichero, salir
			ois.close();
			return listaLibros;
		}
	
	}

}

	
