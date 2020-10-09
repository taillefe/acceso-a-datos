package persona;

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
	
	public void guardarListado( ArrayList<Persona> p ) throws IOException {
		
		// se abre  un fichero para escribir en él
		FileOutputStream fos = new FileOutputStream(" ");                                                 
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
		
	    
	    	oos.writeObject(p);
		
	}
	
	public ArrayList<Persona> leerListado() throws IOException, ClassNotFoundException{
		
		ArrayList<Persona> listaPersonas;
		
		FileInputStream fis = new FileInputStream(" ");
		ObjectInputStream ois = new ObjectInputStream(fis);

		listaPersonas = (ArrayList<Persona>) ois.readObject();

		ois.close();
	
		
		
		return listaPersonas; // tiene que devolver el array list de objetos persona		
	}
	
}
