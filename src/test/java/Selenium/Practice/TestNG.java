package Selenium.Practice;

import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class TestNG {
	
public WebDriver driver;	
  @Test
  public void Main() throws InterruptedException, IOException {
	 // driver.findElement(By.id("account")).click();
	  
	  WebElement oProd = null;
	  
	  driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a")).click();
			  
	  driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]")).sendKeys("dress");
      // Find the element that's ID attribute is 'log' (Username)
	  
	  driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]")).sendKeys(Keys.ENTER);
      // Enter Username on the element found by above desc.
	  
	  //Thread.sleep(5000);
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  List <WebElement> olist = driver.findElements(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div"));
 
	  for (int i=1; i<=olist.size(); i++) {
		  
		 String otext =  driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div["+i+"]/div/h3/a")).getAttribute("href");
		  
		  if (otext.contains("hook")) {
			  
			  oProd = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div["+i+"]/div/h3/a"));
			  break;
		  }
		  
		  
		}
	  
	  oProd.click();
	  
	  Actions act = new Actions(driver);
			  
	  act.sendKeys(Keys.PAGE_DOWN).build().perform();
	  
	  
	  
	  TakesScreenshot srh = ((TakesScreenshot)driver);
	  
	  File srhfile = srh.getScreenshotAs(OutputType.FILE);
	  
	  File des = new File("C:\\Users\\ssgan\\eclipse-workspace\\123.png");
	  
	  
	  FileUtils.copyFile(srhfile,des);
	  
	  
	  
	  
	  
	  
	  /*
      driver.findElement(By.id("log")).sendKeys("testuser_1");
 
      // Find the element that's ID attribute is 'pwd' (Password)
 
      // Enter Password on the element found by the above desc.
 
      driver.findElement(By.id("pwd")).sendKeys("Test@123");
 
      // Now submit the form. WebDriver will find the form for us from the element
 
      driver.findElement(By.id("login")).click();
 
      // Print a Log In message to the screen
 
      System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
 
      // Find the element that's ID attribute is 'account_logout' (Log Out)
 
      driver.findElement(By.id("account_logout"));
	   
	   */ 
	  
  }

@BeforeTest
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\ssgan\\eclipse-workspace\\geckodriver.exe");

	  driver = new FirefoxDriver();
	  
      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
      //Launch the Online Store Website
      
      driver.get("http://shop.demoqa.com");
 
      //driver.get("http://www.onlinestore.toolsqa.com");
	  
	  
  }

  @AfterTest
  public void afterMethod() {
	  
	  driver.quit();
	  
  }

}
