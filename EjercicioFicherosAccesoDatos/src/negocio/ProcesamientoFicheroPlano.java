package negocio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Libro;
import modelo.Personaje;

public class ProcesamientoFicheroPlano extends ProcesamientoFichero{
	
	
	
	public List<Libro> leerFichero(String ruta) throws IOException   	{
	
		String cadena = "";
		ArrayList<Libro> listaLibros = new ArrayList();
		ArrayList<Personaje> listaPersonajes = new ArrayList();;
		
		FileReader fr;
		
		//variable locales para guardar los campos del objeto libro y personaje
		String titulo;
		String editorial;
		String autor;
	
		LocalDate fecha;
		String genero;
	
		String nombre;
		String importanciaString;

	
		
			fr = new FileReader(ruta);
			BufferedReader bfr = new BufferedReader (fr);
			int c;
			// creamos un objeto libro y uno personaje, para introducir los valore en los arrayList correspondientes
			Libro libro = new Libro();
			Personaje personaje = new Personaje();
			
			while ((cadena = bfr.readLine()) != null ) {
				
				// introducir esos datos en un objeto Libro y en un objeto Personaje
				// recorrer los datos del libro para guardarlos en sus variable
				String partesLibro[] = cadena.split(";");
				
				// recorremos todo el array de partes del libro
				
					titulo = partesLibro[0];
					editorial = partesLibro[1];
					autor = partesLibro[2];
			
					fecha = LocalDate.parse(partesLibro[3], DateTimeFormatter.ofPattern("d/M/yyyy")); 
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
					
				
					 Personaje per = new Personaje(nombre, importancia);
					 
					 listaPersonajes.add(cont,per);
			
				}
				
				// usamos el objeto libro para introducir los datos en el arrayList de listaLibros
				listaLibros.add(new Libro(titulo,editorial, autor,fecha, genero, listaPersonajes));
				
				// inicializamos listaPersonajes
				listaPersonajes = new ArrayList();
			}		 
	
		fr.close();
		return listaLibros;

	}//leerFichero

	
	public   void guardarFichero( List<Libro> listaLibros, String ruta) throws IOException {
		
		
		ArrayList<Personaje> listaPersonajes = new ArrayList();;

		//variable locales para recoger los campos del objeto libro y personaje
		String titulo;
		String editorial;
		String autor;
	
		LocalDate fecha;
		String genero;
	
		String nombre;
		Personaje.TipoImportancia importanciaString;
		String personajes = null;
		String libros = null;

		FileWriter fw = new FileWriter(ruta);
		BufferedWriter bfw = new BufferedWriter (fw);
		
		for(Libro l : listaLibros) {
	
			// obtener los datos del objeto Libro
			
			titulo = l.getTitulo();
			editorial = l.getEditorial();
			autor = l.getAutor();
			fecha = l.getFecha();
			genero = l.getGenero();
			listaPersonajes = (ArrayList<Personaje>) l.getPersonajes();
			
			//recorremos todo el arrayList de personajes
			for (Personaje p : listaPersonajes) {
				//cada parte del array contiene un personaje, vamos a dividirlos en nombre e importancia
			
				nombre = p.getNombre();
				importanciaString = p.getImportancia();
				// crear la cadena de personajes
				personajes = personajes + "-" + nombre + "," + importanciaString;
			}
			libros = titulo + ";" +editorial +";" + autor +";" +fecha.format(DateTimeFormatter.ofPattern("d/M/yyyy")) +";"+genero +";"+ personajes;
			 bfw.write(libros + "\n");
			 personajes = "";
			 libros = "";
		    	
		}	
	    bfw.close();
	
	}//guardarFichero


}
