package interfaces;

import Impl.es_lenguage;
import config.ConfigurationLoader;

public class inerfacesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationLoader.getConfig();
		//es_lenguage.getLanguage();
		pantallaLogin pC = new pantallaLogin();
		pC.setVisible(true);
	}	

}
