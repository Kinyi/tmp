package kinyi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
	public static void main(String[] args) {
		TestConfig loadProp = new TestConfig();
		InputStream in = loadProp.getClass().getResourceAsStream("/config/a.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
	}
}
