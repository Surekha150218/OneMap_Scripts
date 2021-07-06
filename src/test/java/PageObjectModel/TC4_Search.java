package PageObjectModel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC4_Search {

	
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
	public void ValidateSearch() throws InterruptedException{
		
		
		WebElement search=driver.findElement(By.xpath("//input[@id='search-text']"));
		
		search.sendKeys("hospi");
		//search.click();
		try {
		List<WebElement> lists=driver.findElements(By.xpath("(//div[@id='search-scroller'])[1]//descendant::div[@class='item ng-scope']"));
		
		
		for(int i=0;i<=lists.size();i++) {
			
			
			String s=lists.get(i).getText();
			System.out.println("Lists are :"+s);
			if(s.equalsIgnoreCase("FIRST HOSPITAL AVENUE"))
				lists.get(i).click();
			
			
		}
		}catch(StaleElementReferenceException e) {
			
			System.out.println("Exception occurs");
			Thread.sleep(2000);
			
			
		}
		
		
	
		
		
	}
}
