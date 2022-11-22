package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;

import vTiger.GenericLibrary.PropertyFileLibrary;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException {
		
		JavaLibrary jLib = new JavaLibrary();
		
	   String date = jLib.getSystemDate();

	   System.out.println(date);
	   
	   String date1= jLib.getSystemDateInFormat();
	   
	   System.out.println(date1);
	   
	   PropertyFileLibrary pLib = new PropertyFileLibrary();
	   
	   String value1 = pLib.readDataFromPropertyFile("browser");
	   
	   System.out.println(value1);
	   
	   String value2 =  pLib.readDataFromPropertyFile("username");
	   
	   System.out.println(value2);
	   
	   String value3= pLib.readDataFromPropertyFile("password");
	   
	   System.out.println(value3);
	   
	   String value4 = pLib.readDataFromPropertyFile("url");
	   
	   System.out.println(value4);
	 
	   ExcelFileLibrary eLib = new ExcelFileLibrary();
      
	String val = eLib.readDataFromExcel("Organization", 1, 2);
	
       System.out.println(val);
       
       int row = eLib.getRowCount("Contacts");
       
       System.out.println(row);
       
      eLib.writeDataIntoExcel("Organization", 7, 8, "SOUMYA");
		
       
		
	   
	   
	}

}
