package config;

public class appConfigTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for (boolean employee: AppConfiguration.getConfig().getEmployeeVersion()) {
            System.out.println(employee);
        }*/
		System.out.println(ConfigurationLoader.getConfig().getVersion());
	}

}
