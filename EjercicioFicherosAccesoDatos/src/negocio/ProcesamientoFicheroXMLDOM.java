package negocio;

import java.io.File;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.Libro;

import modelo.Personaje;
import modelo.Personaje.TipoImportancia;


/**
 * 
 * @author laura
 * clase ProcesamientoFicheroXMLDOM que hereda de ProcesamientoFichero
 * define los métodos 
 * -leerFichero 
 * -guardarFichero 
 * 
 */

public class ProcesamientoFicheroXMLDOM extends ProcesamientoFichero{
	
	/** 
	 * 	método leerFichero, se usa para leer los datos de un fichero y devolver una lista con los objetos leídos
	 *  @param la ruta donde se encuentra el fichero a leer
	 *  @return devuelve una lista con los objetos Libro que se guardaban en el fichero
	 *  @throws controla las excepciones que se dan en todos los procedimientos y que se heredan 
	 *  		de la interface IProcedimientoFichero 
	 *  		
	 */
	public  List<Libro> leerFichero (String ruta) throws IOException, ParserConfigurationException, SAXException{
		
		
		List<Libro> listaLibros = new ArrayList<Libro>();
		List<Personaje> listaPersonajes = new ArrayList<Personaje>();
		
		String titulo;
		String editorial;
		String autor;
	
		LocalDate fecha;
		String genero;
		String personajes;
		String personaje;
	
		String nombre;
		String importanciaString;
		TipoImportancia importancia;
		
		
		// clases DOM para la lectura del fichero XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Apertura y obtencion del fichedro xml
		Document document = builder.parse(new File(ruta));
		
		//Obtencion de los nodos (<  >) del documento
		NodeList nodeListLibros = document.getDocumentElement().getChildNodes();
		
		//Se recorren los nodos
		for (int i = 0; i < nodeListLibros.getLength(); i++) {
			titulo = "";
			editorial = "";
			autor = "";
			fecha = null;
			genero ="";
			personajes = "";
			personaje = "";
			nombre ="";
			importanciaString ="";
			
			Node node =  nodeListLibros.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE) { //Si el nodo es un elemento DOM
				Element elLibro = (Element) node;
			
				//Busco el nodo que tiene el tag nombre (distingue mayúsculas y minúsculas)
				//y obtengo el valor interno. El texto
				titulo = elLibro.getElementsByTagName("titulo")
						.item(0).getChildNodes().item(0).getNodeValue();
				editorial = elLibro.getElementsByTagName("editorial")
						.item(0).getChildNodes().item(0).getNodeValue();
				autor = elLibro.getElementsByTagName("autor")
						.item(0).getChildNodes().item(0).getNodeValue();
				if(( elLibro.getElementsByTagName("fecha")
						.item(0) ) != null) {
					fecha = LocalDate.parse(elLibro.getElementsByTagName("fecha").item(0).getChildNodes().item(0).getNodeValue(),
							DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				}
				genero = elLibro.getElementsByTagName("genero")
						.item(0).getChildNodes().item(0).getNodeValue();
				
				
				
				
				//Obtencion de los nodos (<Personajes>) del documento
				NodeList nodeListPersonajes =  ((Element)elLibro.getElementsByTagName("personajes").item(0)).getChildNodes();
				
				//Se recorren los nodos
				for (int j = 0; j < nodeListPersonajes.getLength(); j++) {
					personajes = "";
					personaje = "";
					nombre ="";
					importanciaString ="";
					
					Node nodePers =  nodeListPersonajes.item(j);
					
					if (nodePers.getNodeType() == Node.ELEMENT_NODE) { //Si el nodo es un elemento DOM
						Element elPer = (Element) nodePers;
				
						//Element elPer =(Element) elPers.getElementsByTagName("personaje").item(0);
												
						nombre = elPer.getElementsByTagName("nombre")
								.item(0).getChildNodes().item(0).getNodeValue();
						importanciaString = elPer.getElementsByTagName("importancia")
								.item(0).getChildNodes().item(0).getNodeValue();
						
						 importancia =Personaje.TipoImportancia.valueOf(importanciaString.toUpperCase());
						
						listaPersonajes.add((Personaje) new Personaje(nombre,importancia));
					}
				}	
				
				
				// creo un libro con los datos obtenidos y lo añado a la lista
				// para cada libro dentro del xml
				Libro l = new Libro(titulo, editorial, autor, fecha, genero, listaPersonajes);
				listaLibros.add(l);
				listaPersonajes = new ArrayList<Personaje>();
			}//if Node.ELEMENT_NODE
			
		}//for

		return listaLibros;
		
		}
	
	public  void guardarFichero ( List<Libro> listaLibros, String ruta) throws  IOException, ParserConfigurationException, TransformerException{
	
		// clases DOM para construir la estructura XML
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder ;
		
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc =dBuilder.newDocument();
		
		//elemento raiz (<Libro>)
		Element rootElement = doc.createElementNS(null, "libros");
		
		//añado el nodo raiz al documento
		doc.appendChild(rootElement);

		
		//cada elemento <libro> que tenemos en el listado
		for (Libro l:listaLibros) {
			Element libro = doc.createElement("libro"); // creacion de un nodo libro
			
			Element node =doc.createElement("titulo"); // creación de un nodo para el campo titulo
			// se crea un nodo de texto y se pega al nodo titulo
			node.appendChild(doc.createTextNode(l.getTitulo()));
			libro.appendChild(node); // El nodo del campo (titulo) se añade al nodo de libro
			
			node = doc.createElement("editorial");
			node.appendChild(doc.createTextNode(String.valueOf(l.getEditorial())));
			libro.appendChild(node);
			
			node = doc.createElement("autor");
			node.appendChild(doc.createTextNode(String.valueOf(l.getAutor())));
			libro.appendChild(node);
			
			node = doc.createElement("fecha");
			node.appendChild(doc.createTextNode(String.valueOf(l.getFecha())));
			libro.appendChild(node);
			
			node = doc.createElement("genero");
			node.appendChild(doc.createTextNode(l.getGenero()));
			libro.appendChild(node);
			
			 // creacion de un nodo personajes que tendrá hijos
			Element personajes = doc.createElement("personajes");
			libro.appendChild(personajes);
			
			List<Personaje> listaPersonajes = new ArrayList<Personaje>();
			
			listaPersonajes = l.getPersonajes();
			// aqui creamos los hijos de personajes con un for
			for (Personaje p: listaPersonajes) {
				
				Element personaje = doc.createElement("personaje"); // creacion de un nodo personaje
				personajes.appendChild(personaje); //personaje es hijo de personajes
				
				node = doc.createElement("nombre");
				node.appendChild(doc.createTextNode(String.valueOf(p.getNombre())));
				personaje.appendChild(node);
				
				node = doc.createElement("importancia");
				node.appendChild(doc.createTextNode(String.valueOf(p.getImportancia())));
				personaje.appendChild(node);
			
			}
			// al final, se asigna el nodo libro al nodo raiz (<libros>)
			rootElement.appendChild(libro);
		}//for
		
		TransformerFactory transformerFactory  = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		
		StreamResult file = new StreamResult(new File(ruta));
		
		transformer.transform(source, file);
	
		}

}
