package Vista;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Entidades.Asignatura;
import Entidades.Profesor;
import Modelo.IProcesamiento;
import Modelo.ProcesamientoFichero;
import Modelo.ProcesamientoXMLJSON;

public class Examen {

	public static void main(String[] args) {
		String rutaFicheroBinarioTexto=".//Ficheros//FicheroBinarioTexto.bin";
		String rutaFicheroObjetos=".//Ficheros//FicheroProfesores.bin";
		String rutaFicheroXML=".//Ficheros//Asignaturas.xml";
		String rutaFicheroJSON=".//Ficheros//Asignaturas.json";
		String rutaFicheroProfesoresJAXB =".//Ficheros//FicheroProfesores.xml";
		
		
		File f= new File(rutaFicheroBinarioTexto);
		String py=f.getAbsolutePath();
		
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		Profesor p1= new Profesor(1,"Fernando","Vazquez");
		Profesor p2= new Profesor(2,"Daniel","Rivas");
		Profesor p3= new Profesor(3,"Jesus","Otero");
		asignaturas.add(new Asignatura(1,"Acceso a Datos",120,p1));
		asignaturas.add(new Asignatura(2,"Interfaces",140,p1));
		asignaturas.add(new Asignatura(3,"Dispositivos Moviles",160,p2));
		asignaturas.add(new Asignatura(4,"Programación de Servicios y Procesos",180,p3));
		
		// Apartado 1
		IProcesamiento proc= new ProcesamientoFichero();
		try {
			proc.guardarAsignaturas(rutaFicheroBinarioTexto, asignaturas);
			proc.imprimirAsignaturas(rutaFicheroBinarioTexto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Apartado 2
		
		ArrayList<Profesor> profesores= new ArrayList<Profesor>();
		for(Asignatura a:asignaturas) {
			profesores.add(a.getProfesor());
		}
		try {
			proc.guardarProfesores(profesores, rutaFicheroObjetos);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Apartado 3
		IProcesamiento proc2= new ProcesamientoXMLJSON();
		
		try {
			ArrayList<Asignatura> listaAsignXML= proc2.leerAsignaturas(rutaFicheroXML);
			System.out.println("Listado de asignaturas obtenidas de XML");
			for(Asignatura a:listaAsignXML) {
				System.out.println(a);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			proc2.guardarAsignaturas(rutaFicheroJSON, asignaturas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			proc2.guardarProfesores(profesores, rutaFicheroProfesoresJAXB);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Apartado 4
		//Había que añadir algun comentario para jdoc como los que puse en UtilFichero
		//y generar la documentación para todas las clases

	}

}
