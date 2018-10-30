package model;

public class Accesorio {
	private int id;
	private String nombre;
	private String Descripcion;
	private String imagen_nombre;
	private int precio; 
	private int modelos_disponibles;
	
	
	
	public Accesorio(int id, String nombre, String descripcion, String imagen_nombre, int precio,int modelos_disponibles) {
		this.id = id;
		this.nombre = nombre;
		this.Descripcion = descripcion;
		this.imagen_nombre = imagen_nombre;
		this.precio = precio;
		this.modelos_disponibles = modelos_disponibles;
	}
	public int getModelos_disponibles() {
		return modelos_disponibles;
	}
	public void setModelos_disponibles(int modelos_disponibles) {
		this.modelos_disponibles = modelos_disponibles;
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
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getImagen_nombre() {
		return imagen_nombre;
	}
	public void setImagen_nombre(String imagen_nombre) {
		this.imagen_nombre = imagen_nombre;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Accesorios [id=" + id + ", nombre=" + nombre + ", Descripcion=" + Descripcion + ", imagen_nombre="
				+ imagen_nombre + ", precio=" + precio + ", modelos_disponibles=" + modelos_disponibles + "]";
	}
}
