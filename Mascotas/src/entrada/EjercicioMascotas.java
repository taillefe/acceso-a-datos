package entrada;

import java.util.ArrayList;
import java.util.List;

import modelo.Mascota;
import negocio.ProcesamientoFicheroXML;

public class EjercicioMascotas {

	public static void main(String[] args) {
	
		List<Mascota> listamascotas = new ArrayList<Mascota>();
		
		try
		{
			listamascotas = ProcesamientoFicheroXML.leerMascotas("C:\\Users\\PC33\\Desktop\\Prueba\\mascotas.xml");
			Mascota nuevaMascota = new Mascota("Churchill","Gato",2,"Macho");
			listamascotas.set(2,nuevaMascota);
			nuevaMascota = new Mascota ("Leo","Gato",0,"");
			listamascotas.add(nuevaMascota);
			for (Mascota m: listamascotas) {
				
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

}
