package model;

public class SubModelo {
	private int id;
	private String nombre;
	private int caballos;
	private int puertas;
	private String combustible;
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
	public SubModelo(int id, String nombre, int caballos, int puertas, String combustible, String imagen, int precio, int modelo, String type) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.caballos = caballos;
		this.puertas = puertas;
		this.combustible = combustible;
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
	
	public int getCaballos() {
		return caballos;
	}
	
	public int getPuertas() {
		return puertas;
	}
	
	public String getCombustible() {
		return combustible;
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
		return nombre + " | " + caballos + " CV | " + puertas + " puertas | " + combustible + " | " + precio;
	}
	
	public String toSave() {
		return nombre + ";" + caballos + " CV;" + puertas + " puertas;" + combustible + ";" + precio;
	}
	
	
	
	
	
}
