package persona;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class PersonaMapping{
	
	
	// crear metodo de guardar y otro leer
	
	public static void guardarListado( ArrayList<Persona> listaP ) throws IOException {
		
		// se abre  un fichero para escribir en él
		FileOutputStream fos = new FileOutputStream("C:\\Users\\PC33\\Desktop\\Prueba\\persona.txt");                                                 
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(Persona p : listaP) {
	    
	    	oos.writeObject(p);
	    	System.out.println("escribir personas : " + p);
	    	
		}	
	    	oos.close();
	} // guardarListado
	
	public static ArrayList<Persona> leerListado() throws IOException, ClassNotFoundException{
		
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\PC33\\Desktop\\Prueba\\persona.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		//  de esta forma leemos el fichero como un todo y lo devolvemos en un arraylist
		// solo devuelve el primer valor si lo hemos escrito objeto a objeto
		//listaPersonas = (ArrayList<Persona>) ois.readObject();
		
		try {
			//while (fis.available() != 0)	{
			while (true) { 	
				listaPersonas.add((Persona) ois.readObject());
				System.out.println("leer lista : " + listaPersonas);
				
			}
		}
		catch(EOFException e){
			// cuando da error de lectura de fin de fichero, salir
			ois.close();
			return listaPersonas;
		}
		
		// esto lo necesitamos cuando usamos el método fis.available()
		//ois.close();
	
		//return listaPersonas;
		
		 // tiene que devolver el array list de objetos persona		
	} // leerListado
	
}
