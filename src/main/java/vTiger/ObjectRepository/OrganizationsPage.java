package vTiger.ObjectRepository;

    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class OrganizationsPage {
	  
	  
	  //declaration
	    @FindBy(xpath="//img[@title='Create Organization...']")
	    private WebElement CreateOrganizationsLookUpImg;
	    
	    

	    //initialization
	    public OrganizationsPage(WebDriver driver)
	    {
	      PageFactory.initElements(driver, this);
	    }
	    
	    
	    //utilization
	    public WebElement getCreateOrganizationsLookUpImg() {
	      return CreateOrganizationsLookUpImg;
	    }
	    
	  // Business Library
	    /**
	     * This method will click on create contact look up image
	     */
	    
	    public void clickOnCreateOrganizationsLookUpImg()
	    {
	      CreateOrganizationsLookUpImg.click();
	    }
	    
	    

	}

