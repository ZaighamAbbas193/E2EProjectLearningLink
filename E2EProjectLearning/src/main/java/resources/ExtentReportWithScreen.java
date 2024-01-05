package resources;


import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportWithScreen extends Base{
	
	
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
	
	
	
	
	

}
