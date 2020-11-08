package modelo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * 
 * @author laura
 *clase Libros (lista de libros), se debe definir la lista de libros como una clase
 *para usar en el procesamientos de ficheros XML con JAXB 
 *
 */
@XmlRootElement(name="libros")  // es un indicador que  especifica la clase raiz que se va a convertir a XML . 
public class Libros {
	private ArrayList<Libro> listaLibros;

	@XmlElement(name="libro")  // es un indicador que permite cambiar el nombre del elemento 
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
}
