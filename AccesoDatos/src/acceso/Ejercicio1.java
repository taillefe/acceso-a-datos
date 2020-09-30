package acceso;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		
		
		String ruta = "C:\\Users\\PC33\\Desktop\\Prueba";
		
		// crear fichero Directorio1/fichero1.txt
		
		crearDirectorio(ruta,"Directorio1");
		crearDirectorio(ruta,"Directorio2");
		
		String ruta2 = "C:\\Users\\PC33\\Desktop\\Prueba\\Directorio1";
		crearFichero(ruta2,"fichero1.txt");
		crearFichero(ruta2,"fichero2.txt");
		
		String ruta3 = "C:\\Users\\PC33\\Desktop\\Prueba\\Directorio2";
		crearFichero(ruta3,"fichero1.txt");


		try {
			crearFichero (ruta,"fichero3.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				
	}
	
	public static void crearDirectorio(String ruta, String nombre) {
		File f1 = new File (ruta,nombre);
		if (!f1.exists()) {
			f1.mkdir();
		}
		else {
			System.out.println("El directorio "+ nombre + " ya extiste");
		}
	}
	
	public static void crearFichero(String ruta, String nombre) throws IOException {
		File f1 = new File (ruta,nombre);
		if (!f1.exists()) {
			if (!f1.createNewFile())
			{
				System.out.println ("No se ha podido crear el fichro " + nombre);
			}
		}
		else {
			System.out.println("El fichero " + nombre + " ya extiste");
		}
		
		File[] fichero;
		//para listar el fichero
		File fich1 = new File (ruta);
		fichero = fich1.listFiles();
		
		for (File path:fichero) {
			System.out.println(path);
		}
		
		
		
		
		// en este caso hay que cerrar la conexión con close()
		FileReader fr = null;
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
		
		// en este caso no hace falta cerrar la conexión porque solo 
		//está abierta la conexion en el try 
		try (FileReader fr1 = new FileReader(f1)){
			fr1.read();
		}
		catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
