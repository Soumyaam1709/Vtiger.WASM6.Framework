package vTiger.OrganizationsTest;

import java.io.IOException;

import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationsPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	
	 @Test (groups = "regressionSuite")
	  
	  public void createOrganization() throws IOException
	  {
	    String ORGNAME = eLib.readDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
	    
	    // Navigate to organizations link
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrganizationLink();
	    
	    // create new Organization and save it
	    OrganizationsPage op = new OrganizationsPage(driver);
	    op.clickOnCreateOrganizationsLookUpImg();
	    
	    CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
	    cnop.CreateNewOrganizations(ORGNAME);
	    
	    OrganizationsInfoPage orgInfo = new OrganizationsInfoPage(driver);
	    String OrgHeader = orgInfo.getOrgHeader();
	    if (OrgHeader.contentEquals(ORGNAME))
	    {
	      
	      System.out.println("PASS");
	      System.out.println("Organization Created Succesfully");
	    }
	    else
	    {
	      System.out.println("FAIL");
	    }
	  }
}
