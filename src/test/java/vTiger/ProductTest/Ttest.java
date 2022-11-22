package vTiger.ProductTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class Ttest {

	public static void main(String[] args) throws IOException {
		//step 1 :create object of all the libraries
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();
		
		//step 2: read all the required data
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		String PRODUCTNAME= eLib.readDataFromExcel("Products", 1,2)+jLib.getRandomNumber();
		String VENDORNAME = eLib.readDataFromExcel("Vendor", 1,2)+jLib.getRandomNumber();
		
		
		  
				WebDriver driver = null;
				
		//step 3 :launch the browser
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
			
			wLib.maximizeWindow(driver);
			wLib.waitForPageLoad(driver);
			driver.get(URL);
			
		     //step 4 :Login to Application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			
			//step 5 : navigate to vendor
			//mouse hover on more
			WebElement ele1=driver.findElement(By.linkText("More"));
			wLib.mouseHoverOn( driver,ele1);
			
			//after mouse hovering click on vendor
			driver.findElement(By.name("Vendors")).click();
			
			//click on + button to create  new vendor
			driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
			
			//step  :enter mandatory field vendor name
			driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
			
			//click on save button after entering vendor name
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//step  : validate
			String VENDHEADER = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			
			System.out.println("Vendor Header:" + VENDHEADER);
			
			if(VENDHEADER.contains(VENDORNAME))
			{
				System.out.println("vendor created successfully");
			}
			else
			{
				System.out.println("failed to create vendor");
				wLib.takeScreenShot(driver, "CreateProductctWithVendor");
				
			}
			
			// step 6 : navigate and click on product
			driver.findElement(By.linkText("Products")).click();
			
			//click on + button to create new product
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
			
			//enter product name mandatory field
			driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
			
			// step 7 : switch to vendor name look up window
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			
			
			//switch to window
              wLib.switchToWindow(driver,"Vendors");
              
              driver.findElement(By.name("search_text")).sendKeys(VENDORNAME);
              
              //driver.findElement(By.xpath("(//input[@style='border:1px solid #bababa;''])[5]")).click();
              
              //switch back to parent window
              wLib.switchToWindow(driver,"Product");
			
			
			//click on save button after entering vendor name
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//String ProductHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			
			//if(ProductHeader.contains(PRODUCTNAME))
			//{
				//System.out.println("product created successfully");
				
			//}
			//else
			//{
				//System.out.println("product not created");
			//}
			
			//step 9 : logout
			//WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			//wLib.mouseHoverOn(driver, adminImg);
			//driver.findElement(By.linkText("Sign Out")).click();
			
			//}

			
	}

}
