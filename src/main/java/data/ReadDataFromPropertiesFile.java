package data;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;



public class ReadDataFromPropertiesFile 
{

	public static String readFromPropertyFile(String key) throws IOException
	{
		FileInputStream fi = new FileInputStream("./TestDataFiles/common.properties");
		Properties p = new Properties();
		p.load(fi);
		String value = p.getProperty(key);
		return value;
	}

}
