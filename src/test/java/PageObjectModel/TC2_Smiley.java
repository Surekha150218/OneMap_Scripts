package PageObjectModel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.OneMapFunctions;
import Object_Repository_Xpath.OneMap_FrontPage;
import Utilities.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2_Smiley {

	

	WebDriver driver= null;
	
	@BeforeMethod
	public void Launch() throws IOException {
		
		driver=DriverManager.createWebDriver("chrome");
		driver.get("https://www.onemap.gov.sg/main/v2/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OneMap_FrontPage.Frontpopup)).click();
			
			
					
	}
	
	@AfterMethod
	public void TearDown() throws IOException {
			
		DriverManager.killWebDriver();
				
				
						
		}
	
	@Test
	public void validateSimleytext() throws InterruptedException {
		
		

WebElement root=driver.findElement(By.tagName("wog-sentiments"));

WebElement shadowDOM=OneMapFunctions.getShadowDOM(root,driver);
WebElement div=shadowDOM.findElement(By.cssSelector("#wog--sentiments-content"));



WebElement root1=div.findElement(By.cssSelector(".hydrated"));
WebElement shadowDOM1=OneMapFunctions.getShadowDOM(root1,driver);

WebElement div1=shadowDOM.findElement(By.cssSelector("div"));




		
	}
	}
	
	
	
	
	
	
	
	
	

