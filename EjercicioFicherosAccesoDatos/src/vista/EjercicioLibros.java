package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modelo.Libro;
import negocio.IProcesamientoFichero;
import negocio.ProcesamientoFichero;
import negocio.ProcesamientoFicheroJSONGSON;
import negocio.ProcesamientoFicheroPlano;
import negocio.ProcesamientoFicheroSAX;
import negocio.ProcesamientoFicheroObjetos;
import negocio.ProcesamientoFicheroXMLDOM;
import negocio.ProcesamientoFicheroXMLJAXB;


/**
 * 
 * @author laura garcia
 * programa que ejecuta los diferentes procesamientos de ficheros
 * Lectura y escritura de ficheros tratados de diferente manera 
 * Fichero plano
 * Fichero binario
 * Fichero XML con DOM
 * Fichero XML con JAXB
 * Fichero JSON GSON
 * FIchero SAX
 *
 */
public class EjercicioLibros {

	
	public static void main(String[] args)  {
	
	// definición de las variables de tipo lista de la clase Libro para cada uno de los procesamientos de ficheros
	// e inicializacion de todas ellas a null
		List<Libro> listadoLibrosPlano = null;
		List<Libro> listadoLibrosObjeto = null;
		List<Libro> listadoLibrosXMLDOM = null;
		List<Libro> listadoLibrosSAX = null;
		List<Libro> listadoLibrosXMLJAXB = null;
		List<Libro> listadoLibrosJSONGSON = null;
		
	// creación de los objetos de tipo IProcesamientoFichero con los que se utiliza el método leerFichero definido
	// en cada una de las clases de procesamiento
	//	ProcesamientoFichero proc= new ProcesamientoFichero();
		IProcesamientoFichero procPlano= new ProcesamientoFicheroPlano();
		IProcesamientoFichero procObjetos= new ProcesamientoFicheroObjetos();
		IProcesamientoFichero procXMLDOM= new ProcesamientoFicheroXMLDOM();
		IProcesamientoFichero procXMLJAXB= new ProcesamientoFicheroXMLJAXB();
		IProcesamientoFichero procSAX= new ProcesamientoFicheroSAX();
		IProcesamientoFichero procJSONGSON= new ProcesamientoFicheroJSONGSON();

		String path ="";
		String path2 = "";
		
		
			try {
		// APARTADO 2 ProcesamientoFicheroPlano, 
		// lee el fichero ejemplo de la lista de libros (libros.txt) devuelve una lista de libros en la variable listadoLibrosPlano
		// y lo guarda de nuevo, con el mismo formato en otro fichero (libros2.txt)
				path = "prueba\\libros.txt";
				path2 = "prueba\\libros2.txt";
				
			 		listadoLibrosPlano =  procPlano.leerFichero(path);
					procPlano.guardarFichero(listadoLibrosPlano,path2);
			 		
		// APARTADO 3 ProcesamientoFicheroObjetos, 
		// guarda la lista de libros obtenida con ProcesamientoFicheroPlano en un fichero binario (librosobj.txt)
		// y lee el fichero binario (librosobj.txt) y devuelve una lista en listadoLibrosObjeto
				
					path = "prueba\\librosobj.txt";
					procObjetos.guardarFichero(listadoLibrosPlano,path);
					listadoLibrosObjeto =  procObjetos.leerFichero(path);
			
		// APARTADO 4 ProcesamientoFicheroXMLDOM, 
		// guarda la lista de libros obtenida con ProcesamientoFicheroPlano en un fichero XML (libroxmldom.txt)
		// y lee el fichero xml (libroxmldom.txt) y devuelve una lista en listadoLibrosXMLDOM
			
					path = "prueba\\librosxmldom.txt";
					procXMLDOM.guardarFichero(listadoLibrosPlano,path);
					listadoLibrosXMLDOM =  procXMLDOM.leerFichero(path);
				
		// APARTADO 5 ProcesamientoFicheroXMLJAXB, 
		// guarda la lista de libros obtenida con ProcesamientoFicheroPlano en un fichero XML (libroxmljaxb.txt)
		// y lee el fichero xml (libroxmljaxb.txt) y devuelve una lista en listadoLibrosXMLJAXB
				
					path = "prueba\\librosxmljaxb.txt";
					procXMLJAXB.guardarFichero(listadoLibrosPlano,path);
					listadoLibrosXMLJAXB =  procXMLJAXB.leerFichero(path);
				

		// APARTADO 6 ProcesamientoFicheroJSONGSON, 
		// guarda la lista de libros obtenida con ProcesamientoFicheroPlano en un fichero (librojsongson.txt)
		// y lee el fichero (librojsongson.txt) y devuelve una lista en listadoLibrosJSONGSON
				
					path = "prueba\\librosjsongson.txt";
					procJSONGSON.guardarFichero(listadoLibrosPlano,path);
					listadoLibrosJSONGSON =  procJSONGSON.leerFichero(path);
				
		// APARTADO 8 ProcesamientoFicheroSAX, 
		// lee el fichero xml (libroxmldom.txt) y devuelve una lista en listadoLibrosSAX 
		
					path = "prueba\\librosxmldom.txt";
					listadoLibrosSAX =  procSAX.leerFichero(path);
					
				
			// visualiza por pantalla las listas generadas en las lecturas de ficheros de los diferente procesos	
					System.out.println ("listadoLibrosPlano : " +listadoLibrosPlano);
					System.out.println("listadoLibrosObjeto : "+ listadoLibrosObjeto);
					System.out.println ("listadoLibrosXMLDOM : " +listadoLibrosXMLDOM);
					System.out.println("listadoLibrosXMLJASB : "+ listadoLibrosXMLJAXB);
					System.out.println ("listadoLibrosJSONGSON : " +listadoLibrosJSONGSON);
					System.out.println("listadoLibrosSAX : "+ listadoLibrosSAX);
					
					
				//en los sucesivos catch se gestionan todas las excepciones de todos los procesos que se han ejecutado
				// en este programa principal
					
				}catch (IOException e) {
					
					e.printStackTrace();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

			}
		

	}

}
