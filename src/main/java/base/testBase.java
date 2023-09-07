package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.testutil;

public class testBase {


	public static WebDriver driver;
	public static Properties prop;
	
	//public static JavascriptExecutor jsPlay =  (JavascriptExecutor) driver;
	
	//public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	
	
	public testBase()  {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/raashidshaikh/Desktop/QA/SeleniumWorkSpace/POM/src/main/java/config/config.properties");
			
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void intialization() {
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		
		
		driver.get(prop.getProperty("url"));
		
	}
	

	
	
	
}
