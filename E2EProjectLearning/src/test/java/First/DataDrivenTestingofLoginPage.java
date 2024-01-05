package First;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LoginPageLocators;
import resources.Base;

public class DataDrivenTestingofLoginPage extends Base {
	
	private static Logger logger =  LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException {
		
		driver = initializeDriver();
		
	}

	
	 @DataProvider
		public Object[][] getData(){
			
			Object[][] data = new Object[5][2];
			data[0][0]= "standard_user";
			data[0][1]= "secret_sauce";
			
			data[1][0]= "locked_out_user";
			data[1][1]= "secret_sauce";
			
			data[2][0]= "problem_user";
			data[2][1]= "secret_sauce";
			
			data[3][0]= "performance_glitch_user";
			data[3][1]= "secret_sauce";
			
			data[4][0]= "error_user";
			data[4][1]= "secret_sauce";
			
			return data;
			
		}
		
		@Test(dataProvider="getData")

		public void Login_With_All_users_And_verifyLogin_functionalitya(String Username, String Password) throws IOException {
	  
			driver.get(prop.getProperty("url"));
			
			LoginPageLocators objLoginPage = new LoginPageLocators(driver);

			objLoginPage.getusername().sendKeys(Username);
			objLoginPage.getpassword().sendKeys(Password);
			
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			objLoginPage.getbtnlogin().click();
			
			 logger.info("Successfully login with " + Username);
			
			 String ActualUrl= "https://www.saucedemo.com/inventory.html";
			 
			 String ExpectedURL= driver.getCurrentUrl();
			  
			  if(ActualUrl.equalsIgnoreCase(ExpectedURL)) {
			  
			  System.out.println("Login Successully"); 
			  
			  logger.info("Successfully Matched URL After login with " + Username);
			  
			  }else {
				  
				  logger.info("URL does not Matched with After login URL " + Username);
				  
				  logger.info("Login Failed");
			  
			  System.out.println("Login Failed");
			  
			
			  
			  }
			  
			  
			  } 
	 
	 
	  @AfterTest
	  public void Teardown() {
		  
	 driver.close();
	 
	 driver=null;
		  
	  }
	  
	 	
	
}
