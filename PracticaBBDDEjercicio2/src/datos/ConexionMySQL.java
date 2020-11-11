package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements IConexion {

	@Override
	public void cargarDriver() throws ClassNotFoundException {
	
		Class.forName("org.mariadb.jdbc.Driver");
		
	} //cargarDriver	
	
	public   Connection crearConexion() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/ciclosaulanosa";
		String usuario = "root";
		String pass ="";
		Connection c = DriverManager.getConnection(url, usuario, pass);
		return c;
		
	}//crearConexion

	public void cerrarConexion(Connection c) throws SQLException {
		
		c.close();
		
	}//cerrarConexion


}
