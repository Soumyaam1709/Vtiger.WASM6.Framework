package vTiger.ProductTest;

import java.io.IOException;

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
public class TestVeena {

	public static void main(String[] args) throws IOException {
	

		 //Step 1: Create Object for all library files
		    ExcelFileLibrary eLib = new ExcelFileLibrary();
		    JavaLibrary jLib = new JavaLibrary();
		    PropertyFileLibrary pLib = new PropertyFileLibrary();
		    WebDriverLibrary wLib = new WebDriverLibrary();
		    
		//Step 2: Read all the required data
		    String BROWSER = pLib.readDataFromPropertyFile("browser");
		    String USERNAME = pLib.readDataFromPropertyFile("username");
		    String PASSWORD = pLib.readDataFromPropertyFile("password");
		    String URL =pLib.readDataFromPropertyFile("url");
		       String PRODUCTNAME = eLib.readDataFromExcel("Products", 1, 2)+jLib.getRandomNumber();
		    String VENDORNAME =eLib.readDataFromExcel("Vendor", 1, 2)+jLib.getRandomNumber();
		    
		    
		//Step 3: Open the browser
		    WebDriver driver =  null;
		    
		    if(BROWSER.equalsIgnoreCase("chrome"))
		    {
		      WebDriverManager.chromedriver().setup();
		      driver = new ChromeDriver();
		      System.out.println("Application opening in CHROME driver");
		    }
		    else if (BROWSER.equalsIgnoreCase("firefox"))
		    {
		      WebDriverManager.firefoxdriver().setup();
		      driver = new FirefoxDriver();
		      System.out.println("Application opening in CHROME driver");
		      
		    }
		    
		    else
		    {
		      System.out.println("Invalid browser name");
		    }
		    
		    driver.manage().window().maximize();
		    wLib.waitForPageLoad(driver);
		    
		    driver.get(URL);
		    
		    
		//Step 4: Login to application
		    
		    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		    driver.findElement(By.id("submitButton")).click();
		    
		//Step 5: Create Vendor
		    WebElement ele1 = driver.findElement(By.xpath("//a[text()='More']"));
		    wLib.mouseHoverOn(driver, ele1);
		    driver.findElement(By.name("Vendors")).click();
		    driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		    driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    String VENDHEADER = driver.findElement(By.xpath("//span[@class ='lvtHeaderText']")).getText();
		    System.out.println("Vendor Header: "+ VENDHEADER);
		    if(VENDHEADER.contains(VENDORNAME))
		    {
		      System.out.println("Vendor created successfully");
		    }
		    else
		    {
		      
		      System.out.println("Failed to create Vendor");
		      wLib.takeScreenShot(driver, "CreateProductWithVendor");
		    }
		    
		    
		    
		//Step 6: Navigate to product
		    driver.findElement(By.xpath("//a[text()='Products']")).click();
		    // click on + button to create new product
		    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		    
		    driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
		    
		//Step 7: switch to look up window
		    driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		    //switch to child window
		    wLib.switchToWindow(driver, "Vendors");
		    
		    driver.findElement(By.name("search_text")).sendKeys(VENDORNAME);
		    driver.findElement(By.name("search")).click();
		    driver.findElement(By.linkText(VENDORNAME)).click();
		    
		    //Switch back to parent window
		    wLib.switchToWindow(driver, "Products");
		    
		    
		//Step 8: Save the data
		        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();    
		    
		    String PRODHEADER = driver.findElement(By.xpath("//span[@class= 'lvtHeaderText']")).getText();
		    System.out.println("Product Header = "+ PRODHEADER);
		    
		    if(PRODHEADER.contains(PRODUCTNAME))
		    {
		      System.out.println("Product created successfully with vendor");
		    }
		    else
		    {
		      System.out.println("Product not created");
		      wLib.takeScreenShot(driver, "CreateProductwithVendor");
		    }
		    

		    
		//Step 9: Sign out from the application
		    WebElement ele2 =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		    wLib.mouseHoverOn(driver, ele2);
		    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		    
		      
		    
		    
		    
		    
		    
		  }

		

	}


