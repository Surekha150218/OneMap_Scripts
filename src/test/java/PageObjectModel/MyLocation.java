package PageObjectModel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyLocation {
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
	public void validateMyLocation(){
		
		

		driver.findElement(By.xpath("//body[1]/div[1]/screenshot[1]/div[1]/div[8]/div[7]")).click();
		
		/*
		 * JavascriptExecutor jsDriver=(JavascriptExecutor)driver;
		 * 
		 * NgWebDriver ngdriver=new NgWebDriver(jsDriver);
		 */
		
		
		
	}
}
