package negocio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



import modelo.Mascota;

public class ProcesamientoFicheroXML {
	
	public static List<Mascota> leerMascotas (String ruta) throws ParserConfigurationException, SAXException, IOException{
	
		
	List<Mascota> mascotas = new ArrayList<Mascota>();
	String nombre = "";
	String tipo = "";
	int edad = 0 ;
	String genero =  "";
	
	
	
	// clases DOM para la lectura del fichero XML
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	
	//Apertura y obtencion del fichedro xml
	Document document = builder.parse(new File(ruta));
	
	//Obtencion de los nodos (<  >) del documento
	NodeList nodeList = document.getDocumentElement().getChildNodes();
	
	//Se recorren los nodos
	for (int i = 0; i < nodeList.getLength(); i++) {
		nombre = "";
		tipo = "";
		edad = 0;
		genero = "";
		
		Node node =  nodeList.item(i);
		
		if (node.getNodeType() == Node.ELEMENT_NODE) { //Si el nodo es un elemento DOM
			Element elMasc = (Element) node;
			
			//obtenemos el valor del atributo
			nombre = elMasc.getAttribute("Nombre");
			
			
			//Busco el nodo que tiene el tag nombre (distingue mayúsculas y minúsculas)
			//y obtengo el valor interno. El texto
			tipo = elMasc.getElementsByTagName("tipo")
					.item(0).getChildNodes().item(0).getNodeValue();
			if(( elMasc.getElementsByTagName("edad")
					.item(0) ) != null) {
		
				edad = Integer.valueOf(elMasc.getElementsByTagName("edad")
						.item(0).getChildNodes().item(0).getNodeValue());
			}
			
			edad = Integer.valueOf(elMasc.getElementsByTagName("edad")
					.item(0).getChildNodes().item(0).getNodeValue());
			if(( elMasc.getElementsByTagName("genero")
					.item(0) ) != null) {
				
			
				genero = elMasc.getElementsByTagName("genero")
					.item(0).getChildNodes().item(0).getNodeValue();
			}
			// creo una Mascota con los datos obtenidos y lo añado a la lista
			// para cada mascota dentro del xml
			Mascota m = new Mascota(nombre, tipo, edad, genero);
			mascotas.add(m);
		}//if Node.ELEMENT_NODE
		
	}//for
	
	System.out.println( "mascotas : " + mascotas);
	
	return mascotas;
	
	}
}
