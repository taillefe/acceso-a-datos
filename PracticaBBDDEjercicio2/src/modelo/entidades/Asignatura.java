package modelo.entidades;

public class Asignatura {
	
	int id ;
	String nombre;
	int horasSemanales;
	int idCiclo;
	
	public Asignatura(int id, String nombre, int horasSemanales, int idCiclo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horasSemanales = horasSemanales;
		this.idCiclo = idCiclo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHorasSemanales() {
		return horasSemanales;
	}
	public void setHorasSemanales(int horasSemanales) {
		this.horasSemanales = horasSemanales;
	}
	public int getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}
	
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", horasSemanales=" + horasSemanales + ", idCiclo="
				+ idCiclo + "]";
	}
	
	
	

}
