package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;


public class GooglePageParametrizationTest {
	
	WebDriver driver;
	
//	ExtentReports	
	ExtentReports reports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		  
		  reports = new ExtentReports();
		  spark = new ExtentSparkReporter("test-output/SparkReport.html")
				  .viewConfigurer().viewOrder().as(new ViewName[] {
						  ViewName.DASHBOARD,
						  ViewName.TEST,
						  ViewName.AUTHOR,
						  ViewName.DEVICE,
						  ViewName.LOG
				  }).apply();
		  reports.attachReporter(spark);
	  }
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
	}

	@Test()
	  public void javaSearchTest() {
		
//		  Create a Instance of Test Name for every Extent Report to be generated
		
		extentTest = reports.createTest("Java Tutorial Search Test....");	
		  driver.get("https://www.google.com/");
		  SoftAssert softAssert = new SoftAssert(); 
//		  softAssert.assertEquals(driver.getTitle(), "Google Page");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Java Tutorial");
		  srcBox.submit();
//		  srcBox.sendKeys(Keys.ENTER);
 
//		  We use Assert for validation in TestNG - Hard Assert
		  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");	 
		  	  
	  }
	  
//		Test-2
		
	@Test()
	public void seleniumSearchTest() {
		
		extentTest = reports.createTest("Selenium Tutorial Search Test....");
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Selenium Tutorial");
		  srcBox.submit();
//		  srcBox.sendKeys(Keys.ENTER);
		  
//		  We use Assert for validation in TestNG
		  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search Page");
		  
		  	  
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		
//		Giving Details to be displayed in Extent Report
		extentTest.assignAuthor("Amit Verma")
		.assignCategory("Regression")
		.assignDevice(System.getProperty("os.name"))
		.assignDevice(System.getProperty("os.version"));
		
//		Implementing Listeners to capture and display Failed Result in Extent Report		
		if(ITestResult.FAILURE == result.getStatus()) {
			
			extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			String strPath = Utility.getScreenshotPath(driver);
			extentTest.fail(
						MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		}
		
		driver.close();
	}
	
	@AfterTest
	public void finishExtent() {
		reports.flush();
	}
	
	
	
}
