package negocio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.Libro;
import modelo.LibroGSON;

/**
 * 
 * @author laura
 * clase ProcesamientoFicheroJSONGSON que hereda de ProcesamientoFichero
 * define los métodos 
 * -leerFichero 
 * -guardarFichero 
 *
 */
public class ProcesamientoFicheroJSONGSON extends ProcesamientoFichero {

	/** 
	 * 	método leerFichero, se usa para leer los datos de un fichero y devolver una lista con los objetos leídos
	 *  @param la ruta donde se encuentra el fichero a leer
	 *  @return devuelve una lista con los objetos Libro que se guardaban en el fichero
	 *  @throws IOException, ClassNotFoundException,
			ParserConfigurationException, SAXException, JAXBException, TransformerException 
	 *  		
	 */
	@Override
	public List<Libro> leerFichero(String ruta) throws IOException, ClassNotFoundException,
			ParserConfigurationException, SAXException, JAXBException, TransformerException {
		
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		// solo importa los datos que tienen @Expose, puede interesar no exportar o importar algunos datos
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
		FileReader fr = new FileReader(ruta);
		LibroGSON[] libros = gson.fromJson(fr, LibroGSON[].class);
		
		//debo mapear libroGSON en libro para devolverlo en ese tipo
		Utilidades util = new Utilidades();
	
		listaLibros = (ArrayList<Libro>)util.mapearlibroGSONALibro(Arrays.asList(libros));
		
		return listaLibros;
	}


	/**
	 * 
	 * 	método guardarFichero, guarda los datos que se le pasan por parámetro en una lista de objetos Libro, 
	 * 			en el fichero del que tambien se le pasan los datos de la ruta donde se encuentra
	 *  @param 
	 *  	la lista con los objetos Libro que se guardarán en el fichero
	 *  	la ruta del fichero donde se van a guardar los datos
	 *  @return void
	 *  @throws IOException, ParserConfigurationException, TransformerException, JAXBException
	 *  		
	 */
	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException, JAXBException {
		
		ArrayList<LibroGSON> listaLibrosGSON = new ArrayList<LibroGSON>();
		
		// solo exporta los datos que tienen @Expose, puede interesar no exportar o importar algunos datos
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		
	
		// hay que mapear los datos de listaLibros en listaLibrosGSON (de la clase LibroGSON)
		listaLibrosGSON = (ArrayList<LibroGSON>) Utilidades.mapearlibroALibroGSON(listaLibros);
				
		String json = gson.toJson(listaLibrosGSON);
				
		//escribir en el fichero el String json
		FileWriter fw = new FileWriter(ruta);
		fw.write(json);
		fw.flush();
		fw.close();
	
	}

}
