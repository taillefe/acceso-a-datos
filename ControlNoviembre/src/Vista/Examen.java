package Vista;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import Entidades.Asignatura;
import Entidades.Profesor;
import Modelo.ProcesamientoFichero;
import Modelo.ProcesamientoXMLJSON;



/**
 * 
 * @author laura
 * 
 */
public class Examen {
	/**
	 * proceso principal
	 * @param args
	 */
	public static void main(String[] args)  {
		
		//Ruta del fichero
		String rutaFicheroBinarioTexto=".//Ficheros//FicheroBinarioTexto.bin";
		String rutaFicheroObjetos=".//Ficheros//FicheroProfesores.bin";
		String rutaFicheroEntradaXML=".//Ficheros//Asignaturas.xml";
		String rutaFicheroXML=".//Ficheros//FicheroXML.xml";
		String rutaFicheroJSON=".//Ficheros//FicheroJSON.json";
		//Creacion del arraylist de asignaturas (con los mismos datos que el XML dado)
		
	
		
			
		ArrayList<Asignatura> listaAsignaturas = new ArrayList();
		ArrayList<Profesor> listaProfesores = new ArrayList();
		
		Profesor profesor = new Profesor(1,"Fernando","Vazquez");
		Profesor profesor2 = new Profesor(2,"Fernando","Vazquez");
		Profesor profesor3 = new Profesor(3,"Daniel","Rivas");
		Profesor profesor4 = new Profesor(4,"Jesus","Otero");
		
		
		Asignatura asignatura = new Asignatura(1, "Acceso a Datos", 160,profesor);
		Asignatura asignatura2 = new Asignatura(2, "Interfaces", 160, profesor2);
		Asignatura asignatura3 = new Asignatura(3, "Dispositivos Moviles", 160, profesor3);
		Asignatura asignatura4 = new Asignatura(4, "Programacion de Servicios y Procesos", 160, profesor4);
		
		listaAsignaturas.add(asignatura);
		listaAsignaturas.add(asignatura2);
		listaAsignaturas.add(asignatura3);
		listaAsignaturas.add(asignatura4);
		
		String texto = asignatura.toString();
		
		
		
		texto = texto + profesor.toString();
		System.out.println("primera lista" +listaAsignaturas);
	
		
		// Apartado 1
		
		ProcesamientoFichero proc = new ProcesamientoFichero();
		try {
			proc.guardarAsignaturas(rutaFicheroBinarioTexto,listaAsignaturas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
				proc.imprimirAsignaturas(rutaFicheroBinarioTexto);
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Apartado 2
		
		for(Asignatura a : listaAsignaturas) {
	
	    	listaProfesores.add(a.getProfesor());
		}	
		
		try {
			proc.guardarProfesores(listaProfesores, rutaFicheroObjetos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Apartado 3
		
		
		ArrayList<Asignatura> listaAsignaturasSAX = new ArrayList();
		ProcesamientoXMLJSON procXMLJSON = new ProcesamientoXMLJSON();
		listaAsignaturasSAX = procXMLJSON.leerAsignaturas(rutaFicheroEntradaXML);
		
		System.out.println ("SAX : "+ listaAsignaturasSAX);
		

		
		
		for(Asignatura a : listaAsignaturas) {
			
	    	listaProfesores.add(a.getProfesor());
	    	System.out.println("l"+listaProfesores);
		}	
		
		try {
			try {
				procXMLJSON.guardarProfesores(listaProfesores, rutaFicheroXML);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
