package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class GooglePageParametrizationTest {
	
	WebDriver driver;
	
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
		  
		  driver.get("https://www.google.com/");
		  WebElement srcBox = driver.findElement(By.id("APjFqb"));
		  srcBox.sendKeys("Selenium Tutorial");
		  srcBox.submit();
//		  srcBox.sendKeys(Keys.ENTER);
		  
//		  We use Assert for validation in TestNG
		  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
		  
		  	  
	}

	
	
	
	
}
