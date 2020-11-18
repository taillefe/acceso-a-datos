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
		
		ArrayList<Asignatura> lista = new ArrayList<Asignatura>();
		
		c.setGrado("superiorymas");
		c.setNombre("DAM");
		c.setId(4);
		
	//	ciclo.modificarCiclo(c);
	//	ciclo.eliminarCiclo(c);
		
		c.setId(5);
		c.setNombre("DAW");
		c.setGrado("superior");
	//	ciclo.insertarCiclo(c);
		
		System.out.println ("ciclo : "+ c);
		
	
		
		a.setId(2);
		a.setNombre("primera");
		a.setHorasSemanales(160);
		a.setIdCiclo(4);
		lista.add(a);
		
	
		asignatura.insertarAsignatura(a);
		System.out.println ("asignatura : "+ a);
		
		a = new Asignatura();
		
		a.setId(2);
		a.setNombre("segunda");
		a.setHorasSemanales(200);
		a.setIdCiclo(4);
		lista.add(a);
		
	//	System.out.println ("lista : "+ lista);
	
	  ciclo.crearCiclo(c, lista);
	  System.out.println ("ciclo : "+ c);
	
	}
	
	public void borrarAsignaturas(String nombreCiclo) {
		
			Connection con= null;
			ConexionMySQL conMySQL = new ConexionMySQL();
		
			try {
				conMySQL.cargarDriver();
				con = conMySQL.crearConexion();
				CallableStatement st = con.prepareCall("{call borrar_asignaturas(?) }");
				
				st.setString(1, nombreCiclo);  // asigno el valor de parámetro;
			//	st.registerOutParameter
				if (!st.execute()) {
					System.out.println("El procedimiento no ha devuelto resultados");
				}else {
					ResultSet rs = st.getResultSet();
					
				}
				
				
				
				
					
			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}		

}
