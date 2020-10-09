package persona;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable
{
	private String nombre;
	private String apellidos;
	private LocalDate fecha;
	
	public Persona(String nombre, String apellidos, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", fecha=" + fecha + "]";
	}
	
	
}

/*
ObjectOutputStream os = new ObjectOutputStream (bs);
os.writeObject(unObjetoSerializable);  // this es de tipo DatoUdp
os.close();

ObjectInputStream is = new ObjectInputStream(bs);
ClaseSerializable unObjetoSerializable = (ClaseSerializable)is.readObject();
is.close();


*/