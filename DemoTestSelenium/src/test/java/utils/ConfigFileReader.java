package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propFilePath = "./src/test/java/config/Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration file not found an " + propFilePath);
		}
	}

	public String getSpecificUrlProperties(String configRequest) {
		String requestOutput = properties.getProperty(configRequest);
		if (requestOutput != null)
			return requestOutput;
		else
			throw new RuntimeException("Request not found in Configuration file at " + propFilePath);
	}

}
