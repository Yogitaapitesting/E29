package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public String togetDatafromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}
}
