package negocio;

import java.io.File;
import java.io.IOException;

public abstract class ProcesamientoFichero implements IProcesamientoFichero {
	
	
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

}
