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
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='department']")
	WebElement Department;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement SaveBtn;
	
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
	
	
	public void createNewContact(String fName, String lname, String depInfo) {
		FirstName.sendKeys(fName);
		LastName.sendKeys(lname);
		Department.sendKeys(depInfo);
		SaveBtn.click();
	}
	
	
}
