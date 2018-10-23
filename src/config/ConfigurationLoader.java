package config;

import java.io.File;

public class ConfigurationLoader {
	
	private static ConfigurationLoader appConfig; 
	private String car_configuration_path;
	private String car_configuration_file_name;
	private String[] employee_list;
	private String[] employee_password;
	private String specifications_file_path;
	private String version;
	private boolean[] employee_version;
	private configXmlFile xml;
	
	public String getCarConfigurationPath() {
		return car_configuration_path;
	}
	
	public String getCarConfigurationFileName() {
		return car_configuration_file_name;
	}
	
	public String[] getEmployeeList() {
		return employee_list;
	}
	
	public String[] getEmployeePassword() {
		return employee_password;
	}
	
	public String getSpecificationFilePath() {
		return specifications_file_path;
	}
	
	public String getVersion() {
		return version;
	}
	
	public boolean[] getEmployeeVersion() {
		return employee_version;
	}
	
	private ConfigurationLoader() {
		car_configuration_path = loadCarPath();	
		car_configuration_file_name = loadCarName();
		employee_list = loadEmployeeList();
		employee_password = loadEmployeePassword();
		specifications_file_path = loadSpecificationFilePath();
		version = loadVersion();
		employee_version = loadEmployeeVersion();
		
	}

	private String loadCarPath() {
		xml = new configXmlFile();
		return xml.CarpPath();
	}
	
	private String loadCarName() {
		xml = new configXmlFile();
		return xml.EmployeeList();
	}
	
	private String[] loadEmployeeList() {
		xml = new configXmlFile();
		String employees = xml.EmployeeList();
		String[] aEmployees = employees.split(","); 
		return aEmployees;
	}
	
	private String[] loadEmployeePassword() {
		xml = new configXmlFile();
		String password = xml.EmployeePassword();
		String[] aPassword = password.split(","); 
		return aPassword;
	}
	
	private String loadSpecificationFilePath() {
		xml = new configXmlFile();
		return xml.SpecificationsPath();
	}

	private String loadVersion() {
		xml = new configXmlFile();
		
		return xml.version();
	}
	
	private boolean[] loadEmployeeVersion() {
		xml = new configXmlFile();
		String versions = xml.employeeVersion();
		String[] sVersion = versions.split(",");
		
		boolean[] bVersion = new boolean[sVersion.length];
		for (int i = 0; i < sVersion.length; i++) {
			bVersion[i] = Boolean.parseBoolean(sVersion[i]);
		}
		return bVersion;
	}
	public static ConfigurationLoader getConfig() {
		if (appConfig == null) {
			appConfig = new ConfigurationLoader();
		}
		
		return appConfig;
	}
}
