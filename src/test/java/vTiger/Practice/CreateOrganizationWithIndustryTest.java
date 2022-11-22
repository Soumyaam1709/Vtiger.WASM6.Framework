package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustryTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("http://localhost:8888");

		
		//enter username as admin
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		
        //enter password as admin
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		//click on login
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on + button to create new organization
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        
        //enter valid data organization name
        driver.findElement(By.name("accountname")).sendKeys("sius associates");

        
        //industry type as healthcare
        WebElement dd=driver.findElement(By.name("industry"));
        Select s= new Select(dd);
        s.selectByValue("Healthcare");
        
        //click on save button
        driver.findElement(By.name("button")).click();
        
        

         //Thread.sleep(3000);
		
		//mouse hovering  to sign out 
		WebElement ele = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		
		//signout from application
		driver.findElement(By.linkText("Sign Out")).click();


	}

}
