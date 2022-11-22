package vTiger.Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {

	
	public static  void  main(String[] args) throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//enter username as admin
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		
        //enter password as admin
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		//click on login
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contact
		driver.findElement(By.xpath("//a[text()='Contacts'][1]")).click();
		
		//click on + button to create new contact
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
driver.findElement(By.name("lastname")).sendKeys("samm");
		
		//click on save button
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
