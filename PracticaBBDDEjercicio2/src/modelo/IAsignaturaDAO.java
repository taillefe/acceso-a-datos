package modelo;

import java.util.List;

import modelo.entidades.Asignatura;

public interface IAsignaturaDAO {
	
	public void insertarAsignatura(Asignatura a); 
	public void eliminarAsignatura(Asignatura a);
	public void modificarAsignatura(Asignatura a);
	
	public void insertarAsignatura(List<Asignatura> l); 
	public void eliminarAsignatura(List<Asignatura> l);
	public void modificarAsignatura(List<Asignatura> l);
		
	

}
