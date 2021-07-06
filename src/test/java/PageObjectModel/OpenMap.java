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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMap {

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
			
					
	}

	@Test
	public void CheckMultipleOptions() throws InterruptedException {
		
driver.findElement(By.xpath("//span[contains(text(),'Got it, do not show again')]//following-sibling::img")).click();
Thread.sleep(1000);

WebElement multipleoptions=driver.findElement(By.xpath("//a[@class=\"wb collapsed\"]"));

multipleoptions.click();
Thread.sleep(1000);
WebElement PopulationQuery=driver.findElement(By.xpath("(//span[@class=\"topView_text\" and contains(text(),'PopulationQuery')])[2]"));
String mainID=driver.getWindowHandle();
System.out.println("MainID :"+mainID);

PopulationQuery.click();
Set<String> windowIDs=driver.getWindowHandles();

int cnt = windowIDs.size();

System.out.println("Count is" + cnt);
		
for(String s:windowIDs) {
	
	System.out.println("windowIds :"+s);
	

	if(!s.equals(mainID)) {
		
		driver.switchTo().window(s);
		
		System.out.println("Childwindow Title is" + driver.getTitle());
		System.out.println("Childwindow ID is" + driver.getWindowHandle());
		
		Thread.sleep(1000);

		 WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Get Started')]"));
		 WebDriverWait wait =new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 Actions action =new Actions(driver);
		 action.moveToElement(element).build().perform(); 
		 action.moveToElement(element).click().build().perform(); 
		
	}
}


		
		
	}
	
}
