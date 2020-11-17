package Modelo;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import Entidades.Asignatura;
import Entidades.Profesor;


/**
 * 
 * @author laura
 *
 */
public class ProcesamientoFichero implements IProcesamiento {

	@Override
	/**
	 * leerAsignaturas
	 */
	public ArrayList<Asignatura> leerAsignaturas(String ruta) {
		//No implementar nada
		return null;
	}

	@Override
	/**
	 * guardarAsignaturas
	 */
	public void guardarAsignaturas(String ruta,ArrayList<Asignatura> asignaturas) throws IOException {
		// TODO Guardar según lo indicado en el apartado 1 del exámen
		
		try {
			// se abre  un fichero para escribir en él
			FileOutputStream fos = new FileOutputStream(ruta);     
			BufferedOutputStream dos = new BufferedOutputStream(fos);
			
		//	FileOutputStream fos = new FileOutputStream(ruta);                                                 
		  //  ObjectOutputStream oos = new ObjectOutputStream(fos);
			String listaAsignaturasString = asignaturas.toString();
		//	for(Asignatura a : asignaturas) {
		    
		//    	dos.write((listaAsignaturasString));
		    	System.out.println("escribir asignaturas : " + listaAsignaturasString);
		    	
			//}	
		    	dos.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	

	@Override
	/**
	 * guardarProfesores
	 */
	public void guardarProfesores(ArrayList<Profesor> profesores,String ruta) throws IOException {
		// TODO Guardar según el apartado 2 del exámen
		
		// se abre  un fichero para escribir en él
		FileOutputStream fos = new FileOutputStream(ruta);                                                 
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for(Profesor p : profesores) {
			    
		    	oos.writeObject(p);
		    	System.out.println("escribir profesores : " + p);
			    	
		}	
		oos.close();
		
	}

	@Override
	/**
	 * imprimirAsignaturas
	 */
	public void imprimirAsignaturas(String ruta) throws IOException, ClassNotFoundException {
		// TODO Leer e imprimir según lo indicado en el apartado 1 del exámen
		
		String listadoAsignaturasString = null ;
		// se abre  un fichero para leer
			FileInputStream fis = new FileInputStream(ruta);     
			InputStreamReader isr = new InputStreamReader(fis);
	
		try
		{
		// leer con isr.write();
			listadoAsignaturasString = Integer.toString(isr.read());
			
			
		}catch(EOFException e){
			// cuando da error de lectura de fin de fichero, salir
			isr.close();
		
		}
		System.out.println("leer lista : " + listadoAsignaturasString);
		
	}

	
}
