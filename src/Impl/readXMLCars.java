package Impl;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import config.ConfigurationLoader;

public class readXMLCars {
	private String modeloCoche,modelomotor,accesorios;
	private int numModelos;
	public static void Espec13() {	
		try {
			File archivo = new File(ConfigurationLoader.getConfig().getCarConfigurationPath() + ConfigurationLoader.getConfig().getCarConfigurationFileName());
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);        	

			ArrayList<String> modelos2 = new ArrayList<String>();
			ArrayList<String> motores = new ArrayList<String>();
			ArrayList<String> accesorios = new ArrayList<String>();

			/*Rellenamos ArrayList de modelos*/
			for (int i = 0; i < document.getElementsByTagName("modelo").getLength(); i++) { 
				for (int j = 0; j < document.getElementsByTagName("modelo").item(0).getChildNodes().getLength(); j++) {
					if(j%2 != 0) {
						//System.out.println("dato -->" + document.getElementsByTagName("modelo").item(i).getChildNodes().item(j).getTextContent());
						modelos2.add( document.getElementsByTagName("modelo").item(i).getChildNodes().item(j).getTextContent());
					}
				}
			}	
			System.out.println("Lista de Modelos");
			System.out.println("----------------------------------------");			/*Recorremos y Printamos el Array de Modelos */
			for (int i = 0; i < modelos2.size(); i++) {
				System.out.println(modelos2.get(i));
			}

			/*Rellenamos ArrayList de Motores*/
			for (int i = 0; i < document.getElementsByTagName("motor").getLength(); i++) { 
				for (int j = 0; j < document.getElementsByTagName("motor").item(0).getChildNodes().getLength(); j++) {
					if(j%2 != 0) {
						//System.out.println("dato -->" + document.getElementsByTagName("modelo").item(i).getChildNodes().item(j).getTextContent());
						motores.add( document.getElementsByTagName("motor").item(i).getChildNodes().item(j).getTextContent());
					}
					
				}
			}	
			System.out.println("Lista de Motores");
			System.out.println("----------------------------------------");
			/*Recorremos y Printamos el Array de Motores */
			for (int i = 0; i < motores.size(); i++) {
				System.out.println(motores.get(i));
			}
			/*Rellenamos ArrayList de accesorios*/
			for (int i = 0; i < document.getElementsByTagName("accesorio").getLength(); i++) { 
				for (int j = 0; j < document.getElementsByTagName("accesorio").item(0).getChildNodes().getLength(); j++) {
					if(j%2 != 0) {
						//System.out.println("dato -->" + document.getElementsByTagName("modelo").item(i).getChildNodes().item(j).getTextContent());
						accesorios.add( document.getElementsByTagName("accesorio").item(i).getChildNodes().item(j).getTextContent());
					}
					
				}
			}
			System.out.println("Lista de Accesorios");
			System.out.println("----------------------------------------");
			/*Recorremos y Printamos el Array de Accesorios */
			for (int i = 0; i < accesorios.size(); i++) {
				System.out.println(accesorios.get(i));
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
