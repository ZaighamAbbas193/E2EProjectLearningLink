package ResuableMethods;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import junit.framework.Assert;
import pageObject.LoginPageLocators;
import resources.Base;

public class ActionDriver {

	public WebDriver driver;

	public Properties prop;

	public ActionDriver() {

		driver = Base.driver;

		// this.driver=driver;

	}

	public String Screenshot() {

		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	}// ScreenShort

	public void click(By locator, String eleName) throws Exception {

		try {
			driver.findElement(locator).click();
			Base.childTest.pass("Successfully Clicked on " + eleName);

		} catch (Exception e) {
			Base.childTest.fail("unable to  Clicked on " + eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());
			Base.childTest.info(e);
			throw e;
		}

	}

	public void NavigateToApplication(String url) throws Exception {

		// driver.get(url);

		try {

			driver.get(url);

			Base.childTest.pass("URL is Entered: " + url);
		} catch (Exception e) {
			Base.childTest.fail("URL is Not Entered: " + url);
			Base.childTest.info(e);
			throw e;

		}

	}//

	// Enter data in the text field.

	public void type(By locator, String text, String eleName) throws Exception {

		// driver.findElement(locator).sendKeys(text);

		try {

			driver.findElement(locator).sendKeys(text);

			Base.childTest.pass("Text is Entered in : " + eleName + " Field is: " + text);

		} catch (Exception e) {

			Base.childTest.fail("Text is Not Entered in : " + eleName + " Field is: " + text,
					MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot()).build());

			Base.childTest.info(e);
			throw e;

		}

	}// type

}
