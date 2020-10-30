package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Libro;
import negocio.IProcesamientoFichero;
import negocio.ProcesamientoFichero;
import negocio.ProcesamientoFicheroPlano;
import negocio.ProcesamientoFicheroSAX;
import negocio.ProcesamientoFicheroObjetos;
import negocio.ProcesamientoFicheroXMLDOM;
public class EjercicioLibros {

	public static void main(String[] args)  {
	
		List<Libro> listadoLibrosPlano = null;
		List<Libro> listadoLibrosObjeto = null;
		List<Libro> listadoLibrosXMLDOM = null;
		List<Libro> listadoLibrosSAX = null;
	//	ProcesamientoFichero proc= new ProcesamientoFichero();
		IProcesamientoFichero procPlano= new ProcesamientoFicheroPlano();
		IProcesamientoFichero procObjetos= new ProcesamientoFicheroObjetos();
		IProcesamientoFichero procXMLDOM= new ProcesamientoFicheroXMLDOM();
		IProcesamientoFichero procSAX= new ProcesamientoFicheroSAX();
	//	if (procPlano.existeFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libros.txt"))
//		{
			try {
		//	 		listadoLibrosPlano =  procPlano.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libros.txt");
			//		procPlano.guardarFichero(listadoLibrosPlano,"C:\\Users\\PC33\\Desktop\\Prueba\\libros2.txt");
			//		procObjetos.guardarFichero(listadoLibrosPlano,"C:\\Users\\PC33\\Desktop\\Prueba\\librosobj.txt");
			//		listadoLibrosObjeto =  procObjetos.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\librosobj.txt");
			//		procXMLDOM.guardarFichero(listadoLibrosPlano,"C:\\Users\\PC33\\Desktop\\Prueba\\libroxmldom.txt");
			//		listadoLibrosXMLDOM =  procXMLDOM.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libroxmldom.txt");
				listadoLibrosSAX =  procSAX.leerFichero("C:\\Users\\PC33\\Desktop\\Prueba\\libroxmldom.txt");
					
				//	System.out.println ("listadoLibrosObjeto : " +listadoLibrosObjeto);
					System.out.println("listadoLibrosSAX : "+ listadoLibrosXMLDOM);
				}catch (IOException e) {
					
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		//		} catch (TransformerException e) {
					// TODO Auto-generated catch block
			//		e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
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
