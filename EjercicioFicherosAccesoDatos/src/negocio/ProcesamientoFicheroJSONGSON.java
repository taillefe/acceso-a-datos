package negocio;

import java.io.FileReader;
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

		// solo importa los datos que tienen @Expose, puede interesar no exportar o importar algunos datos
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
		FileReader fr = new FileReader(ruta);
		LibroGSON[] libros = gson.fromJson(fr, LibroGSON[].class);
		
		//debo mapear libroGSON en libro para devolverlo en ese tipo
		
		return new ArrayList<Libro>(Arrays.asList(libros));
	}


	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta)
			throws IOException, ParserConfigurationException, TransformerException, JAXBException {
		
		// solo exporta los datos que tienen @Expose, puede interesar no exportar o importar algunos datos
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		// hay que mapear los datos de listaLibros en listaLibrosGSON (de la clase LibroGSON)
		
		
		String json = gson.toJson(listaLibrosGSON);
		
	}
	

}
