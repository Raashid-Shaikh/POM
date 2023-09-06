package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.testBase;

public class ContactsPage extends testBase{

	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//div[@class='table-wrapper']//td[1]")
	WebElement ContactName;
	
	@FindBy(xpath="//div[@class='table-wrapper']//td[4]")
	WebElement toGetLocation;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean CheckContactsLabel() {
		return ContactsLabel.isDisplayed();
	}
	
	public void clickOnContactName() {
		System.out.println(toGetLocation.getLocation());
		ContactName.click();
	}
	
}
