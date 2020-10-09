package persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
	
		//crear un arrayList de persona y meter los objetos persona creados
		
		ArrayList<Persona> listado = new ArrayList<Persona>();
		
		Persona p;
		
		p = new Persona("Lucas","Gonzalez",  LocalDate.parse("12/12/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		listado.add(p);
		
		p = new Persona("Pedro","Perez",  LocalDate.parse("11/11/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		listado.add(p);
		
		
		
		
	}

}
/*

FileInputStream fis = new FileInputStream("Datos/Encuestados.txt");
ObjectInputStream ois = new ObjectInputStream(fis);

encuestados = (List<Encuestado>) ois.readObject();

ois.close();


/////////////////////////////////

 FileOutputStream fos = null;
 
ObjectOutputStream salida = null;
Persona p;

try {
    //Se crea el fichero
    fos = new FileOutputStream("/ficheros/personas.dat");                                                 
    salida = new ObjectOutputStream(fos);

    //Se crea el primer objeto Persona
    p = new Persona("12345678A","Lucas González", 30);

    //Se escribe el objeto en el fichero
    salida.writeObject(p);

    //Se crea el segundo objeto Persona
    p = new Persona("98765432B","Anacleto Jiménez", 28);

    //Se escribe el objeto en el fichero
    salida.writeObject(p);

    //Se crea el tercer objeto Persona
    p = new Persona("78234212Z","María Zapata", 35);

    //Se escribe el objeto en el fichero
    salida.writeObject(p);
   
} catch (FileNotFoundException e) {
         System.out.println("1"+e.getMessage());                                                          
} catch (IOException e) {
         System.out.println("2"+e.getMessage());
} finally {
    try {
        if(fos!=null){
           fos.close();
        }
        if(salida!=null){
           salida.close();
        }
    } catch (IOException e) {
             System.out.println("3"+e.getMessage());
    }
}
*/