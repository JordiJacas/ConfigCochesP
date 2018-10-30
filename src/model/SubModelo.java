package model;

public class SubModelo {
	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private int precio;
	
	/*
	 * Construcor
	 */
	public SubModelo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubModelo(int id, String nombre, String descripcion, String imagen, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
	}
	
	/*
	 * Metodos
	 */
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return nombre + " | " + descripcion + " | " + precio;
	}
	
	
	
	
	
}
