package First;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ResuableMethods.ActionDriver;
import pageObject.LoginPageLocators;
import resources.Base;

public class AddToCard extends Base {

	private static Logger logger = LogManager.getLogger(Base.class.getName());

	LoginPage objlogin = new LoginPage();

	@BeforeTest
	public void Initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		logger.info("Launch the Browser");

	}

	@Test(priority = 1)

	// (enabled= false)
	//

	public void Add_Item_into_Card() throws Exception {

		ActionDriver aDriver = new ActionDriver();

		Base.childTest = Base.parentTest.createNode("Verifying that the item is Added into the card");

		objlogin.Login_With_ValidData();

		aDriver.click(pageObject.AddToCardLocators.back_pack, "Click on the Add to Card button.");

		aDriver.click(pageObject.AddToCardLocators.bike_light, "Click on the Next Add to Card button.");

		logger.info("Both Items are successfully Added into the Card ");

		aDriver.click(pageObject.AddToCardLocators.shopping_cart_badge, "Click on the Shopping Card Badge");

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0, arguments[0])", 800);

		Thread.sleep(3000);

		aDriver.click(pageObject.AddToCardLocators.ContinueShopping, "Click on the Continue Shopping");

		logger.info("User is successfully navigate into the Inventory Page");

		// aDriver.click(pageObject.AddToCardLocators.shopping_cart_badge, "Click on the
		// Shopping Card Badge");

		aDriver.click(pageObject.AddToCardLocators.bolt_t_shirt, "Click on the Add to Card button.");

		aDriver.click(pageObject.AddToCardLocators.fleece_jacket, "Click on the Next Add to Card button.");

		logger.info("Both Items are successfully Added into the Card ");

		aDriver.click(pageObject.AddToCardLocators.shopping_cart_badge, "Click on the Shopping Card Badge");

		driver.findElement(By.xpath("//button[@id='checkout']")).sendKeys(Keys.ARROW_DOWN);

		Thread.sleep(3000);

		aDriver.click(pageObject.AddToCardLocators.checkout, "Click on CheckOut Button");

	}

	@AfterTest

	public void Teardown() throws InterruptedException {

		extent.flush();

		driver.close();

		driver = null;

	}

}
