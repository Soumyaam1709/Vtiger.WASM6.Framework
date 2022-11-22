package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) {
		
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("http://localhost:8888");

		//enter user name admin
        driver.findElement(By.name("user_name")).sendKeys("admin");
        
        //enter password admin
        driver.findElement(By.name("user_password")).sendKeys("admin");
        
        //click on login
        driver.findElement(By.id("submitButton")).submit();
        
        //navigate to organization
        driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
        
        // click on + button to create new organization
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        
        //enter valid data-organization name
        driver.findElement(By.name("accountname")).sendKeys("appm associates");
        
        //click on save button
        driver.findElement(By.name("button")).click();
        
        //Thread.sleep(3000);
        //logout mouse hover on head
        WebElement ele=driver.findElement(By.xpath("(//td[@class='small'])[2]"));
        Actions a= new Actions(driver);
        a.moveToElement(ele).perform();
        
        //click on signout
        driver.findElement(By.linkText("Sign Out")).click();
}


	}


