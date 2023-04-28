package objectHandler;

import configReader.ConfigReader;

public class ObjectHandler {
	ConfigReader cr = new ConfigReader();
	
	public void getUrl() {
		cr.getUrl();
	}
	
	public void enterUsername(String username) {
		cr.getUsername(username);
	}
	
	public void enterPassword(String password) {
		cr.getPassword(password);
	}
	
	
}
