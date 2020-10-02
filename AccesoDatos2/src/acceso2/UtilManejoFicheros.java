package acceso2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UtilManejoFicheros {
	

	//metodo para crear directorio crearDirectorio()
	
	// metodo para comprobar que el archivo exista existeFichero()
	
	// metodo para crear ficheros  crearFichero()

	// metodo para copiar texto de un fichero en otro copiarFichero()
	

	
	//metodo para crear directorio crearDirectorio()	
	
	public static void crearDirectorio(String ruta, String nombre) {
		File f1 = new File (ruta,nombre);
		if (!f1.exists()) {
			f1.mkdir();
		}
		else {
			System.out.println("El directorio "+ nombre + " ya existe");
		}
	}
	
	
	// metodo para comprobar que el archivo exista existeFichero(ruta, nombre)
	// devuelve verdadero o falso
	
	public static boolean existeFichero(String ruta, String nombre) {
		
		File f1 = new File (ruta,nombre);
		if (!f1.exists()) {
			
			System.out.println ("El fichero " + nombre + "no existe");
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	// metodo para crear ficheros  crearFichero()
	
	public static void crearFichero(String ruta, String nombre) throws IOException {
	
		File f = new File (ruta,nombre);
		if (!f.exists()) {
			if (!f.createNewFile())
			{
				System.out.println ("No se ha podido crear el fichero " + nombre);
			}
		}
		else {
			System.out.println("El fichero " + nombre + " ya existe");
		}
		
	}
	

		
	public static void copiarFichero (File f1, File f2)	{
		
		// en este caso hay que cerrar la conexión con close()
	/*	FileReader fr = null;
		try {
			
			fr = new FileReader(f1);
			fr.read();
		}
		catch ( Exception ex) {
			ex.printStackTrace();
		}
		finally {
			fr.close();
		}
	*/	
		// en este caso no hace falta cerrar la conexión porque solo 
		//está abierta la conexion en el try
		//Se abre el fichero para lectura
		
		String cadena;
		try (FileReader fr1 = new FileReader(f1)){

			int c;
			cadena = "";
			while ((c = fr1.read()) != -1 ) {
				
				
				cadena = cadena + (char)c;
				System.out.println("cadena : "+ cadena);
		
			}
		}
		catch (Exception e) {
				e.printStackTrace();
			}
		
		
	} 

}
