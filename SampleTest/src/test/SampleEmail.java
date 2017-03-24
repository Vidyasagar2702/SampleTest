package test;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Constants;


public class SampleEmail {

	
	WebDriver driver;

	 

	 @Test
	 public void test() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\mabernard\\Downloads\\chromedriver_win32\\chromedriver.exe");	
			
		  	//System.setProperty("webdriver.firefox.marionette","C:\\Users\\mabernard\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		 driver = new ChromeDriver();

		 //ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"TestData");
		 driver.navigate().to(Constants.URL);
		
		 WebDriverWait wait = new WebDriverWait(driver, 5000);
		 By.id(":2x");

		 //String email = ExcelUtils.getCellData(1, 1);
		 //String password = ExcelUtils.getCellData(1, 2);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.idemail)));
		 driver.findElement(By.id(Constants.idemail)).sendKeys(Constants.UserName);
		 driver.findElement(By.id(Constants.idnext)).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.idpass)));
		 driver.findElement(By.id(Constants.idpass)).sendKeys(Constants.Password);
		 driver.findElement(By.id(Constants.idsign)).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.idsearch)));
		 //String searchkey = ExcelUtils.getCellData(1, 3);		 	
		 driver.findElement(By.id(Constants.idsearch)).sendKeys(Constants.SearchKey);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.idsearchenter)));
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.findElement(By.id(Constants.idsearchenter)).click();

		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		 
		 Boolean isPresent = existsElement("//span[contains(.,'No messages matched your search. Try using')]");
	     int count= 0;
		 driver.findElements(By.xpath("//*[@role='checkbox']")).get(count+1).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 By del= By.xpath(Constants.xpathdel);
		 wait.until(ExpectedConditions.presenceOfElementLocated(del));
		 driver.findElement(del).click();
		 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 driver.navigate().to(Constants.searchURL);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 try {
			 driver.switchTo().alert().accept();
			 }
			 catch(NoAlertPresentException ex)
			 {
				 ex.printStackTrace();
			 }
		 
		 wait.until(ExpectedConditions.urlToBe(Constants.searchURL));
		 while(!isPresent)
		 {
			
			 isPresent = existsElement("//span[contains(.,'No messages matched your search. Try using')]");
		 
			 int maxcount = driver.findElements(By.xpath("//*[@role='checkbox']")).size();
			 /*System.out.println(Integer.toString(maxcount));*/
			 if(maxcount > 0)
			 {
		 
			 try{
				 driver.findElements(By.xpath("//*[@role='checkbox']")).get(count).click();
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 wait.until(ExpectedConditions.presenceOfElementLocated(del));
				 driver.findElement(del).click();
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 driver.navigate().to(Constants.searchURL);
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 
				 try {
					 driver.switchTo().alert().accept();
					 }
					 catch(NoAlertPresentException ex)
					 {
						 ex.printStackTrace();
					 }
				 
				 wait.until(ExpectedConditions.urlToBe(Constants.searchURL));				 
             }
			 catch (ElementNotVisibleException e) { //when no elements are found
		            System.out.println("Element not visble");
		            break;
		        
		        }
			    
					 
			 }
		 }
		 
		 
		 driver.navigate().to(Constants.trashURL);
		 try {
		 driver.switchTo().alert().accept();
		 }
		 catch(NoAlertPresentException ex)
		 {
			 ex.printStackTrace();
		 }
		 wait.until(ExpectedConditions.urlToBe(Constants.trashURL));

		 /*
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Empty Bin now')]")));
			 driver.findElement(By.xpath("//span[contains(.,'Empty Bin now')]")).click();
		 */
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'Empty Trash now')]")));
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//span[contains(.,'Empty Trash now')]")).click();

		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".J-at1-atl")));
		 driver.findElement(By.cssSelector(".J-at1-atl")).click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".b8 > div:nth-child(1) > div:nth-child(2)")));

		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gb_71")));
		 
		 
		 driver.navigate().to("https://accounts.google.com/SignOutOptions?");
		 try {
		 driver.switchTo().alert().accept();
		 }
		 catch(NoAlertPresentException ex)
		 {
			 ex.printStackTrace();
		 }
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signout")));
		 driver.findElement(By.id("signout")).click();
		 By linktt = By.cssSelector(".hidden-small");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 Assert.assertTrue(driver.findElement(linktt).isDisplayed());
		 driver.close();


	 }

	 
	 	private boolean existsElement(String id) {
		    try {
		        driver.findElement(By.xpath(id));
		    } catch (NoSuchElementException e) {
		        return false;
		    }
		    return true;
		}
}
