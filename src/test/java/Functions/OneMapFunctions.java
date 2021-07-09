package Functions;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Object_Repository_Xpath.OneMap_FrontPage;
import Utilities.TakeScreenShot;
import Utilities.getCurrentDate;

public class OneMapFunctions {

	static WebDriver driver=null;
	static WebDriverWait wait  =new WebDriverWait(driver,20);
	
	public static WebElement getShadowDOM(WebElement element,WebDriver driver){


		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement shadowDOM=(WebElement)js.executeScript("return arguments[0].shadowRoot",element);
		return shadowDOM;

	}
	
	public static boolean CheckMultipleOptions() throws InterruptedException {
		
		/*
		 * driver.findElement(By.
		 * xpath("//span[contains(text(),'Got it, do not show again')]//following-sibling::img"
		 * )).click(); Thread.sleep(1000);
		 */
		boolean res=false;
   
   WebElement multipleoptions=driver.findElement(By.xpath(OneMap_FrontPage.multipleoptions));

   multipleoptions.click();
   Thread.sleep(1000);
   WebElement PopulationQuery=driver.findElement(By.xpath(OneMap_FrontPage.PopulationQuery));
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

		 WebElement element=driver.findElement(By.xpath(OneMap_FrontPage.element));
		 WebDriverWait wait =new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 Actions action =new Actions(driver);
		 action.moveToElement(element).build().perform(); 
		 action.moveToElement(element).click().build().perform(); 
		 res=true;
		
	}
}


	return res;	
		
	}
	
	public static boolean validateSimleytext() throws InterruptedException {
		
		boolean res=false;

		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement smiley=(WebElement)jse.executeScript(OneMap_FrontPage.smiley);
		if(smiley!=null) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", smiley);
		res=true;
		}
		return res;




				
			}
	
	
	public static boolean ValidateSearch(String Search,String hospitalname) throws InterruptedException{
		
		boolean res=false;
		WebElement search=driver.findElement(By.xpath(OneMap_FrontPage.search));
		
		search.sendKeys(Search);
		//search.click();
		try {
		List<WebElement> lists=driver.findElements(By.xpath(OneMap_FrontPage.lists));
		
		
		for(int i=0;i<=lists.size();i++) {
			
			
			String s=lists.get(i).getText();
			System.out.println("Lists are :"+s);
			if(s.equalsIgnoreCase(hospitalname)) {
				lists.get(i).click();
				res=true;
			}
			
			
			
		}
		}catch(StaleElementReferenceException e) {
			
			System.out.println("Exception occurs");
			Thread.sleep(2000);
			
			
		}
		
		return res;
	
	}	
		
public static void Squery() {
		
		WebElement schoolquery=driver.findElement(By.xpath(OneMap_FrontPage.SchoolQuery));
		schoolquery.click();	
		WebElement Secinfo=driver.findElement(By.xpath(OneMap_FrontPage.sec));
		Secinfo.click();
		WebElement agreebuttton=driver.findElement(By.xpath(OneMap_FrontPage.Agreebutton));
		agreebuttton.click();
	}


public static void validateMyLocation(){
	
	
	System.out.println("neMap_FrontPage.Location "+OneMap_FrontPage.Location);
	
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(OneMap_FrontPage.Location))));
	String Screenshotpath=System.getProperty("Screenshotpath");
	String Sc=Screenshotpath+"/"+getCurrentDate.getTimeStamp()+".png"; 
	TakeScreenShot.saveScreenShot(Sc, driver);
	driver.findElement(By.xpath(OneMap_FrontPage.Location)).click();
	
	/*
	 * JavascriptExecutor jsDriver=(JavascriptExecutor)driver;
	 * 
	 * NgWebDriver ngdriver=new NgWebDriver(jsDriver);
	 */
	
	
	
}
}
