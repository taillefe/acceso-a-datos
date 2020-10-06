package acceso2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class UtilManejoFicheros {
	

	//metodo para crear directorio crearDirectorio()
	
	// metodo para comprobar que el archivo exista existeFichero()
	
	// metodo para crear ficheros  crearFichero()

	// metodo para copiar texto de un fichero en otro copiarFichero()
	

	
	//metodo para crear directorio crearDirectorio()	
	
	public static void crearDirectorio(String nombre) {
		File f1 = new File (nombre);
		if (!f1.exists()) {
			f1.mkdir();
		}
		else {
			System.out.println("El directorio "+ nombre + " ya existe");
		}
	}
	
	
	// metodo para comprobar que el archivo exista existeFichero(ruta, nombre)
	// devuelve verdadero o falso
	
	public static boolean existeFichero(String nombre) {
		
		File f1 = new File (nombre);
		if (!f1.exists()) {
			
			System.out.println ("El fichero " + nombre + " no existe");
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	// metodo para crear ficheros  crearFichero()
	
	public static void crearFichero(String nombre) throws IOException {
	
		File f = new File (nombre);
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
	
	// metodo para copiar ficheros con el codigo escogido
		
	public static void copiarFichero (String f1, String f2, String cod) throws IOException	{
		
	
		// en este caso no hace falta cerrar la conexión porque solo 
		//está abierta la conexion en el try
		//Se abre el fichero1 para lectura
		
		String cadena = "";
		
		FileInputStream fis = new FileInputStream(f1);
			try (
				
					InputStreamReader fr1 = new InputStreamReader(fis,StandardCharsets.UTF_8);
					//	BufferedReader br= new BufferedReader(fr1);
			){
		
	//	try (FileReader fr1 = new FileReader(f1)){  

			int c;
			String str="";
		//	while ((str = br.readLine()) != null ) {
		//		cadena = cadena + str;
		
			while ((c = fr1.read()) != -1 ) {
					cadena = cadena + (char)c;
			
			System.out.println("cadena : "+ cadena);
		
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		
		
		// abro fichero2 para escribir para copiar el texto de fichero1
		FileWriter fw2;

		try
		{

			//fw2 = new FileWriter(f2);  si no usamos la codificacion
			FileOutputStream fos=new FileOutputStream(f2);
	//	OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1); codificacion fija
			OutputStreamWriter osw = new OutputStreamWriter(fos, cod);
			
			
			
			
			
			
			osw.write(cadena);

			osw.close();
		}catch(
		FileNotFoundException ex2)
		{
			System.out.printf("No se ha encontrado el fichero:\n%s", ex2.getMessage());

		}
	
		
		
		
	} 

}
