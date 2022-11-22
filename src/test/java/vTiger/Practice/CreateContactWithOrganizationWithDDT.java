package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationWithDDT {

	public static void main(String[] args) throws IOException   {
	
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		WebDriver driver =null;
		
		
		//step 1:launch the browser-RUN TIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"));
		{
			WebDriverManager.chromedriver().setup();
             driver= new ChromeDriver();
			System.out.println("===" + BROWSER + "is launched===");
		}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get(URL);
			
			//step 3: login to the application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//step 4: navigate to contacts
			driver.findElement(By.linkText("Contacts")).click();
			
			//step 5: create contact with mandatory fields
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys("Chithra");
			
					
					//click on organization lookup icon
					String parent=driver.getWindowHandle();
					
					driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
					

			       Set<String> child=driver.getWindowHandles();
			        
					for(String b:child)
					{
						driver.switchTo().window(b);
					}
					
					//select organization from child browser pop up
					driver.findElement(By.xpath("//a[text()='atpm associates' ]")).click();
					
					driver.switchTo().window(parent);
					
					driver.findElement(By.name("button")).click();
					
					//Thread.sleep(3000);

			        
					//mouse hover 
					WebElement ele = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
					Actions a=new Actions(driver);
					a.moveToElement(ele).perform();
					
					//signout from application
					driver.findElement(By.linkText("Sign Out")).click();




					
		}
		
		

	}


