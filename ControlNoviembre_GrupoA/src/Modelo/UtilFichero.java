package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Entidades.Asignatura;
import Entidades.Asignaturas;
import Entidades.Profesor;
import Entidades.Profesores;

public class UtilFichero {

	/**
	 * Lee el fichero de la ruta utilizando un flujo de datos binario
	 * @param ruta ruta del fichero
	 * @return string con el contenido del fichero
	 * @throws IOException Excepción si no se encuentra el fichero o si hubo algún error al intentar leer de él
	 */
	public static String leerBinario(String ruta) throws IOException {
		FileInputStream fis = new FileInputStream(ruta);
		int i;
		String contenido = "";
		while ((i = fis.read()) != -1) {
			contenido = contenido + (char) i;
		}
		fis.close();
		return contenido;
	}// leerBinario

	/**
	 * Escribe los datos pasados en un fichero indicado mediante un flujo de datos binario
	 * @param datos String con los datos a escribir en el fichero
	 * @param ruta ruta del fichero donde escribir
	 * @throws IOException Excepción si no se encuentra el fichero o si hubo algún error al intentar escribir en él
	 */
	public static void escribirBinario(String datos, String ruta) throws IOException {
		FileOutputStream fos = new FileOutputStream(ruta);
		fos.write(datos.getBytes());
		fos.close();
	}// escribirBinario

	/**
	 * Lee el fichero de la ruta utilizando un flujo de caracteres
	 * @param ruta ruta del fichero
	 * @return string con el contenido del fichero
	 * @throws IOException Excepción si no se encuentra el fichero o si hubo algún error al intentar leer de él
	 */
	public static String leerTexto(String ruta) throws IOException {
		FileReader fr = new FileReader(ruta);
		int i;
		String contenido = "";
		while ((i = fr.read()) != -1) {
			contenido = contenido + (char) i;
		}
		fr.close();
		return contenido;
	}// leerTexto

	/**
	 * Escribe los datos pasados en un fichero indicado mediante un flujo de caracteres
	 * @param datos String con los datos a escribir en el fichero
	 * @param ruta ruta del fichero donde escribir
	 * @throws IOException Excepción si no se encuentra el fichero o si hubo algún error al intentar escribir en él
	 */
	public static void escribirTexto(String datos, String ruta) throws IOException {
		FileWriter fw = new FileWriter(ruta);
		fw.write(datos);
		fw.close();
	}// escribirTexto

	/**
	 * Serializa los objetos pasados en un fichero con la ruta dada 
	 * @param profesores ArrayList de objetos de tipo Profesor a serializar
	 * @param ruta ruta del fichero donde se guardaran los objetos serializados
	 * @throws IOException Excepción si no se encuentra el fichero o si hubo algún error al intentar escribir en él
	 */
	public static void escribirProfesores(ArrayList<Profesor> profesores, String ruta) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
		for (Profesor p : profesores) {
			oos.writeObject(p);
		}
		oos.close();
	}// escribirProfesores (objeto)

	/**
	 * Método que persiste una colección de objetos en un fichero xml con la ruta dada mediante JAXB
	 * @param profesores ArrayList de objetos de tipo Profesor a serializar
	 * @param ruta ruta del fichero donde se guardaran los objetos serializados
	 * @throws JAXBException Excepción lanzada al haber algun tipo de error en el procesamiento
	 */
	public static void escribirProfesoresJAXB(ArrayList<Profesor> profesores, String ruta) throws JAXBException {
		File file = new File(ruta);

		JAXBContext jaxbContext = JAXBContext.newInstance(Profesores.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		Profesores listaProf = new Profesores();
		listaProf.setListaProfesores(profesores);
		jaxbMarshaller.marshal(listaProf, file);

	}// escribirProfesoresJAXB (xml)

	/**
	 * Método para la lectura de información de un fichero XML dado y su conversión a objetos mediante DOM
	 * @param ruta Ruta del fichero del que extraer la información
	 * @return un ArrayList de objetos Asignatura con los datos leídos del fichero xml
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static ArrayList<Asignatura> leerDOM(String ruta)
			throws ParserConfigurationException, SAXException, IOException {
		ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

		// Creación del builder de XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		NodeList nodeList;

		builder = factory.newDocumentBuilder();
		document = builder.parse(new File(ruta));
		nodeList = document.getDocumentElement().getChildNodes();
		// Recorrido del documento
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				// Obtención de los elementos del XML
				Element elAsignatura = (Element) nNode;
				String id = elAsignatura.getElementsByTagName("id").item(0).getTextContent();
				String nombre = elAsignatura.getElementsByTagName("nombre").item(0).getTextContent();
				String horas = elAsignatura.getElementsByTagName("horasAsignadas").item(0).getTextContent();
				Node profesor = elAsignatura.getElementsByTagName("profesor").item(0);
				Profesor p = null;
				if (profesor != null) {
					Element elProfesor = (Element) profesor;
					String idPr = elProfesor.getElementsByTagName("id").item(0).getTextContent();
					String nombrePr = elProfesor.getElementsByTagName("nombre").item(0).getTextContent();
					String apellPr = elProfesor.getElementsByTagName("apellidos").item(0).getTextContent();
					p = new Profesor(Integer.parseInt(idPr), nombrePr, apellPr);
				}
				Asignatura as = new Asignatura(Integer.parseInt(id), nombre, Integer.parseInt(horas), p);
				listaAsignaturas.add(as);
			}
		}

		return listaAsignaturas;
	}// leerDOM

	/**
	 * Método para la lectura de información de un fichero XML dado y su conversión a objetos mediante JAXB
	 * @param ruta Ruta del fichero del que extraer la información
	 * @return un ArrayList de objetos Asignatura con los datos leídos del fichero xml
	 * @throws JAXBException
	 */
	public static ArrayList<Asignatura> leerJAXB(String ruta) throws JAXBException {
		File file = new File(ruta);
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		if (file.exists()) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Asignaturas.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Asignaturas listaAsignaturas = (Asignaturas) jaxbUnmarshaller.unmarshal(file);
			asignaturas = (listaAsignaturas != null ? listaAsignaturas.getListaAsignaturas()
					: new ArrayList<Asignatura>());

		} else {
			System.out.println("No se ha podido encontrar el fichero indicado");
		}

		return asignaturas;
	}// leerJAXB

	/**
	 * Método para la lectura de información de un fichero XML dado y su conversión a objetos mediante SAX
	 * @param ruta Ruta del fichero del que extraer la información
	 * @return un ArrayList de objetos Asignatura con los datos leídos del fichero xml
	 * @throws JAXBException
	 */
	public static ArrayList<Asignatura> leerSAX(String ruta) throws JAXBException {
		File file = new File(ruta);
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		if (file.exists()) {
			try {
				XMLReader lector = XMLReaderFactory.createXMLReader();
				ParseadorAsignaturasSAX parser = new ParseadorAsignaturasSAX();
				lector.setContentHandler(parser);
				InputSource fichero = new InputSource(ruta);
				lector.parse(fichero);
				asignaturas = parser.obtenerResultado();

			} catch (Exception ex) {
				System.out.println("Excepcion en el procesamiento del XML");
				ex.printStackTrace();
			}
		} else {
			System.out.println("No se ha podido encontrar el fichero indicado");
		}

		return asignaturas;
	}// leerSAX

	/**
	 * Metodo para guardar la información de una colección de objetos en un fichero JSON mediante GSON
	 * @param asignaturas ArrayList de objetos Asignatura a persistir
	 * @param ruta Ruta del fichero donde guardar la información
	 * @throws IOException
	 */
	public static void guardarJSON(ArrayList<Asignatura> asignaturas, String ruta) throws IOException {

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String json = gson.toJson(asignaturas);

		escribirTexto(json, ruta);
	}//guardarJSON

	/**
	 * Metodo para guardar la información de una colección de objetos en un fichero XML mediante DOM
	 * @param asignaturas ArrayList de objetos Asignatura a persistir
	 * @param ruta Ruta del fichero donde guardar la información
	 */
	public static void guardarDOM(ArrayList<Asignatura> asignaturas, String ruta) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {

			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element rootElement = doc.createElementNS(null, "listaAsignaturas");
			doc.appendChild(rootElement);

			for (Asignatura a : asignaturas) {
				/*
				 * <listaAsignaturas> <asignatura> <id>1</id> <nombre>Acceso a Datos</nombre>
				 * <horasAsignadas>160</horasAsignadas> <profesor> <id>1</id>
				 * <nombre>Fernando</nombre> <apellidos>Vazquez</apellidos> </profesor>
				 * </asignatura>
				 */
				Element asignatura = doc.createElement("asignatura");

				Element node = doc.createElement("id");
				node.appendChild(doc.createTextNode(String.valueOf(a.getId())));
				asignatura.appendChild(node);

				node = doc.createElement("nombre");
				node.appendChild(doc.createTextNode(a.getNombre()));
				asignatura.appendChild(node);

				node = doc.createElement("horasAsignadas");
				node.appendChild(doc.createTextNode(String.valueOf(a.getHoras())));
				asignatura.appendChild(node);

				Element nodeProfesor = doc.createElement("profesor");
				Profesor p= a.getProfesor();
				if(p!=null) {
					node = doc.createElement("id");
					node.appendChild(doc.createTextNode(String.valueOf(p.getId())));
					nodeProfesor.appendChild(node);
	
					node = doc.createElement("nombre");
					node.appendChild(doc.createTextNode(p.getNombre()));
					nodeProfesor.appendChild(node);
	
					node = doc.createElement("apellidos");
					node.appendChild(doc.createTextNode(p.getApellidos()));
					nodeProfesor.appendChild(node);
	
					asignatura.appendChild(nodeProfesor);
				}

				rootElement.appendChild(asignatura); // al final, asignamos el nodo mascota al nodo raiz (<mascotas>)

			} // for

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			StreamResult file = new StreamResult(new File(ruta));
			transformer.transform(source, file);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}//guardarDOM

}
