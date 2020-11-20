package Entidades;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Profesores")
public class Profesores {	
	private ArrayList<Profesor> listaProfesores;

	public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}
	
	@XmlElement(name="profesor")
	public ArrayList<Profesor> getListaProfesores() {
		return this.listaProfesores;
	}
}


