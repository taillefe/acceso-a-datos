package modelo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="libros")

/**
 * 
 * @author laura
 *clase Libros (lista de libros), se debe definir la lista de libros como una clase
 *para usar en el procesamientos de ficheros XML con JAXB 
 *
 */
public class Libros {
	private ArrayList<Libro> listaLibros;

	@XmlElement(name="libro")
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	

	
	
	

}
