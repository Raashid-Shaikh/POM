package testcases;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.testBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactsPageTest extends testBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
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
		public void clickOnContacts() throws InterruptedException {
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.moveToLocation(537, 155).click().perform();;
			
			contactsPage.clickOnContactName();
			Thread.sleep(2000);
		}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
