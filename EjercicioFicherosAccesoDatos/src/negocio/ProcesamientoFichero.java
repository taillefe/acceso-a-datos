package negocio;

import java.io.File;
import java.io.IOException;


/**
 * 
 * @author laura
 * clase abstracta que implementa la interface IProcesamientoFichero
 * defilne los métodos existeFichero, borrarFichero y crearFichero
 *
 */

public abstract class ProcesamientoFichero implements IProcesamientoFichero {
	
	/**
	 * método existeFichero
	 * @param ruta del fichero
	 * @return true o false
	 */
	public boolean existeFichero (String ruta) {
	
		File f1 = new File (ruta);
		if (!f1.exists()) {
			
			System.out.println ("El fichero " + ruta + " no existe");
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	/**
	 * borrarFichero
	 * @param ruta del fichero
	 * @return true o false
	 */
	public boolean borrarFichero (String ruta) {
		File f = new File (ruta);
		if (f.exists()) {
			if (f.delete())
			{
				System.out.println ("El fichero " + ruta + " ha sido borrado");
				return true;
				
			}else {
				System.out.println("El fichero " + ruta +" no puede ser borrado");
				return false;
			}
				
		}
		else {
			System.out.println("El fichero " + ruta + " no existe");
			return false;
		} 
		
	}
	
	/**
	 * crearFichero
	 * @param nombre del fichero
	 * @return true o false
	 * @throws IOException
	 */
	public boolean crearFichero(String nombre) throws IOException  {
		
		File f = new File (nombre);
		if (!f.exists()) {
			if (!f.createNewFile()	)
			{
				System.out.println ("No se ha podido crear el fichero " + nombre);
				return false;
			}else
				return true;
		}
		else {
			System.out.println("El fichero " + nombre + " ya existe");
			return false;
		}
		
	}

}
