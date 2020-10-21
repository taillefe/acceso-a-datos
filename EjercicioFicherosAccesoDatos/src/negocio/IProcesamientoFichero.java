package negocio;
import java.io.IOException;
import java.util.List;

import modelo.Libro;


public interface IProcesamientoFichero {
	
	public  List<Libro> leerFichero(String ruta) throws IOException;

	
	public   void guardarFichero( List<Libro> listaLibros, String ruta);


}
