package modelo;

import java.util.List;

import modelo.entidades.Asignatura;
import modelo.entidades.Ciclo;

public interface ICicloDAO {
	
	public void insertarCiclo(Ciclo c); 
	public void eliminarCiclo(Ciclo c);
	public void modificarCiclo(Ciclo c);
	
	public void insertarCiclo(List<Ciclo> l); 
	public void eliminarCiclo(List<Ciclo> l);
	public void modificarCiclo(List<Ciclo> l);
	
	// crea el ciclo con sus asignaturas, si falla la insercion del ciclo
	// tampoco se insertan las asignaturas
	// por tanto este metodo usará insertarCiclo(c) e insertarAsignatura(l)
	public void crearCiclo(Ciclo c, List<Asignatura> l);
		
}
