package entrada;

import java.util.ArrayList;
import java.util.List;

import modelo.Mascota;
import negocio.ProcesamientoFicheroXML;

public class EjercicioMascotas {

	public static void main(String[] args) {
	
		List<Mascota> mascotas = new ArrayList<Mascota>();
		
		try
		{
			mascotas = ProcesamientoFicheroXML.leerMascotas("C:\\Users\\PC33\\Desktop\\Prueba\\mascotas.xml");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

}
