import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

public class PersistenciaBBDD {
	
	
	public static void main(String[] args) {
	
	
		try {
			CargarDriver();
			Connection c= obtenerConexion();
			System.out.println (c);
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private static void CargarDriver() throws ClassNotFoundException {
		
		Class.forName("org.mariadb.jdbc.Driver");
		
	} //CargarDriver	
 //



public static Connection obtenerConexion() throws SQLException {
	
	String url = "jdbc:mysql://localhost:3306/EjercicioBBD";
	String usuario = "root";
	String pass ="";
	Connection c = DriverManager.getConnection(url, usuario, pass);
	return c;
}//obtenerConexion
}
