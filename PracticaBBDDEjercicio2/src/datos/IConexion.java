package datos;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexion {
	
	public void cargarDriver() throws ClassNotFoundException;
	public Connection crearConexion() throws SQLException;
	public void cerrarConexion(Connection c) throws SQLException;

}
