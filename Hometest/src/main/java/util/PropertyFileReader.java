package util;

import java.util.*;
import java.io.*;

public class PropertyFileReader {
	
	protected static Properties property;
	protected static FileReader filereader;
	private static String targetPlatform;
	private static String targetDevice;

	// To load the property file based on the system properties

	public static void loadPropertyFile() throws IOException {
		PropertyFileReader.property = new Properties();
		PropertyFileReader.targetPlatform = System.getProperty("targetPlatform");
		PropertyFileReader.targetDevice = System.getProperty("targetDevice");

		// Load the property file based on platform and device

		if (PropertyFileReader.targetPlatform.equalsIgnoreCase("android")) {
			final File file = new File(String.valueOf(System.getProperty("user.dir"))
					+ "\\src\\main\\resources\\testdata\\" + PropertyFileReader.targetPlatform + "\\"
					+ PropertyFileReader.targetDevice + "\\capabilities.properties");
			PropertyFileReader.filereader = new FileReader(file);
			PropertyFileReader.property.load(PropertyFileReader.filereader);
		}

		if (PropertyFileReader.targetPlatform.equalsIgnoreCase("iOS")) {
			// To do in case of iOS
		}
	}

	// To retrieve value from property file
	public static String getString(final String value) {
		return PropertyFileReader.property.getProperty(value);
	}
}