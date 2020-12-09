package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.IAsignaturaDAO;
import modelo.entidades.Asignatura;
import modelo.entidades.Ciclo;

public class AsignaturaDAO implements IAsignaturaDAO {

	@Override
	public void insertarAsignatura(Asignatura a) {
	
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		try {
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// hacer un prepareStatement para insertar
			// los datos de la asignatura a
			String consulta ="INSERT INTO ASIGNATURA "
					+ "(NOMBRE, HORAS_SEMANALES, ID_CICLO) VALUES "
					+"(?,?,?);";
	
			PreparedStatement ps = con.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, a.getNombre());
			ps.setInt(2, a.getHorasSemanales());
			ps.setInt(3, a.getIdCiclo());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();	// posicionado al principio
			rs.next();  // se posiciona en la primera posición, que es la que nos interesa
		
			a.setId(rs.getInt(1));  // insertar en a el valor del id recuperado en rs
	
			con.commit();
			ps.close();
	
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al cargar el driver de la bbdd");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
			try {
				System.out.println("Se realiza el rollback");
				con.rollback(); // Rollback si ha habido un error en la ejecucion
			}catch (SQLException e1) {
				System.out.println("Error haciendo el rollback");
				e1.printStackTrace();
			}
		}finally {
			try {
				if(con!=null && !con.isClosed())
					conMySQL.cerrarConexion(con);
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
	}

	@Override
	public void eliminarAsignatura(Asignatura a) {

		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		try {
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// hacer un prepareStatement para insertar
			// los datos de la asignatura a
			String consulta ="DELETE FROM ASIGNATURA "
					+ "WHERE ID =?;";
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setInt(1, a.getId());
			ps.executeUpdate();
			con.commit();
			ps.close();
	
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al cargar el driver de la bbdd");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
			try {
				System.out.println("Se realiza el rollback");
				con.rollback(); // Rollback si ha habido un error en la ejecucion
			}catch (SQLException e1) {
				System.out.println("Error haciendo el rollback");
				e1.printStackTrace();
			}
		}finally {
			try {
				if(con!=null && !con.isClosed())
					conMySQL.cerrarConexion(con);
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
	}

	@Override
	public void modificarAsignatura(Asignatura a) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		try {
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// hacer un prepareStatement para insertar
			// los datos de la asignatura a
			String consulta ="UPDATE ASIGNATURA "
					+ "SET NOMBRE = ?, HORAS_SEMANALES = ?, ID_CICLO = ? "
					+"WHERE ID = ?;";
	
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, a.getNombre());
			ps.setInt(2, a.getHorasSemanales());
			ps.setInt(3, a.getIdCiclo());
			ps.setInt(4, a.getId());
			ps.executeUpdate();
			con.commit();
			ps.close();
	
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al cargar el driver de la bbdd");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
			try {
				System.out.println("Se realiza el rollback");
				con.rollback(); // Rollback si ha habido un error en la ejecucion
			}catch (SQLException e1) {
				System.out.println("Error haciendo el rollback");
				e1.printStackTrace();
			}
		}finally {
			try {
				if(con!=null && !con.isClosed())
					conMySQL.cerrarConexion(con);
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
	}

	@Override
	public void insertarAsignatura(List<Asignatura> lista) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		PreparedStatement ps = null;
		try {
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// recorrer toda la lista de asignaturas
			// hacer un prepareStatement para insertar
			// los datos de cada asignatura a			
			String consulta ="INSERT INTO ASIGNATURA "
					+ "(NOMBRE, HORAS_SEMANALES, ID_CICLO) VALUES "
					+"(?,?,?);";
		
			ps = con.prepareStatement(consulta);
			
			for (Asignatura a: lista) {
				
				ps.setString(1, a.getNombre());
				ps.setInt(2, a.getHorasSemanales());
				ps.setInt(3, a.getIdCiclo());
				ps.addBatch();  // se añade al lote de ejecución
				
				System.out.println("asignaturas :"+a);
			}
			ps.executeBatch();  // ejecución del lote
			con.commit();
			ps.close();
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al cargar el driver de la bbdd");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
			try {
				System.out.println("Se realiza el rollback");
				con.rollback(); // Rollback si ha habido un error en la ejecucion
			}catch (SQLException e1) {
				System.out.println("Error haciendo el rollback");
				e1.printStackTrace();
			}
		}finally {
			try {
				if(con!=null && !con.isClosed())
					conMySQL.cerrarConexion(con);
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
	}

	@Override
	public void eliminarAsignatura(List<Asignatura> lista) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		PreparedStatement ps = null;
		try {
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// recorrer toda la lista de asignaturas
			// hacer un prepareStatement para insertar
			// los datos de cada asignatura a			
			String consulta ="DELETE FROM ASIGNATURA "
					+ "WHERE ID = ?; ";
		
			ps = con.prepareStatement(consulta);
			
			for (Asignatura a: lista) {
				
				ps.setInt(1, a.getId());
				ps.addBatch();  // se añade al lote de ejecución
			}
			ps.executeBatch();  // ejecución del lote
			con.commit();
			ps.close();
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al cargar el driver de la bbdd");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
			try {
				System.out.println("Se realiza el rollback");
				con.rollback(); // Rollback si ha habido un error en la ejecucion
			}catch (SQLException e1) {
				System.out.println("Error haciendo el rollback");
				e1.printStackTrace();
			}
		}finally {
			try {
				if(con!=null && !con.isClosed())
					conMySQL.cerrarConexion(con);
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
	}

	@Override
	public void modificarAsignatura(List<Asignatura> lista) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		PreparedStatement ps = null;
		try {
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// recorrer toda la lista de asignaturas
			// hacer un prepareStatement para insertar
			// los datos de cada asignatura a			
			String consulta ="UPDATE ASIGNATURA "
					+ "SET NOMBRE = ?, HORAS_SEMANALES = ?, ID_CICLO =? "
					+"WHERE ID = ?;";
		
			ps = con.prepareStatement(consulta);
			
			for (Asignatura a: lista) {
				
				ps.setString(1, a.getNombre());
				ps.setInt(2, a.getHorasSemanales());
				ps.setInt(3, a.getIdCiclo());
				ps.setInt(4, a.getId());
				ps.addBatch();  // se añade al lote de ejecución
			}
			ps.executeBatch();  // ejecución del lote
			con.commit();
			ps.close();
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al cargar el driver de la bbdd");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
			try {
				System.out.println("Se realiza el rollback");
				con.rollback(); // Rollback si ha habido un error en la ejecucion
			}catch (SQLException e1) {
				System.out.println("Error haciendo el rollback");
				e1.printStackTrace();
			}
		}finally {
			try {
				if(con!=null && !con.isClosed())
					conMySQL.cerrarConexion(con);
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}	

	}
	
	
	/**
	 * metodo borrarAsignaturas llamando a un procedimiento almacenado en la base de datos 
	 * call borrar_asignaturas, pasandole el nombre del ciclo que se quiere borrar.
	 * borrará el ciclo con ese nombre que tenga el id mas grande
	 * @param nombreCiclo
	 */
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
				if (!st.execute()) {
					// entra por aquí si el método no devuelve nada
				}else {
					ResultSet rs = st.getResultSet(); // si devuelve algo se usa 
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
