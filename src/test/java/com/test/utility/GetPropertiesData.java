package com.test.utility;

import java.io.FileReader;
import java.util.Properties;

public class GetPropertiesData {
	public static String getPropertyValue(String key) {
		try {
			Properties properties = new Properties();
			properties
					.load(new FileReader(System.getProperty("user.dir") + "/src/test/resources/config/URL.properties"));
			return properties.getProperty(key);
		} catch (Exception e) {
			System.out.println("Config file not found");
			e.printStackTrace();
			return null;
		}
	}
}
