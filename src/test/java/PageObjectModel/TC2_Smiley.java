package PageObjectModel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2_Smiley {

	

	WebDriver driver= null;
	
	@BeforeMethod
	public void Launch() throws IOException {
		
		 //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Documents\\Newfolder\\chromedriver.exe");
			
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.onemap.gov.sg/main/v2/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//span[contains(text(),'Got it, do not show again')]//following-sibling::img")).click();
			
			
					
	}
	

	
	@Test
	public void validateSimleytext() throws InterruptedException {
		
		

WebElement root=driver.findElement(By.tagName("wog-sentiments"));

WebElement shadowDOM=Utilities.getShadowDOM(root,driver);
WebElement div=shadowDOM.findElement(By.cssSelector("#wog--sentiments-content"));



WebElement root1=div.findElement(By.cssSelector(".hydrated"));
WebElement shadowDOM1=Utilities.getShadowDOM(root1,driver);

WebElement div1=shadowDOM.findElement(By.cssSelector("div"));
Actions action=new Actions(driver);

action.moveToElement(div1).build().perform();
Thread.sleep(2000);
String h3=div1.findElement(By.cssSelector("h3")).getText();
System.out.println(h3);

	/*
		 * WebElement div1=shadowDOM.findElement(By.
		 * cssSelector("div.wog--flex wog--items-center wog--justify-center wog--inline-flex wog--floating-button wog--float-bottom-left"
		 * ));
		 * 
		 * 
		 * Actions action=new Actions(driver);
		 * 
		 * action.moveToElement(div1).build().perform();
		 */


		
	}
	}
	
	
	
	
	
	
	
	
	

