package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Entidades.Asignatura;
import Entidades.Profesor;

public class ProcesamientoFichero implements IProcesamiento {

	@Override
	public ArrayList<Asignatura> leerAsignaturas(String ruta) {
		//No implementar nada
		return null;
	}

	@Override
	public void guardarAsignaturas(String ruta,ArrayList<Asignatura> asignaturas) throws IOException {
		// TODO Guardar seg�n lo indicado en el apartado 1 del ex�men
		String datos="";
		for(Asignatura a:asignaturas) {
			datos= datos + "\n" + a.toString(); 
		}
		UtilFichero.escribirBinario(datos, ruta);
	}

	@Override
	public void guardarProfesores(ArrayList<Profesor> profesores,String ruta) throws IOException {
		// TODO Guardar seg�n el apartado 2 del ex�men
		UtilFichero.escribirProfesores(profesores, ruta);
	}

	@Override
	public void imprimirAsignaturas(String ruta) throws IOException {
		// TODO Leer e imprimir seg�n lo indicado en el apartado 1 del ex�men
		String datos= UtilFichero.leerTexto(ruta);
		System.out.println("Datos leidos en texto: \n" +datos);
	}

	
}
