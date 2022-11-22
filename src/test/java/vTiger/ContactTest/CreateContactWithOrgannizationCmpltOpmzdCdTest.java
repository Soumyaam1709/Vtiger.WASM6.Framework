package vTiger.ContactTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationsPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationsInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrgannizationCmpltOpmzdCdTest  extends BaseClass
{
	
	@Test

	//@Test(groups = "regressionSuite")
	public void createContactWithOrgTest() throws IOException
	{

		// Step 2: read all the required data
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
		
		//Step 5: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 6: Navigate to create Organizations look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		//op.clickOnCreateOrgImg();
		
		//Step 7: Create new organization and save
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		//cnop.createNewOrganizations(ORGNAME);
		
		//Step 8: Validate for Organization
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME), "Organization created");
		
		//Step 9: Navigate to contacts link
		hp.clickOnContactsLnkLink();
		
		// Step 10: Navigate to create Contact Look up image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactImg();

				// Step 11: create contact with mandatory details
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				//cncp.createNewContact(LASTNAME, ORGNAME, driver);
				
		        //Step 12: Validate for Contact
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String contactHeader = cip.getContactHeader(); //bug
				Assert.assertTrue(contactHeader.contains(LASTNAME), "contact created");
				
			}
}
