package datos;

import java.sql.Connection;
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
		try {
			CargarDriver();
			con = crearConexion();
			
			// hacer un prepareStatement para insertar
			// los datos de ciclo c
			String consulta ="INSERT INTO CLIENTES "
					+ "(DNI, APELLIDOS, CP) VALUES "
					+ "('78945612A','NADAL','15009'),"
					+ "('58945612B','DJOKOVIC','15008'),"
					+ "('68945612','FEDERER','15007'),"
					+ "('38945612A','MURRAY','15006');";
			Statement s= con.createStatement();
			s.executeUpdate(consulta);  // el insert se usa con el executeUpdate
			s.close();
		}catch (ClassNotFoundException ex) {
			System.out.println("Error al cargar el driver de la bbdd");
			ex.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
		}finally {
			try {
				if(con!=null && !con.isClosed())
					cerrarConexion(con);
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
		
	}
		
	}

	@Override
	public void eliminarCiclo(Ciclo c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCiclo(Ciclo c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertarCiclo(List<Ciclo> l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCiclo(List<Ciclo> l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarCiclo(List<Ciclo> l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearCiclo(Ciclo c, List<Asignatura> l) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	/*
	
	insertarCiclo(Ciclo c, Conexion con)
	if (con == null) {
		new Conexion()
	}
	
	insertarCiclo(Ciclo c){
		insertarCiclo(c,null)
		
	}
	
	insertarTrans(ciclo c, listado asig){
		con c=
				insertarCiclo(c,con)
	}
	
	*/
}
