package configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private final String propFilePath = "./configs/Configuration.";

	public ConfigReader() {
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(propFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration file not found an " + propFilePath);
		}
	}
	
	public String getUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("Url not found in Configuration file at " + propFilePath);
	}
	
	public String getUsername(String propUsername) {
		String username = properties.getProperty(propUsername);
		if(username != null) return username;
		else throw new RuntimeException("Username not found in Configuration file at " + propFilePath);
	}
	
	public String getPassword(String propPassword) {
		String password = properties.getProperty(propPassword);
		if(password != null) return password;
		else throw new RuntimeException("Password not found in Configuration file at " + propFilePath);
	}
	

}
