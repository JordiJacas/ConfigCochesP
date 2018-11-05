package interfaces;

import Impl.LenguageLoader;
import config.ConfigurationLoader;

public class inerfacesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurationLoader.getConfig();
		LenguageLoader.getLenguageConfig();
		pantallaLogin pC = new pantallaLogin();
		pC.setVisible(true);
	}	

}
