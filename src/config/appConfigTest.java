package config;

public class appConfigTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for (boolean employee: ConfigurationLoader.getConfig().getEmployeeVersion()) {
            System.out.println(employee);
        }*/
		//System.out.println(ConfigurationLoader.getConfig().getVersion());
		System.out.println(ConfigurationLoader.getConfig().getLanguage_default());
		System.out.println(ConfigurationLoader.getConfig().getLanguage_file_path());
		System.out.println(ConfigurationLoader.getConfig().getPostfix_language_file_name());
		
		for (String employee: ConfigurationLoader.getConfig().getLanguages()) {
        	System.out.println(employee);
    	}
	}

}
