package negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;
import modelo.Personaje;

public class ProcesamientoFicheroPlano extends ProcesamientoFichero{
	
	public  List<Libro> leerFichero(String ruta) throws IOException 	{
	
		String cadena = "";
		ArrayList<Libro> listaLibros;
		List<Personaje> listaPersonajes;
		String[] arrayLibros = null;
		
		
		FileReader fr;
		
		//variable locales para guardar los campos del objeto libro y personaje
		String titulo;
		String editorial;
		String autor;
		LocalDate fecha;
		String genero;
	
		String nombre;
		Personaje.TipoImportancia importancia;
		
		int i = 0;
		try {

			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader (fr);
			int c;
			// creamos un objeto libro y uno personaje, para introducir los valore en los arrayList correspondientes
			Libro libro = new Libro();
			Personaje personaje = new Personaje();
			
			while ((cadena = bfr.readLine()) != null ) {
				
				System.out.println("cadena : "+ cadena);
				
				arrayLibros[i] = cadena; // cada fila es un libro que se introduce en una posicion del array
				
				// introducir esos datos en un objeto Libro y en un objeto Personaje
				// recorrer los datos del libro para guardarlos en sus variable
				String partesLibro[] = cadena.split(";");
				
				// recorremos todo el array de partes del libro
				
					titulo = partesLibro[0];
					editorial = partesLibro[1];
					autor = partesLibro[2];
					fecha = LocalDate.parse(partesLibro[3], DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
					genero = partesLibro[4];
					
					
				String personajes[] = partesLibro[5].split("-");
				
				//recorremos todo el array de partes del personaje
				for (int cont = 0; cont < personajes.length; cont++) {
					
					nombre = personajes[0];
					importancia = personajes[1];
					
				
				//usamos el objeto personaje para introducir los datos en el array list de personajes
					 listaPersonajes[cont] = new Personaje (nombre,importancia);
				}	
				
				i++; // actualizar la variable que indica la posicion del libro dentro del array
					 
		}	fr.close();

		}catch(FileNotFoundException ex)
		{
			System.out.printf("\nHa ocurrido un error. No se ha encontrado el fichero:\n%s",ex.getMessage());
			
		}
	
		
		
		
		return null;

	}//leerFichero

	
	public   void guardarFichero( List<Libro> listaLibros, String ruta) {
		
	}


}
