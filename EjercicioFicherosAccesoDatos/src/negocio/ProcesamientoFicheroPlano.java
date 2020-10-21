package negocio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;

public class ProcesamientoFicheroPlano extends ProcesamientoFichero{
	
	public  List<Libro> leerFichero(String ruta) throws IOException 	{
	
		String cadena = "";
		ArrayList<Libro> listaLibros;
		String[] arrayLibros;
		String[] arrayPersonajes;
		FileReader fr;
		try {

			fr = new FileReader(ruta);
			BufferedReader
			int c;
			
			while ((cadena = fr.readline()) != null ) {
				cadena = fr.readline();
				System.out.println("cadena : "+ cadena);
				arrayLibros = cadena.split(";");
		}

		}catch(FileNotFoundException ex)
		{
			System.out.printf("\nHa ocurrido un error. No se ha encontrado el fichero:\n%s",ex.getMessage());
			
		}
	
		
		
		
		return null;

	}//leerFichero

	
	public   void guardarFichero( List<Libro> listaLibros, String ruta) {
		
	}


}
