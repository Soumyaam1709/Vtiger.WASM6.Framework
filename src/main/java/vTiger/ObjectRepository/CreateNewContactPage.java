package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewContactPage  extends WebDriverLibrary{

	//declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name ="leads ource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@name='account_name']/following-siblings::img[@title='select']")
	private WebElement OrganizationImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+s]']")
	private WebElement saveBtn;
	
	//utilization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	
	//initialization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	/**
	 * This method will create name
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
/**
 * This method will create new contact with lead source dropdown
 * @param lastname
 * @param leadSourceValue
 */
	public void createNewContact(String lastname , String leadSourceValue)
	{
	lastNameEdt.sendKeys(lastname);
	handleDropDown(leadSourceDropDown , leadSourceValue);
	saveBtn.click();
	}

	

		
	}
	 
	
	

