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
		c.setNombre("DAM");
		c.setGrado("superior");
		listaCiclos.add(c);
	// añado ciclos a la listaCiclos
		
			
		a.setId(77);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(10);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(77);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(10);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(77);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(10);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(77);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(10);
		listaAsignaturas.add(a);
		
		a = new Asignatura();
		a.setId(77);
		a.setNombre("segunda");
		a.setHorasSemanales(200);
		a.setIdCiclo(10);
		listaAsignaturas.add(a);
		// añado asignaturas a la listaAsignaturas
		
		// en esta parte pruebo todos los métodos
		// teniendo en cuenta que no se pueden insertar asignaturas de las que
		// no haya creado el ciclo correspondiente antes
	/*	
		asignatura.insertarAsignatura(a);
		asignatura.eliminarAsignatura(a);
		asignatura.modificarAsignatura(a);
		asignatura.insertarAsignatura(listaAsignaturas);
		asignatura.eliminarAsignatura(listaAsignaturas);
		asignatura.modificarAsignatura(listaAsignaturas);
		
		ciclo.crearCiclo(c, listaAsignaturas);
		ciclo.insertarCiclo(c);
		ciclo.modificarCiclo(c);
		ciclo.eliminarCiclo(c);
		
		ciclo.insertarCiclo(listaCiclos);
		ciclo.modificarCiclo(listaCiclos);
		ciclo.eliminarCiclo(listaCiclos);
		*/
		asignatura.borrarAsignaturas("DAM");
	
		System.out.println ("lista asignatura : "+ listaAsignaturas);

		System.out.println ("lista ciclos: "+ listaCiclos);
	
	
		System.out.println ("ciclo : "+ c);
	
	}
	
	

}
