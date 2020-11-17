package vista;

import java.util.ArrayList;
import java.util.List;

import datos.CicloDAO;
import modelo.entidades.Asignatura;
import modelo.entidades.Ciclo;

public class ProgramaPrincipal {

	public static void main(String[] args) {
	
		CicloDAO ciclo = new CicloDAO();
		
		Ciclo c = new Ciclo();
		Asignatura a = new Asignatura();
		
		// crear la lista de asignaturas de un ciclo
		
		ArrayList<Asignatura> lista = new ArrayList<Asignatura>();
		
		c.setGrado("superior");
		c.setNombre("DAM");
		c.setId(1);
		
	//	ciclo.insertarCiclo(c);
	//	ciclo.eliminarCiclo(c);
		
		c.setId(5);
		c.setNombre("DAW");
		c.setGrado("superior");
		
		a.setId(1);
		a.setNombre("primera");
		a.setHorasSemanales(3);
		a.setIdCiclo(5);
		lista.add(a);
		
		
		a.setId(2);
		a.setNombre("segunda");
		a.setHorasSemanales(4);
		a.setIdCiclo(5);
		lista.add(a);
	
	 ciclo.crearCiclo(c, lista);
		

		
	}

}
