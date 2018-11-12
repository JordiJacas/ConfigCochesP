package Impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import config.ConfigurationLoader;
import idao.IConfig;
import model.Accesorio;
import model.Modelo;
import model.SubModelo;
import sun.applet.Main;

public class readXMLCars implements IConfig {
	private int id;
	private String nombre;
	private String descripcion;
	private int caballos;
	private int puertas;
	private String tipo;
	private String imagen_nombre;
	private int precio;
	private int modelos_disponibles;
	private int attribModelo;
	private String attribType;
	
	public Document readXMLCars() {	
		try {
			File archivo = new File(ConfigurationLoader.getConfig().getCarConfigurationPath() + ConfigurationLoader.getConfig().getCarConfigurationFileName());
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			
			return document;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Modelo> readModelos(){
		Document document = readXMLCars();
		ArrayList<Modelo> vehiculos = new ArrayList<Modelo>();

		/*Rellenamos ArrayList de modelos*/
		for (int i = 0; i < document.getElementsByTagName("modelo").getLength(); i++) {
			for (int j = 0; j < document.getElementsByTagName("modelo").item(0).getChildNodes().getLength(); j++) {	
				id = Integer.parseInt(document.getElementsByTagName("modelo").item(i).getChildNodes().item(1).getTextContent());
				nombre = document.getElementsByTagName("modelo").item(i).getChildNodes().item(3).getTextContent();
				descripcion = document.getElementsByTagName("modelo").item(i).getChildNodes().item(5).getTextContent();
				imagen_nombre = document.getElementsByTagName("modelo").item(i).getChildNodes().item(7).getTextContent();
				precio = Integer.parseInt(document.getElementsByTagName("modelo").item(i).getChildNodes().item(9).getTextContent());	
			}
			vehiculos.add(new Modelo(id,nombre,descripcion,imagen_nombre,precio));
		}
		
		return vehiculos;
	}
	
	public ArrayList<SubModelo> readSubModelos(){
		Document document = readXMLCars();
		ArrayList<SubModelo> vehiculos = new ArrayList<SubModelo>(); 
		
		/*Rellenamos ArrayList de Motores*/
	 	for (int i = 0; i < document.getElementsByTagName("motor").getLength(); i++) { 
			for (int j = 0; j < document.getElementsByTagName("motor").item(0).getChildNodes().getLength(); j++) {
				id = Integer.parseInt(document.getElementsByTagName("motor").item(i).getChildNodes().item(1).getTextContent());
				nombre = document.getElementsByTagName("motor").item(i).getChildNodes().item(3).getTextContent();
				caballos = Integer.parseInt(document.getElementsByTagName("motor").item(i).getChildNodes().item(5).getTextContent());
				puertas = Integer.parseInt(document.getElementsByTagName("motor").item(i).getChildNodes().item(7).getTextContent());
				tipo = document.getElementsByTagName("motor").item(i).getChildNodes().item(9).getTextContent();
				imagen_nombre = document.getElementsByTagName("motor").item(i).getChildNodes().item(11).getTextContent();
				precio = Integer.parseInt(document.getElementsByTagName("motor").item(i).getChildNodes().item(13).getTextContent());
				attribModelo = Integer.parseInt(document.getElementsByTagName("motor").item(i).getAttributes().item(0).getTextContent());
				attribType = document.getElementsByTagName("motor").item(i).getAttributes().item(1).getTextContent();
				
			}
			vehiculos.add(new SubModelo(id,nombre,caballos,puertas,tipo,imagen_nombre,precio, attribModelo, attribType));
		}
	 	
	 	
	 	
	 	return vehiculos;
	}
	
	
	public ArrayList<Accesorio> readAccesorios(){
		Document document = readXMLCars();
		ArrayList<Accesorio> vehiculos = new ArrayList<Accesorio>();
		
		/*Rellenamos ArrayList de accesorios*/
		for (int i = 0; i < document.getElementsByTagName("accesorio").getLength(); i++) { 
			for (int j = 0; j < document.getElementsByTagName("accesorio").item(0).getChildNodes().getLength(); j++) {
				id = Integer.parseInt(document.getElementsByTagName("accesorio").item(i).getChildNodes().item(1).getTextContent());
				nombre = document.getElementsByTagName("accesorio").item(i).getChildNodes().item(3).getTextContent();
				descripcion = document.getElementsByTagName("accesorio").item(i).getChildNodes().item(5).getTextContent();
				imagen_nombre = document.getElementsByTagName("accesorio").item(i).getChildNodes().item(7).getTextContent();
				precio = Integer.parseInt(document.getElementsByTagName("accesorio").item(i).getChildNodes().item(9).getTextContent());
				modelos_disponibles= Integer.parseInt(document.getElementsByTagName("accesorio").item(i).getChildNodes().item(11).getTextContent());
				attribType = document.getElementsByTagName("accesorio").item(i).getAttributes().item(0).getTextContent();
			}
			vehiculos.add(new Accesorio(id,nombre,descripcion,imagen_nombre,precio,modelos_disponibles, attribType));
		}
		return vehiculos;
	}
}