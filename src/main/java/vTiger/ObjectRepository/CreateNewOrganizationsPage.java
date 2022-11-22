package vTiger.ObjectRepository;

 // import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganizationsPage extends WebDriverLibrary{
  
  //declaration
      @FindBy(name="accountname")
      private WebElement OrgNameEdt;
      
      @FindBy(name="industry")
      private WebElement industryNameDropDown;
      
      
      
      @FindBy(xpath="//input[@title = 'Save [Alt+S]']")
      private WebElement saveBtn;
      
      
    //initialization
      public CreateNewOrganizationsPage(WebDriver driver)
      {
        PageFactory.initElements(driver, this);
      }

 

      
    //utilization
      public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}





	public WebElement getIndustryNameDropDown() {
		return industryNameDropDown;
	}





	public WebElement getSaveBtn() {
		return saveBtn;
	}


      //Business library
      /**
       * This method will create new organization 
       * @param lastname
       */
      public void CreateNewOrganizations(String organizationName)
      {
        OrgNameEdt.sendKeys(organizationName);
        saveBtn.click();
      }
        
      
      
       /** This method will create organization with industry type
       * @param orgName
       * @param industryNameValue
       */
      public void createNewOrganizations(String orgName, String industryNameValue)
      {
        OrgNameEdt.sendKeys(orgName);
        handleDropDown(industryNameValue,industryNameDropDown);
        saveBtn.click();
      }
      
  

}

