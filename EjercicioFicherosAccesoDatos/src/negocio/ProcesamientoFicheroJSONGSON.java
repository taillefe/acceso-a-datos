package negocio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
import modelo.LocalDateAdapterGSON;

/**
 * 
 * @author laura
 * clase ProcesamientoFicheroJSONGSON formato de texto que representa los objetos
 * en forma de pares clave: valor, separados por comas y cada objeto va entre llaves.
 * la colecciones entre corchetes.
 * define los métodos 
 * -leerFichero 
 * -guardarFichero 
 *
 */
public class ProcesamientoFicheroJSONGSON extends ProcesamientoFichero {

	/** 
	 * 	método leerFichero, se usa para leer los datos de un fichero y devolver una lista con los objetos leídos
	 *  parámetros ruta donde se encuentra el fichero a leer
	 *  devuelve una lista con los objetos Libro que se guardaban en el fichero
	 *  excepciones 
	 *  	IOException, ClassNotFoundException, ParserConfigurationException, SAXException, JAXBException, TransformerException 
	 *  		
	 */
	@Override
	public List<Libro> leerFichero(String ruta) throws IOException, ClassNotFoundException,
			ParserConfigurationException, SAXException, JAXBException, TransformerException {
		
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		
		//  excludeFieldsWithoutExposeAnnotation solo importa los datos que tienen @Expose, puede interesar no exportar o importar algunos datos
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().
				registerTypeAdapter(LocalDate.class, new LocalDateAdapterGSON()).create(); 
				
		FileReader fr = new FileReader(ruta);
		LibroGSON[] libros = gson.fromJson(fr, LibroGSON[].class);
		
		//debo mapear libroGSON en libro para devolverlo en ese tipo
		// en este caso he creado un nuevo objeto map para llamar al método, aunque al 
		// hacer static el método se podría haber llamado directamente con el método
		MapeadorLibrosGSON map = new MapeadorLibrosGSON();
	
		listaLibros = (ArrayList<Libro>)map.mapearLibroGSONALibro(Arrays.asList(libros));
		
		return listaLibros;
	}


	/**
	 * 
	 * 	método guardarFichero, guarda los datos que se le pasan por parámetro en una lista de objetos Libro, 
	 * 			en el fichero del que tambien se le pasan los datos de la ruta donde se encuentra
	 *  parametros
	 *  	la lista con los objetos Libro que se guardarán en el fichero
	 *  	la ruta del fichero donde se van a guardar los datos
	 *  excepciones IOException, ParserConfigurationException, TransformerException, JAXBException
	 *  		
	 */
	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException, JAXBException {
		
		ArrayList<LibroGSON> listaLibrosGSON = new ArrayList<LibroGSON>();
		
		// solo exporta los datos que tienen @Expose, puede interesar no exportar o importar algunos datos
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().
				registerTypeAdapter(LocalDate.class, new LocalDateAdapterGSON()).create();
		
		// hay que mapear los datos de listaLibros en listaLibrosGSON (de la clase LibroGSON)
		// se puede hacer directamente sin definir un nuevo objeto porque el metodo de la clase es static
		listaLibrosGSON = (ArrayList<LibroGSON>) MapeadorLibrosGSON.mapearLibroALibroGSON(listaLibros);
				
		String json = gson.toJson(listaLibrosGSON);
				
		//escribir en el fichero el String json, todas las excepciones se controlan en el main
		FileWriter fw = new FileWriter(ruta);
		fw.write(json);
		fw.flush();
		fw.close();
	
	}

}
