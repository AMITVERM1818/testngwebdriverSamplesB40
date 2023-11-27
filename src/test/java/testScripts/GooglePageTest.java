package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class GooglePageTest {
	WebDriver driver;
	
//  @BeforeMethod
	@BeforeTest
  public void setup() {
	  
	  driver = new ChromeDriver();
  }
	
//	TestNG Class with Test Method
//	Test-1
	
//  @Test(dependsOnMethods="seleniumSearchTest")
  @Test(alwaysRun=true, dependsOnMethods="seleniumSearchTest")
  public void javaSearchTest() {
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  SoftAssert softAssert = new SoftAssert(); 
//	  softAssert.assertEquals(driver.getTitle(), "Google Page");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Java Tutorial");
	  srcBox.submit();
//	  srcBox.sendKeys(Keys.ENTER);
//	  Soft Assert
	  softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	  softAssert.assertAll();
	  
//	  We use Assert for validation in TestNG - Hard Assert
//	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");	 
	  	  
  }
  
//	Test-2
	
@Test()
public void seleniumSearchTest() {
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Selenium Tutorial");
	  srcBox.submit();
//	  srcBox.sendKeys(Keys.ENTER);
	  
//	  We use Assert for validation in TestNG
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search Page");
	  
	  	  
}
 
//@Test(enabled=false)
//public void cypressSearchTest() {
//	  
//	  driver.manage().window().maximize();
//	  driver.get("https://www.google.com/");
//	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
//	  srcBox.sendKeys("Cypress Tutorial");
//	  srcBox.submit();
//	  Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
//	 	  	  
//}
//
//@Test(enabled=false)
//public void aapiumSearchTest() {
//	  
//	  driver.manage().window().maximize();
//	  driver.get("https://www.google.com/");
//	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
//	  srcBox.sendKeys("Appium Tutorial");
//	  srcBox.submit();
//	  Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
//	  	  	  
//}


//	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.close();
	}

//	Test Suite -> Test -> Test Classes -> Test Methods

}
