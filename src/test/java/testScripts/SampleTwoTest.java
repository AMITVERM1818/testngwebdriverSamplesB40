package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class SampleTwoTest {
	WebDriver driver;
  @Test
  public void playwrightSearchTest() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  WebElement srcBox = driver.findElement(By.id("APjFqb"));
	  srcBox.sendKeys("Playwright Tutorial");
	  srcBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Playwright Tutorial - Google Search");
  }
}
