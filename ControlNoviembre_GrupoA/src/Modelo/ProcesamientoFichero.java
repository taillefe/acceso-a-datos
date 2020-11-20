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
		// TODO Guardar según lo indicado en el apartado 1 del exámen
		String datos="";
		for(Asignatura a:asignaturas) {
			datos= datos + "\n" + a.toString(); 
		}
		UtilFichero.escribirBinario(datos, ruta);
	}

	@Override
	public void guardarProfesores(ArrayList<Profesor> profesores,String ruta) throws IOException {
		// TODO Guardar según el apartado 2 del exámen
		UtilFichero.escribirProfesores(profesores, ruta);
	}

	@Override
	public void imprimirAsignaturas(String ruta) throws IOException {
		// TODO Leer e imprimir según lo indicado en el apartado 1 del exámen
		String datos= UtilFichero.leerTexto(ruta);
		System.out.println("Datos leidos en texto: \n" +datos);
	}

	
}
