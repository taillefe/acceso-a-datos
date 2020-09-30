package acceso2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {

	String path = "C:\\Users\\PC33\\Desktop\\Prueba\\ejercicio1.txt";
	String cadena = " ";
	
	// creo fichero
	
	
		File f1 = new File (path);
	
		
			if(!f1.exists())
			{
				if (!f1.createNewFile()) {
					System.out.println("No se ha podido crear el fichro ejercicio1.txt");
				}
			}
			else
			{
				System.out.println("El fichero ejercicio1.txt ya extiste");
			}

	
	
	
	// abro fichero para escribir
	FileWriter fw;

	try
	{

		fw = new FileWriter(path);
		cadena = "archivo a copiar";
		
		fw.write(cadena);
		fw.flush();
		fw.close();
	}catch(
	FileNotFoundException ex1)
	{
		System.out.printf("\n Ha ocurrido un eror. No se ha encontrado el fichero:\n%s", ex1.getMessage());

	}

	
	// creo un segundo fichero

	String path2 = "C:\\Users\\PC33\\Desktop\\Prueba\\ejercicio2.txt";
	File f2 = new File(path2);

	if(!f2.exists())
	{
		if (!f2.createNewFile()) {
			System.out.println("No se ha podido crear el fichro ejercicio2.txt");
		}
	}else
	{
		System.out.println("El fichero ejercicio2.txt ya extiste");
	}

	// abro fichero para leer
	FileReader fr = null;try
	{

		fr = new FileReader(path);

		
		int c;
		cadena = "";
		while ((c = fr.read()) != -1 ) {
			
			
			cadena = cadena + (char)c;
			System.out.println("cadena : "+ cadena);
						
		}

	}catch(Exception ex)
	{
		ex.printStackTrace();
	}finally
	{
		fr.close();
	}

	// abro fichero2 para copiar el texto de fichero1
	FileWriter fw2;

	try
	{

		fw2 = new FileWriter(path2);
		fw2.write(cadena);

		fw2.flush();
		fw2.close();
	}catch(
	FileNotFoundException ex2)
	{
		System.out.printf("No se ha encontrado el fichero:\n%s", ex2.getMessage());

	}

	}
}
