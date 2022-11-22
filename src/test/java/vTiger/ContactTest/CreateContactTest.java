package vTiger.ContactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import org.testng.annotations.Test;


public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeSuite")
	public  void CreateContactTest()  throws IOException {
	
		//Step 1: Create Object of all the libraries
				JavaLibrary jLib = new JavaLibrary();
				PropertyFileLibrary pLib = new PropertyFileLibrary();
				ExcelFileLibrary eLib = new ExcelFileLibrary();
				WebDriverLibrary wLib = new WebDriverLibrary();
				
				//Step 2: read all the required data
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String URL = pLib.readDataFromPropertyFile("url");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");
				
				String LASTNAME = eLib.readDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
				
				WebDriver driver = null;
				
				//Step 3: launch the browser
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
				
				//Step 4: Login to Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 5: Navigate to Contacts Link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step 6: Navigate to create Contact Look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//Step 7: create contact with mandatory details and save
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 8: Validate
				String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				System.out.println(contactHeader);
				
				if(contactHeader.contains(LASTNAME))
				{
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
	}
				
				//Step 9: Logout of Application
				//WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				//wLib.mouseHoverOn(driver, adminImg);
				//driver.findElement(By.linkText("Sign Out")).click();
				
				@Test(groups = "regressionSuite")
				public void createContactDemotest()
				{
					System.out.println("demo test");
				}
	}
	
	

				
				
				
				
				

	


