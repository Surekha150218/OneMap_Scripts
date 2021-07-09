package Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Object_Repository_Xpath.OneMap_FrontPage;
import TestBase.TestBase;

public class InitialSetup {

	static WebDriver driver= null;
	static WebDriverWait wait= null;
	
	
	public static void Setup() throws IOException {
		
		
		driver=DriverManager.createWebDriver("chrome");
		driver.get(TestBase.getObject("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OneMap_FrontPage.Frontpopup))));
		String Screenshotpath=System.getProperty("Screenshotpath");
		String Sc=Screenshotpath+"/"+getCurrentDate.getTimeStamp()+".png"; 
		TakeScreenShot.saveScreenShot(Sc, driver);
		driver.findElement(By.xpath(OneMap_FrontPage.Frontpopup)).click();
	}
}
