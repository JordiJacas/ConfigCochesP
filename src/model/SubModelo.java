package model;

public class SubModelo {
	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private int precio;
	private int modelo;
	private String type;
	
	/*
	 * Construcor
	 */
	public SubModelo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubModelo(int id, String nombre, String descripcion, String imagen, int precio, int modelo, String type) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.modelo = modelo;
		this.type = type;
	}
	
	/*
	 * Metodos
	 */
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public int getPrecio() {
		return precio;
	}
		
	public int getModelo() {
		return modelo;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return nombre + " | " + descripcion + " | " + precio;
	}
	
	
	
	
	
}
