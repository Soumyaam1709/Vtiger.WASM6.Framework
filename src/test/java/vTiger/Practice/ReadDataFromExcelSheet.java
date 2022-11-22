package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws IOException {
		
		//step 1:read the file and load into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step 2:create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//navigate to required sheet
		 Sheet sh = wb.getSheet("Contacts");
		
		//step 4: navigate to required row inside the sheet
		 Row rw = sh.getRow(1);
		 
		 //step 5: navigate to required cell inside the row
		  Cell cl = rw.getCell(2);
        
		  //step 6: read the value present in that cell
		 String value = cl.getStringCellValue();
	}

}
