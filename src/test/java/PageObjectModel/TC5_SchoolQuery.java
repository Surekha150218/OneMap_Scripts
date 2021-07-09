package PageObjectModel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Object_Repository_Xpath.OneMap_FrontPage;
import Utilities.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC5_SchoolQuery {
WebDriver driver= null;
	
@BeforeMethod
public void Launch() throws IOException {
	
	Utilities.InitialSetup.Setup();	
		
		
				
}

@AfterMethod
public void TearDown() throws IOException {
	
DriverManager.killWebDriver();
		
		
				
}
	
	
	@Test
	public void Squery() throws InterruptedException {
		
		Functions.OneMapFunctions.Squery();
	}
	
	
	
}
