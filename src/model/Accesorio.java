package model;

public class Accesorio {
	private int id;
	private String nombre;
	private String Descripcion;
	private String imagen_nombre;
	private int precio; 
	private int modelos_disponibles;
	private String type;
	
	
	
	public Accesorio(int id, String nombre, String descripcion, String imagen_nombre, int precio,int modelos_disponibles, String type) {
		this.id = id;
		this.nombre = nombre;
		this.Descripcion = descripcion;
		this.imagen_nombre = imagen_nombre;
		this.precio = precio;
		this.modelos_disponibles = modelos_disponibles;
		this.type = type;
	}
	
	public int getModelos_disponibles() {
		return modelos_disponibles;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public String getImagen_nombre() {
		return imagen_nombre;
	}

	public int getPrecio() {
		return precio;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Accesorios [id=" + id + ", nombre=" + nombre + ", Descripcion=" + Descripcion + ", imagen_nombre="
				+ imagen_nombre + ", precio=" + precio + ", modelos_disponibles=" + modelos_disponibles + "]";
	}
}
