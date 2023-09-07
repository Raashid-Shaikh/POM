package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.testBase;

public class HomePage extends testBase{
	
	@FindBy(xpath="//div[@id='top-header-menu']//b")
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[@class='menu-item-wrapper'][3]")
	WebElement contactsLink;
	
	@FindBy(xpath="//div[@class='menu-item-wrapper'][5]")
	WebElement dealsLink;
	
	@FindBy(xpath="//div[@class='menu-item-wrapper'][6]")
	WebElement taskLink;
	
	@FindBy(xpath="//button[@class='ui linkedin button'][1]//i")
	WebElement CreateNewContactBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUsername() {
		
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
			contactsLink.click();
			return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public void clickOnAddContact()  {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).click().perform();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		action.moveToElement(CreateNewContactBtn).click().perform();
	}
	
	
	
	
	
	
}
