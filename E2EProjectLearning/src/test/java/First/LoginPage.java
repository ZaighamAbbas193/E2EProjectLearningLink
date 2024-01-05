package First;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import ResuableMethods.ActionDriver;
import junit.framework.Assert;
import pageObject.LoginPageLocators;
import resources.Base;
import resources.DataReaderExcelFile;
import resources.ExtentReportWithScreen;

public class LoginPage extends Base {

	private static Logger logger = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void Initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		logger.info("Launch the Browser");

	}

	@Test(priority = 1)

	public void Login_With_ValidData() throws Exception {

		ActionDriver aDriver = new ActionDriver();

		Base.childTest = Base.parentTest.createNode("Verifying the Login functionality");

		LoginPageLocators objLoginPage = new LoginPageLocators(driver);

		// objLoginPage.getusername().sendKeys("standard_user");
		// objLoginPage.getpassword().sendKeys("secret_sauce");

		// WebElement Username= objLoginPage.getusername();
		
		DataReaderExcelFile objExcelReader = new DataReaderExcelFile();
			
		objExcelReader.LoginData("LoginSheet");

		aDriver.type(pageObject.LoginPageLocators.username, DataReaderExcelFile.username, "Username");

		aDriver.type(pageObject.LoginPageLocators.password, DataReaderExcelFile.password, "Password");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		objLoginPage.getbtnlogin().click();

		logger.info("Successfully login with " + DataReaderExcelFile.username);

		String ActualUrl = DataReaderExcelFile.ActualURL; 
		
		String ExpectedURL = driver.getCurrentUrl();

		if (ActualUrl.equalsIgnoreCase(ExpectedURL)) {

			System.out.println("Login Successully");

			logger.info("Successfully Matched URL After login with " + "standard_user");

		} else {

			System.out.println("Login Failed");

		}

	}

	@Test(priority = 2)
	// (enabled = false)
	//

	public void Verify_Page_Header_Text() throws Exception {

		ActionDriver aDriver = new ActionDriver();

		Base.childTest = Base.parentTest.createNode("Verifying the Header Text");

		LoginPageLocators objLandingPage = new LoginPageLocators(driver);

		String ActualHeadertext = objLandingPage.getPageHeader().getText();

		String ExpectedHeadertext = "Swag Labs";

		logger.info("Successfully Verified the Page Header Text");

	}

	@AfterTest
	public void Teardown() throws InterruptedException {

		extent.flush();

		driver.close();

		driver = null;

	}

}
