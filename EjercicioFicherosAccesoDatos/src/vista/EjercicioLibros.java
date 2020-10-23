package vista;

import java.util.ArrayList;

import modelo.Libro;
import negocio.ProcesamientoFicheroPlano;

public class EjercicioLibros {

	public static void main(String[] args) {
		
		ArrayList<Libro> listadoLibros;
		
		listadoLibros = (ArrayList<Libro>) ProcesamientoFicheroPlano.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libros.txt");
		
		System.out.println("cadena : "+ listadoLibros);
		
		

	}

}
