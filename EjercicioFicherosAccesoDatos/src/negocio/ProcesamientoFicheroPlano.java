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
	
	
	
	public static  List<Libro> leerFichero(String ruta)  	{
	
		String cadena = "";
		ArrayList<Libro> listaLibros = new ArrayList();
		List<Personaje> listaPersonajes = new ArrayList();;
		String[] arrayLibros = null;
		
		
		FileReader fr;
		
		//variable locales para guardar los campos del objeto libro y personaje
		String titulo;
		String editorial;
		String autor;
		LocalDate fecha;
		String genero;
	
		String nombre;
		String importanciaString;
		
		int i = 0;
		try {

			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader (fr);
			int c;
			// creamos un objeto libro y uno personaje, para introducir los valore en los arrayList correspondientes
			Libro libro = new Libro();
			Personaje personaje = new Personaje();
			
			while ((cadena = bfr.readLine()) != null ) {
				
				
				
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
				
				//recorremos todo el array de personajes
				for (int cont = 0; cont < personajes.length; cont++) {
					//cada parte del array contiene un personaje, vamos a dividirlos en nombre e importancia
					
					String partePersonaje[] = personajes[cont].split(",");
					
					nombre = partePersonaje[0];
					importanciaString = partePersonaje[1];
					
				
				//usamos el objeto personaje para introducir los datos en el array list de personajes
					
					 Personaje.TipoImportancia importancia =Personaje.TipoImportancia.valueOf(importanciaString.toUpperCase());
					 listaPersonajes.add(cont,new Personaje(nombre,importancia));
				}
				
				// usamos el objeto libro para introducir los datos en el arrayList de listaLibros
				listaLibros.add(i, new Libro(titulo,editorial, autor,fecha, genero, listaPersonajes));
				
				i++; // actualizar la variable que indica la posicion del libro dentro del array
					 
		}	fr.close();

		}catch(FileNotFoundException ex)
		{
			System.out.printf("\nHa ocurrido un error. No se ha encontrado el fichero:\n%s",ex.getMessage());
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
		
		
		return listaLibros;

	}//leerFichero

	
	public   void guardarFichero( List<Libro> listaLibros, String ruta) {
		
	}


}
