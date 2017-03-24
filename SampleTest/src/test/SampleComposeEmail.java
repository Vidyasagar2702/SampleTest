package test;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Constants;


public class SampleComposeEmail {

	
	WebDriver driver;

	 

	 @Test
	 public void test() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\mabernard\\Downloads\\chromedriver_win32\\chromedriver.exe");				
		 driver = new ChromeDriver();

		 driver.navigate().to(Constants.URL);		
		 WebDriverWait wait = new WebDriverWait(driver, 5000);
		 
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.idemail)));
		 driver.findElement(By.id(Constants.idemail)).sendKeys(Constants.UserName);
		 driver.findElement(By.id(Constants.idnext)).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.idpass)));
		 driver.findElement(By.id(Constants.idpass)).sendKeys(Constants.Password);
		 driver.findElement(By.id(Constants.idsign)).click();
		 wait.until(ExpectedConditions.urlToBe(Constants.inboxURL));
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 String compose = Constants.inboxURL+"?compose=new"; 		 
		 driver.navigate().to(compose);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 driver.findElement(By.className("vO")).sendKeys(Constants.sendermail);
		 driver.findElement(By.className("aoT")).sendKeys("QA Test");
		 driver.findElement(By.id(":ch")).sendKeys("QA Java Program");
		 driver.findElement(By.xpath("//*[@id=':b5']")).click();
		 
		 		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.navigate().to(Constants.inboxURL);
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
		 driver.navigate().to(Constants.sentURL);
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
		 boolean isTextPrest=driver.findElement(By.xpath("//*[contains(.,'QA Test')]")).isDisplayed();
		 
		 Assert.assertTrue(isTextPrest);
		 
		 driver.navigate().to(Constants.signoutURL);
		 try {
		 driver.switchTo().alert().accept();
		 }
		 catch(NoAlertPresentException ex)
		 {
			 ex.printStackTrace();
		 }
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.idsignout)));
		 driver.findElement(By.id(Constants.idsignout)).click();
		 By linktt = By.cssSelector(".hidden-small");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Assert.assertTrue(driver.findElement(linktt).isDisplayed());
		 driver.close();


	 }

	 
	 	
}
