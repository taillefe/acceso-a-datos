package negocio;

import java.io.File;
import java.io.IOException;


/**
 * 
 * @author laura
 * clase abstracta que implementa la interface IProcesamientoFichero
 * defilne los m�todos existeFichero, borrarFichero y crearFichero
 *
 */
public abstract class ProcesamientoFichero implements IProcesamientoFichero {
	
	/**
	 * m�todo existeFichero
	 * @param ruta del fichero
	 * @return true o false
	 */
	
	public boolean existeFichero (String ruta) {
	
		File f1 = new File (ruta);
		if (!f1.exists()) {  // si no existe el fichero
			
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
		if (f.exists()) { // si existe el fichero
			if (f.delete()) // si se borra el fichero
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
	 * 
	 * @param nombre del fichero
	 * @return boolean
	 * @throws IOException excepcion
	 */
	public boolean crearFichero(String nombre) throws IOException  {
		
		File f = new File (nombre);
		if (!f.exists()) {  // si no existe el fichero
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
