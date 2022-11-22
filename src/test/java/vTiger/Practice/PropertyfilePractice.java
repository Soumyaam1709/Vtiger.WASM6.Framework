package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyfilePractice {

	public static void main(String[] args) throws IOException {
		
		//load the file into java stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//create  object of properties
		Properties pobj = new Properties();
		
		//load the file input stream into properties
		pobj.load(fis);
		
		//use the keys to read the value
		String BROWSER = pobj.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = pobj.getProperty("url");
		System.out.println(URL);

	}

}
