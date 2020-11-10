import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;

public class PersistenciaBBDD {
	
	
	public static void main(String[] args) {
	
		PersistenciaBBDD per= new PersistenciaBBDD();  // para orientación a objetos tengo que crear el objeto
														// antes de llamar al método
		per.CrearTablaClientes();
	//	PersistenciaBBDD.CrearTablaClientes();
		
	//prepareStatement -- por seguridad para que no metan codigo embebido,
		//se usa en lugar de statement en los updates
		// y la consulta es más rápida para muchas consultas
		
	}
	
	public  void CrearTablaClientes() {
		Connection c= null;
		try {
			CargarDriver();
			c= obtenerConexion();
			System.out.println (c);
			String consulta ="CREATE TABLE CLIENTES "
					+ "(DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), "
					+ "PRIMARY KEY(DNI))";
			Statement s= c.createStatement();
			s.execute(consulta);  // el create se usa con el execute
			s.close();
		}catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver de la bbdd");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en la ejecución de la consulta");
			e.printStackTrace();
		}finally {
			try {
				if(c!=null && !c.isClosed())
					c.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
		
	}
	
	public void InsertarClientes() {
		Connection c= null;
		try {
			CargarDriver();
			c= obtenerConexion();
			String consulta ="INSERT INTO CLIENTES "
					+ "(DNI, APELLIDOS, CP) VALUES "
					+ "('78945612A','NADAL','15009'),"
					+ "('58945612B','DJOKOVIC','15008'),"
					+ "('68945612','FEDERER','15007'),"
					+ "('38945612A','MURRAY','15006');";
			Statement s= c.createStatement();
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
				if(c!=null && !c.isClosed())
					c.close();
			}catch (SQLException e) {
				System.out.println("Error al cerrar la conexión");
			}
		}
		
	}
	
	private  void CargarDriver() throws ClassNotFoundException {
		
		Class.forName("org.mariadb.jdbc.Driver");
		
	} //CargarDriver	
 //



public   Connection obtenerConexion() throws SQLException {
	
	String url = "jdbc:mysql://localhost:3306/EjercicioBBD";
	String usuario = "root";
	String pass ="";
	Connection c = DriverManager.getConnection(url, usuario, pass);
	return c;
}//obtenerConexion
}
