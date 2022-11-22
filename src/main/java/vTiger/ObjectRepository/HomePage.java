package vTiger.ObjectRepository ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary{
  
  //Declaration
  @FindBy(linkText ="Organizations")
  private WebElement OrganizationsLnk;
  
  @FindBy(linkText = "Contacts")
  private WebElement ContactsLnk;
      
 
  @FindBy(linkText = "Products")
  private WebElement ProductsLnk;
  
  @FindBy(linkText = "Oppoprtunities")
  private WebElement OpportunitiesLnk;
  
  @FindBy(linkText ="Calendar")
  private WebElement CalendarLnk;
  
  @FindBy(linkText = "Leads")
  private WebElement LeadsLnk;
  
  @FindBy(linkText = "More")
  private WebElement MoreLnk;
  
  @FindBy(linkText = "Vendors")
  private WebElement VendorsLnk;
  
  @FindBy (xpath = "//img[@src= 'themes/softed/images/user.PNG']")
  private WebElement AdministratorImg;
  
  @FindBy (linkText = "Sign Out")
  private WebElement SignOutLnk;
  
//Initialization
  
  public HomePage(WebDriver driver)
  {
    PageFactory.initElements(driver, this);
  }


  //Utilization ---->getters & Business library
  

  public WebElement getOrganizationLnk() {
    return OrganizationsLnk;
  }




  public WebElement getContactsLnk() {
    return ContactsLnk;
  }




  public WebElement getOpportunitiesLnk() {
    return OpportunitiesLnk;
  }
    
    public WebElement getProductsLnk() {
        return ProductsLnk;
      }



      public WebElement getCalendarLnk() {
        return CalendarLnk;
      }




      public WebElement getLeadsLnk() {
        return LeadsLnk;
      }




      public WebElement getMoreLnk() {
        return MoreLnk;
      }
     
      public WebElement getVendorsLnk() {
    	    return VendorsLnk;
    	  }




    	  public WebElement getAdministratorImg() {
    	    return AdministratorImg;
    	  }




    	  public WebElement getSignOutLnk() {
    	    return SignOutLnk;
    	  }
    	  
    	  
    	  //Business logic 
    	  /**
    	   * This method will click on organization
    	   */
    	  public void clickOnOrganizationLink()
    	  {
    	    OrganizationsLnk.click();
    	  }
    	  
    	  /**
    	   * This method will click on products
    	   */
    	  public void clickOnProductsLnkLink()
    	  {
    	    ProductsLnk.click();
    	  }
    	  
    	  /**
    	    * this method will click on contacts
    	    */
    	  public void clickOnContactsLnkLink()
    	  {
    	    ContactsLnk.click();
    	  }
    	  
    	  // Business Library to log out from the appllication
    	  /**
    	   * This method will sign out of application
    	   * @param driver
    	   */
    	  public void signOutOfApp(WebDriver driver)
    	  {
    	    mouseHoverOn(driver, AdministratorImg);
    	    SignOutLnk.click();
    	  }
    	  
    	  
  }


	
