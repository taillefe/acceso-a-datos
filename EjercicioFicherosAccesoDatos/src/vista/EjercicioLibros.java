package vista;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Libro;
import negocio.IProcesamientoFichero;
import negocio.ProcesamientoFicheroPlano;

public class EjercicioLibros {

	public static void main(String[] args) {
		
		
		
		
		ArrayList<Libro> listadoLibros = null;
		IProcesamientoFichero proc= new ProcesamientoFicheroPlano();
		
	//	try {
			listadoLibros = (ArrayList<Libro>) proc.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libros.txt");
	//	} catch (IOException e) {
			
	//		e.printStackTrace();
	//	}
		
		System.out.println("cadena : "+ listadoLibros);

	}

}
