package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Libro;
import negocio.IProcesamientoFichero;
import negocio.ProcesamientoFichero;
import negocio.ProcesamientoFicheroPlano;
import negocio.ProcesamientoFicheroObjetos;
public class EjercicioLibros {

	public static void main(String[] args) {
	
		List<Libro> listadoLibrosPlano = null;
		List<Libro> listadoLibrosObjeto = null;
	//	ProcesamientoFichero proc= new ProcesamientoFichero();
		IProcesamientoFichero procPlano= new ProcesamientoFicheroPlano();
		IProcesamientoFichero procObjetos= new ProcesamientoFicheroObjetos();
		
	//	if (procPlano.existeFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libros.txt"))
//		{
			try {
					listadoLibrosPlano =  procPlano.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libros.txt");
					procPlano.guardarFichero(listadoLibrosPlano,"C:\\Users\\PC33\\Desktop\\Prueba\\libros2.txt");
					procObjetos.guardarFichero(listadoLibrosPlano,"C:\\Users\\PC33\\Desktop\\Prueba\\librosobj.txt");
					listadoLibrosObjeto =  procObjetos.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\librosobj.txt");
					
					
					
					System.out.println ("listadoLibrosObjeto : " +listadoLibrosObjeto);
					System.out.println("listadoLibrosPlano : "+ listadoLibrosPlano);
				}catch (ClassNotFoundException ex) {
					
					ex.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		
//		}
/*		else
		{
			System.out.println("El fichero " + "libros.txt" + "no existe");
		}
*/

	}

}
