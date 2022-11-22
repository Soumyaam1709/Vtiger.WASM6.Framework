package vTiger.GenericLibrary;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read an write data into excel sheet
 * @author Soumya 
 * 
 *
 */
public class ExcelFileLibrary {
	/**
	 * This method will read the data from excel sheet for the sheet name, row no and cell no
	 * given by User
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @throws EncryptedDocumentException
	 * @throws IOException 
	 */
	public String readDataFromExcel(String sheetName, int rowNo ,int celNo) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell ce = rw.getCell(celNo);
		String value = ce.getStringCellValue();
		wb.close();
		return  value ;
	}
	/**
	 * This method will provide the last row number utilized in a given sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws  IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
		
	
	/**
	 * This method will write the data into the excel sheet for user specified sheet, row no and cell no
	 * @param sheetName
	 * @param celNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException 
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo , int celNo,String value ) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cel = rw.createCell(celNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IConstantsLibrary.excelFilePath);
		wb.write(fos);
		wb.close();
		System.out.println("Data written successfully");
}
	
	

}
