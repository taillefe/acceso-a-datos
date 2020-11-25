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
import modelo.entidades.Asignatura;
import modelo.entidades.Ciclo;

public class ProgramaPrincipal {

	public static void main(String[] args) {
	
		CicloDAO ciclo = new CicloDAO();
		AsignaturaDAO asignatura = new AsignaturaDAO();
		
		Ciclo c = new Ciclo();
		Asignatura a = new Asignatura();
		
		// crear la lista de asignaturas de un ciclo
		
		
	//	borrarAsignaturas("DAM");
		ArrayList<Asignatura> lista = new ArrayList<Asignatura>();
		ArrayList<Ciclo> listac = new ArrayList<Ciclo>();
/*		
		c.setGrado("superiorymas");
		c.setNombre("DAM1");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
		c.setGrado("superiorymas");
		c.setNombre("DAM2");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
		c.setGrado("superiorymas");
		c.setNombre("DAM3");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
		c.setGrado("superiorymas");
		c.setNombre("DAM4");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
		c.setGrado("superiorymas");
		c.setNombre("DAM5");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
		c.setGrado("superiorymas");
		c.setNombre("DAM6");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
		c.setGrado("superiorymas");
		c.setNombre("DAM7");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
	*/
		c.setGrado("superiorymas");
		c.setNombre("DAM8");
		c.setId(4);
		listac.add(c);
		c = new Ciclo();
		
		c.setGrado("superiorymas");
		c.setNombre("DAM");
		c.setId(4);
		listac.add(c);
	
		
		c = new Ciclo();
		c.setId(5);
		c.setNombre("DAW");
		c.setGrado("superior");
		listac.add(c);
	
		ciclo.insertarCiclo(listac);
		System.out.println ("lista ciclo : "+ listac);
		
	//	System.out.println ("ciclo : "+ c);
		
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		lista.add(a);
		
		a = new Asignatura();
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		lista.add(a);
		
		a = new Asignatura();
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		lista.add(a);
		
		a = new Asignatura();
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		lista.add(a);
		
	//	asignatura.insertarAsignatura(lista);
	//	System.out.println ("lista asignatura : "+ lista);
		
		a = new Asignatura();
		
		a.setId(2);
		a.setNombre("segunda");
		a.setHorasSemanales(200);
		a.setIdCiclo(4);
		lista.add(a);
		
	//	System.out.println ("lista : "+ lista);
	
//	  ciclo.crearCiclo(c, lista);
	//  System.out.println ("ciclo : "+ c);
	
	}
	
	public static void borrarAsignaturas(String nombreCiclo) {
		
			Connection con= null;
			ConexionMySQL conMySQL = new ConexionMySQL();
		
			try {
				conMySQL.cargarDriver();
				con = conMySQL.crearConexion();
				CallableStatement st = con.prepareCall("{call borrar_asignaturas(?) }");
				
				st.setString(1, nombreCiclo);  // asigno el valor de parámetro;
			//	st.registerOutParameter
				 st.getUpdateCount();

			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}		

}
