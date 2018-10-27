package Impl;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import idao.IConfig;

public class configXmlFile implements IConfig{
	
	private Document configXmlFile() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("src\\recursos\\cv_config.xml"));
			doc.getDocumentElement().normalize();
			
			return doc;
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String CarpPath() {
		configXmlFile r = new configXmlFile();
		Document doc = r.configXmlFile();
		
		String path = doc.getElementsByTagName("car_configuration_path").item(0).getTextContent();
		
		return path;
	}
	
	public String CarFileName() {
		configXmlFile r = new configXmlFile();
		Document doc = r.configXmlFile();
		String fileName = doc.getElementsByTagName("car_configuration_file_name").item(0).getTextContent();
		
		return fileName;
	}
	
	public String EmployeeList() {
		configXmlFile r = new configXmlFile();
		Document doc = r.configXmlFile();
		String employeesNames = doc.getElementsByTagName("employee_list").item(0).getTextContent();
		
		return employeesNames;
	}
	
	public String EmployeePassword() {
		configXmlFile r = new configXmlFile();
		Document doc = r.configXmlFile();
		String employeesPass = doc.getElementsByTagName("employee_password").item(0).getTextContent();
		
		return employeesPass;
	}
	
	public String SpecificationsPath() {
		configXmlFile r = new configXmlFile();
		Document doc = r.configXmlFile();
		String sPath = doc.getElementsByTagName("specifications_file_path").item(0).getTextContent();
		
		return sPath;
	}
	
	public String version() {
		configXmlFile r = new configXmlFile();
		Document doc = r.configXmlFile();
		String v = doc.getElementsByTagName("version").item(0).getTextContent();
		
		return v;
	}
	
	public String employeeVersion() {
		configXmlFile r = new configXmlFile();
		Document doc = r.configXmlFile();
		String eVersion = doc.getElementsByTagName("employee_version").item(0).getTextContent();
		
		return eVersion;
	}
	
}
