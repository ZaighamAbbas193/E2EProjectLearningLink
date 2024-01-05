package resources;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {
	
	public static  WebDriver driver;
	
	public Properties prop;
	

	 ExtentHtmlReporter htmlreporter; 
	  
	  public static ExtentReports extent; 
	  
	  public static ExtentTest parentTest; 
	  
	  public static ExtentTest childTest;
	
	
	  @BeforeTest
	  public void Reports(){ 
		
	//htmlreporter= new ExtentHtmlReporter(System.getProperty("user.dir")+ "//Reports//MyResults.html");
		  
	htmlreporter= new ExtentHtmlReporter("Reports/MyResults.html");
		  
	  extent = new ExtentReports();
	  
	  extent.attachReporter(htmlreporter); }
	  
	  @BeforeMethod 
	  public static void method(Method method){
		  
	  
	 parentTest= extent.createTest(method.getName()); 
	 
	 
	  }
	
	 // @BeforeClass
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\New_folder\\QA_Softwares\\SeleniumTraining\\Work Space\\E2EProjectLearning\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String BrowserName= prop.getProperty("browser");
		
		System.out.println(BrowserName);
		
		if(BrowserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "F:\\New_folder\\QA_Softwares\\Prerequisite\\SeleniumAPI\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
		//	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
		}else if (BrowserName.equals("firefox")) {
			
			 System.setProperty("webdriver.gecko.driver", "F:\\New_folder\\QA_Softwares\\Prerequisite\\SeleniumAPI\\FirefoxDriver\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 
		//	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					 
			
		}else if (BrowserName.equals("IE")) {
			
			
			
		}
		
		return driver;
		
		 
	}
	


}


