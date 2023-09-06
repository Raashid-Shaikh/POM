package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.testBase;

public class LoginPage extends testBase{

	@FindBy(xpath="//input[@name='email']")
	WebElement Email;
	

	@FindBy(xpath="//input[@name='password']")
	WebElement Pass;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement LoginButton;
	
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement LogButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage Login(String a, String b) throws InterruptedException   {
		
		LogButton.click();
		Thread.sleep(1000);
		Email.sendKeys(a);
		Pass.sendKeys(b);
		Thread.sleep(1000);
		LoginButton.click();
		
		return new HomePage();
		
	}
	
	public String ValidatePageTitle() {
		return driver.getTitle();
	}
	
	

}
