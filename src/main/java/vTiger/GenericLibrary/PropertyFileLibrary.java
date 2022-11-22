package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods to property file
 * @author Soumya
 *
 */
public class PropertyFileLibrary {
	
	/**
	 * This method will read the value from property file for the key given by user
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.propertyFilePath);
				Properties pobj = new Properties();
		        pobj.load(fis);
		        String value = pobj.getProperty(key);
		        return value;
	}

}
