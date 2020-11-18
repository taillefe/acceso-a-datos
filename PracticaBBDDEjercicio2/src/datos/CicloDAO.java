package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.ICicloDAO;
import modelo.entidades.Asignatura;
import modelo.entidades.Ciclo;

public class CicloDAO implements ICicloDAO {

	@Override
	public void insertarCiclo(Ciclo c) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		try {
			
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// hacer un prepareStatement para insertar
			// los datos de ciclo c
			String consulta ="INSERT INTO CICLO "
					+ "(NOMBRE, GRADO) VALUES "
					+"(?,?);";
	// esto sería con Statement				
	//				+ "(" + c.getId() +","+ c.getNombre() 
	//				+ "," + c.getGrado() +");";
			PreparedStatement ps = con.prepareStatement(consulta,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getGrado());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();	// posicionado al principio
			rs.next();  // se posiciona en la primera posición, que es la que nos interesa
		
			c.setId(rs.getInt(1));  // insertar en c el valor del id recuperado en rs
			con.commit();
			ps.close();
	// esto sería con Statemet		
	//		Statement s= con.createStatement();
	//		s.executeUpdate(consulta);  // el insert se usa con el executeUpdate
	//		s.close();
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
	public void eliminarCiclo(Ciclo c) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		try {
			
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// hacer un prepareStatement para insertar
			// los datos de ciclo c
			String consulta ="DELETE FROM CICLO "
					+ "WHERE ID = ?;";
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setInt(1, c.getId());
			ps.executeUpdate();
			con.commit();
			ps.close();
			
			// comprobar que no hay asignaturas de este ciclo
			// si las hay, habría que borrarlas en cascada antes de eliminar el ciclo
	
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
	public void modificarCiclo(Ciclo c) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		try {
			
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// hacer un prepareStatement para insertar
			// los datos de ciclo c
			String consulta ="UPDATE CICLO "
					+ "SET  NOMBRE= ?, GRADO = ? "
					+ "WHERE ID = ?;";
	
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getGrado());
			ps.setInt(3, c.getId());
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
	public void insertarCiclo(List<Ciclo> lista) {
		
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		PreparedStatement ps = null;
		try {
			
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// recorrer toda la lista de ciclos
			// hacer un prepareStatement para insertar
			// los datos de ciclo c
			
			for (Ciclo c: lista) {
				String consulta ="INSERT INTO CICLO "
						+ "(NOMBRE, GRADO) VALUES "
						+"(?,?);";
			
				ps = con.prepareStatement(consulta);
				
				ps.setString(1, c.getNombre());
				ps.setString(2, c.getGrado());
				ps.executeUpdate();
				
			}
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
	public void eliminarCiclo(List<Ciclo> lista) {
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		PreparedStatement ps = null;
		try {
			
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// recorrer toda la lista de ciclos
			// hacer un prepareStatement para insertar
			// los datos de ciclo c
			
			for (Ciclo c: lista) {
				String consulta ="DELETE FROM CICLO "
						+ "WHERE ID = ?;";
				ps = con.prepareStatement(consulta);
				ps.setInt(1, c.getId());
				ps.executeUpdate();
			}
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
	public void modificarCiclo(List<Ciclo> lista) {
		
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		PreparedStatement ps = null;
		try {
			
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// recorrer toda la lista de ciclos
			// hacer un prepareStatement para insertar
			// los datos de ciclo c
			
			for (Ciclo c: lista) {
				String consulta ="UPDATE CICLO "
						+ "SET  NOMBRE= ?, GRADO = ? "
						+ "WHERE ID = ?;";
				ps = con.prepareStatement(consulta);
				ps.setInt(3, c.getId());
				ps.setString(1, c.getNombre());
				ps.setString(2, c.getGrado());
				ps.executeUpdate();
				
			}
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
	public void crearCiclo(Ciclo c, List<Asignatura> lista) {
		
		Connection con= null;
		ConexionMySQL conMySQL = new ConexionMySQL();
		PreparedStatement ps = null;
		try {
			
			conMySQL.cargarDriver();
			con = conMySQL.crearConexion();
			con.setAutoCommit(false);  // Inicio de transaccion
			
			// recorrer toda la lista de asignaturas
			// hacer un prepareStatement para insertar
			// los datos de ciclo c en ciclo 
			// y de todas las asignaturas en asignatura

			//primero debo meter los datos de ciclo en ciclo
			// para que exista el id_ciclo de asignatura
			String consultaCiclo ="INSERT INTO CICLO "
					+ "(NOMBRE, GRADO) VALUES "
					+"(?,?);";
			ps = con.prepareStatement(consultaCiclo, Statement.RETURN_GENERATED_KEYS);
		
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getGrado());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();	// posicionado al principio
			
			rs.next();  // se posiciona en la primera posición, que es la que nos interesa
			for (Asignatura a: lista) {
				String consulta ="INSERT INTO ASIGNATURA "
						+ "(NOMBRE, HORAS_SEMANALES, ID_CICLO) VALUES "
						+"(?,?,?);";
			
				ps = con.prepareStatement(consulta);
		
				ps.setString(1, a.getNombre());
				ps.setInt(2, a.getHorasSemanales());
				// como id del ciclo al que pertenecen las asignaturas
				// recojo el valor de la clave creada anteriormente
				ps.setInt(3, rs.getInt(1));
				ps.executeUpdate();
			}
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

}
