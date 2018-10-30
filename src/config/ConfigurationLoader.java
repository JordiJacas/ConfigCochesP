package config;

import java.io.File;

import Impl.configXmlFile;

public class ConfigurationLoader {
	
	private static ConfigurationLoader appConfig;
	private String[] languages;
	private String language_default;
	private String postfix_language_file_name;
	private String language_file_path;
	private String car_configuration_path;
	private String car_configuration_file_name;
	private String[] employee_list;
	private String[] employee_password;
	private String specifications_file_path;
	private String version;
	private boolean[] employee_version;
	private configXmlFile xml = new configXmlFile();
	
	
	public String[] getLanguages() {
		return languages;
	}

	public String getLanguage_default() {
		return language_default;
	}

	public String getPostfix_language_file_name() {
		return postfix_language_file_name;
	}

	public String getLanguage_file_path() {
		return language_file_path;
	}

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
		languages = loadLanguages();
		language_default = loadLanguageDefault();
		postfix_language_file_name = loadPostfixLanguage();
		language_file_path = loadLanguagePath();
		
	}

	private String loadLanguagePath() {
		return xml.languagePath();
	}

	private String loadPostfixLanguage() {
		return xml.postfixLanguage();
	}

	private String loadLanguageDefault() {
		return xml.languagesDefault();
	}

	private String[] loadLanguages() {
		String languages = xml.languages();
		String[] aLanguages = languages.split(","); 
		return aLanguages;
	}

	private String loadCarPath() {
		return xml.CarpPath();
	}
	
	private String loadCarName() {
		return xml.CarFileName();
	}
	
	private String[] loadEmployeeList() {
		String employees = xml.EmployeeList();
		String[] aEmployees = employees.split(","); 
		return aEmployees;
	}
	
	private String[] loadEmployeePassword() {
		String password = xml.EmployeePassword();
		String[] aPassword = password.split(","); 
		return aPassword;
	}
	
	private String loadSpecificationFilePath() {
		return xml.SpecificationsPath();
	}

	private String loadVersion() {
		return xml.version();
	}
	
	private boolean[] loadEmployeeVersion() {
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
