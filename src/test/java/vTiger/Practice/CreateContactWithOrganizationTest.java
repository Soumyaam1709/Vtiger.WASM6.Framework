package vTiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganizationTest {

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
		
		//click on organization
        driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
        
        //click on + button to create new organization
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        
        //enter valid data-organization name
        driver.findElement(By.name("accountname")).sendKeys("pap associates");
        
		//navigate to contact
		driver.findElement(By.xpath("//a[text()='Contacts'][1]")).click();
		
		//click on + button to create new contact
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter last name
		driver.findElement(By.name("lastname")).sendKeys("remya");
		
		
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
