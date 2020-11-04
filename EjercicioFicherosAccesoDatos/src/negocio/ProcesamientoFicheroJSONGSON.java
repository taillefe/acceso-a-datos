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


public class ProcesamientoFicheroJSONGSON extends ProcesamientoFichero {

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
	//	System.out.println ("fecha : "+ Arrays.asList(libros));
		listaLibros = (ArrayList<Libro>)util.mapearlibroGSONALibro(Arrays.asList(libros));
		
		return listaLibros;
	}


	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException, JAXBException {
		
		ArrayList<LibroGSON> listaLibrosGSON = new ArrayList<LibroGSON>();
		
		// solo exporta los datos que tienen @Expose, puede interesar no exportar o importar algunos datos
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		
	
		// hay que mapear los datos de listaLibros en listaLibrosGSON (de la clase LibroGSON)
		listaLibrosGSON = (ArrayList<LibroGSON>) Utilidades.mapearlibroALibroGSON(listaLibros);
		System.out.println ("fecha : "+ listaLibrosGSON);
		
		String json = gson.toJson(listaLibrosGSON);
		System.out.println ("String : "+ json);
		
		//escribir en el fichero el String json
		FileWriter fw = new FileWriter(ruta);
		fw.write(json);
		fw.flush();
		fw.close();
	
	}

}
