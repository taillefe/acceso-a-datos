package vista;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datos.AsignaturaDAO;
import datos.CicloDAO;
import datos.ConexionMySQL;
import modelo.MapeadorAsignaturaVO;
import modelo.entidades.Asignatura;
import modelo.entidades.Ciclo;
import vista.presentacion.AsignaturaVO;
import vista.presentacion.CicloVO;
import modelo.MapeadorAsignaturaVO;
import modelo.MapeadorCicloVO;

public class ProgramaPrincipal {

	public static void main(String[] args) {
	
		CicloDAO ciclo = new CicloDAO();
		AsignaturaDAO asignatura = new AsignaturaDAO();
		
		Ciclo c = new Ciclo();
		Asignatura a = new Asignatura();
		
		CicloVO cVO = new CicloVO();
		AsignaturaVO aVO = new AsignaturaVO();
		
		// He creado AsignaturaVO y CicloVO y sus Mapeadores con Asignatura y Ciclo
		// para usar en la parte visual de los datos
		MapeadorAsignaturaVO maVO = new MapeadorAsignaturaVO();
		aVO = maVO.mapearAsignaturaAsignaturaVO (a);
		
		MapeadorCicloVO mcVO = new MapeadorCicloVO();
		cVO = mcVO.mapearCicloCicloVO (c);
		
		// Trabajo con los objetos Ciclo y Asignatura directamente
		
		// creo la lista de asignaturas de un ciclo
	
		ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		ArrayList<Ciclo> listaCiclos = new ArrayList<Ciclo>();
		
	
		c.setGrado("superiorymas");
		c.setNombre("DAM7");
		c.setId(4);
		listaCiclos.add(c);
		c = new Ciclo();
	
		c.setGrado("superior");
		c.setNombre("DAM8");
		c.setId(4);
		listaCiclos.add(c);
		c = new Ciclo();
		
		c.setGrado("superior+");
		c.setNombre("DAM");
		c.setId(20);
		listaCiclos.add(c);
			
		c = new Ciclo();
		c.setId(5);
		c.setNombre("DAW");
		c.setGrado("superior");
		listaCiclos.add(c);
	// añado ciclos a la listaCiclos
		
	
		System.out.println ("lista ciclo : "+ listaCiclos);
		
	//	System.out.println ("ciclo : "+ c);
		
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(2);
		a.setNombre("segunda");
		a.setHorasSemanales(200);
		a.setIdCiclo(4);
		listaAsignaturas.add(a);
		// añado asignaturas a la listaAsignaturas
		
		
		
		asignatura.insertarAsignatura(listaAsignaturas);
		ciclo.insertarCiclo(listaCiclos);
		ciclo.eliminarCiclo(c);
	
		System.out.println ("lista asignatura : "+ listaAsignaturas);

		System.out.println ("lista ciclos: "+ listaCiclos);
	
		ciclo.crearCiclo(c, listaAsignaturas);
		
		asignatura.borrarAsignaturas("DAM");  
	//  System.out.println ("ciclo : "+ c);
	
	}
	
	

}
