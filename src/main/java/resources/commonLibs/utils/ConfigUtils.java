package resources.commonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
	
	public static Properties readProperties(String filename) throws Exception {
		
		filename = filename.trim();
		
		InputStream fInputStream = new FileInputStream(filename);
		
		Properties properties = new Properties();
		
		properties.load(fInputStream);
		
		return properties;
	}

}
