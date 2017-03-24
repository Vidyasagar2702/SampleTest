package test;



import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class Sample {

	
	WebDriver driver;
	 @BeforeMethod
	public void setUp() throws Exception {
		 			//System.setProperty("webdriver.gecko.driver", "C:/Users/mabernard/Downloads/geckodriver-v0.14.0-win64/geckodriver.exe");
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\mabernard\\Downloads\\chromedriver_win32\\chromedriver.exe");	
			           
		 driver = (WebDriver) new ChromeDriver();	 	 	           
	 	 	         
	 	     }
	 
	 @AfterMethod
	public void tearDown() throws Exception {
	            driver.quit();
	 	     }

	 @Test
	 public void test() throws IOException, InterruptedException {
		 driver.navigate().to("http://www.google.com");
		 WebDriverWait wait = new WebDriverWait(driver, 5000);
		 By searchInput = By.cssSelector("#gsr");
		 By intro = By.id("introduction");
		 By goog = By.cssSelector("div._NId:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h3:nth-child(1) > a:nth-child(1)");
		 wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));
		 driver.findElement(By.cssSelector("#gsr")).sendKeys("This is a selenium test");
		 driver.findElement(By.id("_fZl")).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(goog));
		 driver.findElement(goog).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(intro));
		 String url = "http://www.seleniumhq.org/docs/01_introducing_selenium.jsp";
		 String acturl = driver.getCurrentUrl();
		 Assert.assertEquals(url, acturl);

	 }

}
