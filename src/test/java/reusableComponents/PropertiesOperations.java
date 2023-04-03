package reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {

	public static String getProperty(String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/test/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
}
