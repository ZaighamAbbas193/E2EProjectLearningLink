package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCardLocators {
	
public static WebDriver driver;
	
	public AddToCardLocators(WebDriver driver) {
		
		this.driver= driver;
	}
	
	
	public static By back_pack = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	
	public WebElement back_pack() {
		
		return driver.findElement(back_pack);
			
	}
	
	public static By bike_light = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
	
	public WebElement bike_light() {
		
		return driver.findElement(bike_light);
			
	}
	
	
	public static By shopping_cart_badge = By.xpath("//span[@class='shopping_cart_badge']");
	
	public WebElement getCountofshopping_cart_badge() {
		
		return driver.findElement(shopping_cart_badge);
			
	}
	
	
	
	public static By ContinueShopping = By.xpath("//button[@id='continue-shopping']");
	
	public WebElement ContinueShopping() {
		
		return driver.findElement(ContinueShopping);
			
	}
	
	public static By bolt_t_shirt = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	
	public WebElement bolt_t_shirt() {
		
		return driver.findElement(bolt_t_shirt);
			
	}
	
	
	public static By fleece_jacket = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
	
	public WebElement fleece_jacket() {
		
		return driver.findElement(fleece_jacket);
			
	}
	
	public static By checkout = By.xpath("//button[@id='checkout']");
	
	public WebElement checkout() {
		
		return driver.findElement(checkout);
			
	}
	
	
	
	
	
	

}
