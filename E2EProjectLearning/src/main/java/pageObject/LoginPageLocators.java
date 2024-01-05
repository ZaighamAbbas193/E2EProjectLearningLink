package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageLocators {
	
	public WebDriver driver;
	
	public LoginPageLocators(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public static By PageTitle = By.xpath("//div[@class='app_logo']");
	
	public WebElement getPageHeader() {
		
		return driver.findElement(PageTitle);
			
	}

	
	public static By username = By.id("user-name");
	public WebElement getusername() {
	return driver.findElement(username);
	
	}
	
	
	public static By password = By.id("password");
	public WebElement getpassword() {
	return driver.findElement(password);
			
	}
	
	By btnlogin = By.id("login-button");
	public WebElement getbtnlogin() {
		return driver.findElement(btnlogin);
			
	}
	
	
	
	
	
	
	
	
	

}
