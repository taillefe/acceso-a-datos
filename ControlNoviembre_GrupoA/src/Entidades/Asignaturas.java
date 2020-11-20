package Entidades;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="listaAsignaturas")
public class Asignaturas {	
	private ArrayList<Asignatura> listaAsignaturas;

	public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}
	
	@XmlElement(name="asignatura")
	public ArrayList<Asignatura> getListaAsignaturas() {
		return this.listaAsignaturas;
	}
}


