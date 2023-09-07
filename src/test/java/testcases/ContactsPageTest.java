package testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.testBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.testutil;

public class ContactsPageTest extends testBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName = "Data";
	
	
	public ContactsPageTest() {
		super();
	}
	
		@BeforeMethod
		public void setUp()  {
			intialization();
			contactsPage = new ContactsPage();
			loginPage = new LoginPage();
			homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
			homePage.clickOnContactsLink();
			
			}
		
				@Test(priority=1)
				public void verifyContactsPageLabel() {
					Assert.assertTrue(contactsPage.CheckContactsLabel(),"Assert Fail");
				}
			
				
				@Test(priority=2)
				public void clickOnContacts()  {
					
					//click on the browser screen to avoid the td open
					Actions action = new Actions(driver);
					action.moveByOffset(537, 155).build().perform();
					contactsPage.clickOnContactName();
					
				}
				
				//reading data from excel file
				@DataProvider
				public Object[][] getCRMTestData() {
					Object data[][] = testutil.getTestData(sheetName);
					return data;
				}
			
				//create new contacts
				@Test(priority=3, dataProvider="getCRMTestData")
				public void validateCreateNewContact(String FirstName, String LastName, String Department){
					homePage.clickOnAddContact();
					contactsPage.createNewContact(FirstName, LastName, Department);
				}
	
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

}
