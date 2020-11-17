package vista.presentacion;

import java.util.List;

import modelo.entidades.Asignatura;

public class CicloVO {

	int id;
	String nombre;
	String grado;
	
	private List<AsignaturaVO> listaAsignaturasVO;
	
	//constructor vacío
	public CicloVO() {
		
	}

	public CicloVO(int id, String nombre, String grado, List<AsignaturaVO> listaAsignaturasVO) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.grado = grado;
		this.listaAsignaturasVO = listaAsignaturasVO;
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

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public List<AsignaturaVO> getListaAsignaturasVO() {
		return listaAsignaturasVO;
	}

	public void setListaAsignaturasVO(List<AsignaturaVO> listaAsignaturasVO) {
		this.listaAsignaturasVO = listaAsignaturasVO;
	}

	@Override
	public String toString() {
		return "CicloVO [id=" + id + ", nombre=" + nombre + ", grado=" + grado + ", listaAsignaturasVO="
				+ listaAsignaturasVO + "]";
	}
	
	
	
	
	
}
