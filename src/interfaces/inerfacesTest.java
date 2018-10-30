package interfaces;

import config.ConfigurationLoader;

public class inerfacesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationLoader.getConfig();
		pantallaLogin pC = new pantallaLogin();
		pC.setVisible(true);
	}

}
