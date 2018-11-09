package Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class createXMLFactura {
	private ArrayList<String> aFile;
	private File fResum;
	private FileReader fr;
	private BufferedReader br;

	public void crearFactura() {
		CrearXMLPresupuestos();
		rellenarXML();
	}

	private void CrearXMLPresupuestos() {
		aFile = new ArrayList<String>();
		String linea;

		try {
			fResum = new File("src\\files_temp\\fs_employee.txt");
			fr = new FileReader (fResum);
			br = new BufferedReader(fr);

			while((linea=br.readLine())!=null) {
				aFile.add(linea);
			}
			fr.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void rellenarXML() {
		// Aqui contenemos los elementos de la primera linea 
		String partes = aFile.get(1);
		String[] parte = partes.split(";"); 

		// Aqui contenemos los elementos de la segunda  linea
		String partes2 = aFile.get(2);
		String[] parte2 = partes2.split(";");

		// Aqui contenemos los elementos de la tercera  linea
		String partes3 = aFile.get(3);
		String[] parte3 = partes3.split(";");

		// Aqui contenemos los elementos de la cuarta  linea
		String partes4 = aFile.get(4);
		String[] parte4 = partes4.split(";");

		try {
			DocumentBuilderFactory dbFactory =
					DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			/*Primera Linea*/
			
			Element raiz = doc.createElement("factura");
			doc.appendChild(raiz);
			
			Element cliente = doc.createElement("Cliente");
			
			// tag nombre
			Element name = doc.createElement("nombre");
			name.appendChild(doc.createTextNode(parte[0]));
			cliente.appendChild(name);

			// tag primer apellido 
			Element surname = doc.createElement("Primer_Apellido");
			surname.appendChild(doc.createTextNode(parte[1]));
			cliente.appendChild(surname);

			// tag segundo apellido 
			Element surname2 = doc.createElement("Segundo_Apellido");
			surname2.appendChild(doc.createTextNode(parte[2]));
			cliente.appendChild(surname2);

			// tag Direccion  
			Element direccion = doc.createElement("Direccion");
			direccion.appendChild(doc.createTextNode(parte[3]));
			cliente.appendChild(direccion);

			// tag Correo Electronico   
			Element correo = doc.createElement("Email");
			correo.appendChild(doc.createTextNode(parte[4]));
			cliente.appendChild(correo);

			// tag Genero  
			Element gender = doc.createElement("Genero");
			gender.appendChild(doc.createTextNode(parte[5]));
			cliente.appendChild(direccion);

			// tag Fecha de Nacimiento   
			Element date_birth = doc.createElement("Fecha_Nacimiento");
			date_birth.appendChild(doc.createTextNode(parte[6]));
			cliente.appendChild(date_birth);
			
			raiz.appendChild(cliente);

			/*Segunda Linea */
			Element modelo = doc.createElement("Modelo");
			
			// tag id   
			Element idModelo = doc.createElement("ID");
			idModelo.appendChild(doc.createTextNode(parte2[0]));
			modelo.appendChild(idModelo);
			
			// tag Marca Modelo   
			Element nombreModelo = doc.createElement("Nombre");
			nombreModelo.appendChild(doc.createTextNode(parte2[1]));
			modelo.appendChild(nombreModelo);
			
			raiz.appendChild(modelo);

			/*Tercera Linea */
			Element submodelo = doc.createElement("SubModelo");
			
			//tag SubModelo
			Element nombreSubmodelo = doc.createElement("Nombre");
			nombreSubmodelo.appendChild(doc.createTextNode(parte3[0]));
			submodelo.appendChild(nombreSubmodelo);

			//tag Caballos de Potencia 
			Element potencia = doc.createElement("Caballos");
			potencia.appendChild(doc.createTextNode(parte3[1]));
			submodelo.appendChild(potencia);

			//tag Puertas 
			Element puertas = doc.createElement("Puertas");
			puertas.appendChild(doc.createTextNode(parte3[2]));
			submodelo.appendChild(puertas);

			//tag Tipo de Motor 
			Element tipo_motor = doc.createElement("motor");
			tipo_motor.appendChild(doc.createTextNode(parte3[3]));
			submodelo.appendChild(tipo_motor);

			//tag Precio 
			Element precio = doc.createElement("Precio");
			precio.appendChild(doc.createTextNode(parte3[4]));
			submodelo.appendChild(precio);
			
			raiz.appendChild(submodelo);

			/*Cuarta Linea*/
			
			//tag Precio Accesorios
			Element precio_accesorios = doc.createElement("precio_accesorios");
			precio_accesorios.appendChild(doc.createTextNode(parte4[1]));
			
			//tag Accesorios Equipados
			Element accesorios = doc.createElement("Accesorios");
			
			//Añadimos los accessorios seleccionados por el cliente al xml
			for (int i = 3; i < parte4.length; i++) {
				Element eAccesorio = doc.createElement("Accesorio");
				
				String[] accesorio = parte4[i].split(":");
				Element nombreAccesorio = doc.createElement("Nombre");
				nombreAccesorio.appendChild(doc.createTextNode(accesorio[0]));
				
				Element precioAccesorio = doc.createElement("Precio");
				precioAccesorio.appendChild(doc.createTextNode(accesorio[1]));
				
				eAccesorio.appendChild(nombreAccesorio);
				eAccesorio.appendChild(precioAccesorio);
				
				accesorios.appendChild(eAccesorio);
				
			}
			
			accesorios.appendChild(precio_accesorios);
			raiz.appendChild(accesorios);
			
			//tag Precio Final 
			Element precio_final = doc.createElement("Precio_Final");
			precio_final.appendChild(doc.createTextNode(parte4[2]));
			raiz.appendChild(precio_final);

			// Escribimos en el archivo xml 
			TransformerFactory transformerFactory =TransformerFactory.newInstance();
			Transformer transformer =transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result =new StreamResult(new File("src\\files_temp\\fs_employee.xml"));
			transformer.transform(source, result);
			// Output to console for testing
			StreamResult consoleResult =new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
