package vTiger.ContactTest;


		import java.io.IOException;

		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;

		import io.github.bonigarcia.wdm.WebDriverManager;
		import vTiger.GenericLibrary.ExcelFileLibrary;
		import vTiger.GenericLibrary.JavaLibrary;
		import vTiger.GenericLibrary.PropertyFileLibrary;
		import vTiger.GenericLibrary.WebDriverLibrary;
		import vTiger.ObjectRepository.ContactsInfoPage;
		import vTiger.ObjectRepository.ContactsPage;
		import vTiger.ObjectRepository.CreateNewContactPage;
		import vTiger.ObjectRepository.HomePage;
		import vTiger.ObjectRepository.LoginPage;



		public class POMPracticeForCreateContactTest {
		  
		  public static void main(String[] args) throws IOException {
		    //step 1:create object of all the libraries
		    JavaLibrary jLib=new JavaLibrary();
		    PropertyFileLibrary pLib=new PropertyFileLibrary();
		    ExcelFileLibrary eLib=new ExcelFileLibrary();
		    WebDriverLibrary wLib=new WebDriverLibrary();
		    
		    //step 2:read all the required data
		    String BROWSER = pLib.readDataFromPropertyFile("browser");
		    String URL = pLib.readDataFromPropertyFile("url");
		    String USERNAME = pLib.readDataFromPropertyFile("username");
		    String PASSWORD = pLib.readDataFromPropertyFile("password");
		    
		    String LASTNAME = eLib.readDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
		    
		    WebDriver driver=null;
		    
		    //step 3:launch the browser
		    if(BROWSER.equalsIgnoreCase("chrome"))
		    {
		      WebDriverManager.chromedriver().setup();
		      driver=new ChromeDriver();
		    }
		    else if(BROWSER.equalsIgnoreCase("firefox"))
		    {
		      WebDriverManager.firefoxdriver().setup();
		      driver=new FirefoxDriver();
		    }
		    else
		    {
		      System.out.println("Invalid Browser Name");
		    }
		    
		    wLib.maximizeWindow(driver);
		    wLib.waitForPageLoad(driver);
		    driver.get(URL);
		    
		    //step 4:login to application
		    LoginPage lp= new LoginPage(driver);
		    lp.loginToApp(USERNAME, PASSWORD);
		    
		    //step 5:navigate to contacts link
		    HomePage hp=new HomePage(driver);
		    hp. clickOnContactsLnkLink();
		    
		    //step 6:navigate create contact look up image
		    ContactsPage cp =new ContactsPage(driver);
		    cp.getCreateContactLookUpImg();
		    
		    
		    //step 7:create contact with mandatory fields and save
		    CreateNewContactPage ccp=new CreateNewContactPage(driver);
		    ccp.createNewContact(LASTNAME);
		    
		    //step 8:validate
		    ContactsInfoPage cip=new ContactsInfoPage(driver);
		    String contactHeader = cip.getContactHeader();
		    System.out.println(contactHeader);
		    
		    if(contactHeader.contains(LASTNAME))
		    {
		      System.out.println("PASS");
		    }
		    else
		    {
		      System.out.println("FAIL");
		    }
		    
		    //step 9:logout of application
		    hp.signOutOfApp(driver);
		    

		  }


		
	}


