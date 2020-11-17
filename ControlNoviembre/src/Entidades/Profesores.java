package Entidades;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="profesores")
/**
 * 
 * @authorlaura
 *
 */
public class Profesores {


	private ArrayList<Profesor> listaProfesores;

	@XmlElement(name="profesor")
	public ArrayList<Profesor> getListaLibros() {
		return listaProfesores;
	}

	public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

}
