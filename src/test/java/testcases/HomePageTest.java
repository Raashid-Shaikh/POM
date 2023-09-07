package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.testBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends testBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
		@BeforeMethod
		public void setUp() throws InterruptedException {
			intialization();
			contactsPage = new ContactsPage();
			loginPage = new LoginPage();
			homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
			
		}
		
				@Test(priority=1)
				public void verifyHomePageTitleTest() {
					String title = homePage.verifyHomePageTitle();
					Assert.assertEquals(title, "Cogmento CRM", "Homepage: title not matched");
				}
				
				@Test(priority=2)
				public void verifyUserNameTest() throws InterruptedException {
					Thread.sleep(2000);
					Assert.assertTrue(homePage.verifyCorrectUsername());
				}
				
				@Test(priority=3)
				public void verifyContactLinkTest() {
					contactsPage = homePage.clickOnContactsLink();
				}
				
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	
	
}
