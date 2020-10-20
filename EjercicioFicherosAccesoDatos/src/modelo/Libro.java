package modelo;

public class Libro {
	
	String marca;
	String modelo;
	String color;
	String matrícula;
	int anoFabricacion;
	
	public Libro(String marca, String modelo, String color, String matrícula, int anoFabricacion) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.matrícula = matrícula;
		this.anoFabricacion = anoFabricacion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMatrícula() {
		return matrícula;
	}
	public void setMatrícula(String matrícula) {
		this.matrícula = matrícula;
	}
	public int getAnoFabricacion() {
		return anoFabricacion;
	}
	public void setAnoFabricacion(int anoFabricacion) {
		this.anoFabricacion = anoFabricacion;
	}
	@Override
	public String toString() {
		return "Libro [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", matrícula=" + matrícula
				+ ", anoFabricacion=" + anoFabricacion + "]";
	}
	
	

}
