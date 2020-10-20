package entrada;

import java.util.ArrayList;
import java.util.List;

import modelo.Mascota;
import negocio.ProcesamientoFicheroXML;

public class EjercicioMascotas {

	public static void main(String[] args) {
	
		List<Mascota> listaM = new ArrayList<Mascota>();
		
		try
		{
			listaM = ProcesamientoFicheroXML.leerMascotas("C:\\Users\\PC33\\Desktop\\Prueba\\mascotas.xml");
			
			System.out.println( "mascotas : " + listaM);
			
			Mascota nuevaMascota = new Mascota("Churchill","Gato",2,"Macho");
			listaM.set(2,nuevaMascota);
			nuevaMascota = new Mascota ("Leo","Gato",0,"");
			listaM.add(nuevaMascota);
			
				
			ProcesamientoFicheroXML.guardarMascotas("C:\\Users\\PC33\\Desktop\\Prueba\\mascotas.xml",listaM);
				
			System.out.println( "mascotas modificadas : " + listaM);
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

}
