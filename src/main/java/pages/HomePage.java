package pages;

import org.openqa.selenium.WebElement;
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
	
	
	
	
	
	
}
