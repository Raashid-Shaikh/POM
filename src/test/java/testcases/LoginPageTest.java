package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.testBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends testBase{

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	 
	
	
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();	
	}
	
	
		@Test(priority =1)
		public void verifyPageTitleTest() {
			String title = loginPage.ValidatePageTitle();
			Assert.assertEquals(title, "Cogmento CRM and VCM Verifiable Credentials Management and Customer Relationship Management");
		}
		
		@Test(priority=2)
		public void login() throws InterruptedException {
			homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		}
		
	
	
	
	@AfterMethod()
	public void tearDown() {
		driver.close();
	}
	
	//@AfterMethod()
	public void EndSession() {
	    if (driver == null) {
	        driver.quit();
	    }
	}
}
