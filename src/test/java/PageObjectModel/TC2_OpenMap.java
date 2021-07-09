package PageObjectModel;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Object_Repository_Xpath.OneMap_FrontPage;
import TestBase.TestBase;
import Utilities.DriverManager;
import Utilities.TakeScreenShot;
import Utilities.getCurrentDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2_OpenMap {

	
	boolean res =false;
	@BeforeMethod
	public void Launch() throws IOException {
		
		
		Utilities.InitialSetup.Setup();	
			
					
	}

	@AfterMethod
public void TearDown() throws IOException {
		
	DriverManager.killWebDriver();
			
			
					
	}
	

	@Test
	public void CheckMultipleOptions() throws InterruptedException {
		
		
		res=Functions.OneMapFunctions.CheckMultipleOptions();
		if(res) {
			Assert.assertTrue(true);
		}else {
			System.out.println("Test Case is failed");
			Assert.assertTrue(false);
			
		}
		
	}
	
}
