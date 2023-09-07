package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public HomePage Login(String a, String b)    {
		
		LogButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Email.sendKeys(a);
		Pass.sendKeys(b);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginButton.click();
		
		return new HomePage();
		
	}
	
	public String ValidatePageTitle() {
		return driver.getTitle();
	}
	
	

}
