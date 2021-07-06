package PageObjectModel;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.NoSuchElementException;

public class FlipkartTestCase {
	static WebDriver driver ;
	
By Searchtextbox = By.name("q");
By Brand = By.xpath("//section[5]//div[2]//div[1]//div[1]//div[1]//div[1]//label[1]//div[1]");
By InterStrgbtn = By.xpath("//body/div[@id='container']/div/div[@class='t-0M7P _2doH3V']/div[@class='_3e7xtJ']/div[@class='_1HmYoV hCUpcT']/div[@class='_1HmYoV _35HD7C']/div[@class='_1HmYoV _35HD7C col-12-12']/div[@class='bhgxx2 col-12-12']/div[@class='_1YuAuf']/section[7]/div[1]//*[local-name()='svg']//*[name()='path' and contains(@class,'_1ooUW7')]");
By InternalStorage = By.xpath("//section[7]//div[2]//div[1]//div[1]//div[1]//div[1]//label[1]//div[1]");
By PhoneModel = By.xpath("//div[contains(text(),'Apple iPhone 11 Pro (Gold, 256 GB)')]");
By NotifymeButton = By.xpath("//button[@class='_2AkmmA _3-iCOr wvj5kH']");
By PhonePrice = By.xpath("//body/div[@id='container']/div/div[@class='t-0M7P _2doH3V']/div[@class='_3e7xtJ']/div[@class='_1HmYoV hCUpcT']/div[@class='_1HmYoV _35HD7C']/div[14]/div[1]/div[1]/div[1]/a[1]/div[2]/div[2]");

	public FlipkartTestCase(WebDriver driver) {
		
		this.driver= driver;
	}
	
	
	
    //driver.manage().window().maximize();
	
	//Choose URL from NotePad
		/*public String URL() throws IOException
		{
			
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Praveen\\IMP.properties");
			p.load(fis);
			String url = p.getProperty("URL");
			System.out.println(url);
			
			return url;
			
		}*/
	//Capture Screenshot
public static void screensht() throws IOException{
		
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		
		String time = df.format(d);
		
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File f2 = new File("src\\main\\java\\Screenshots\\img" + time + ".png");
		
		FileUtils.copyFile(f1, f2);
		
		
	}
	//Select Phones
public String Selectphone(String Mdl) throws InterruptedException, IOException
{
	
	
	
	Actions act = new Actions(driver);
	act.sendKeys(Keys.ESCAPE).build().perform();
	Thread.sleep(2000);
	
	driver.findElement(Searchtextbox).sendKeys(Mdl);
	
	
	act.sendKeys(Keys.ENTER).build().perform();
	
	driver.manage().window().maximize();
	
	Thread.sleep(2000);
	driver.findElement(Brand).click();
	
	FlipkartTestCase.screensht();//capture screenshot
	Thread.sleep(1000);
	
	driver.findElement(InterStrgbtn).click();
	
	Thread.sleep(1000);
	driver.findElement(InternalStorage).click();
	
	
	Thread.sleep(3000);
	 String mainID = driver.getWindowHandle();
		
	  driver.switchTo().window(mainID);
	  
	  System.out.println("MainID is " + mainID );
	  Thread.sleep(5000);
	
	  String phnprice = driver.findElement(PhoneModel).findElement(PhonePrice).getText();
		System.out.println(phnprice);
	  driver.findElement(PhoneModel).click();
	
	  FlipkartTestCase.screensht();
	  
	
	Set<String> IDs = driver.getWindowHandles();
	
	int cnt =IDs.size();
	
	System.out.println("Ids" + cnt);
	
	for(String s:IDs) {
		
		if(!s.equals(mainID)) {
			
			
			driver.switchTo().window(s);
			
			
			System.out.println("Childwindow Title is" + driver.getTitle());
			System.out.println("Childwindow ID is" + driver.getWindowHandle());
			//driver.findElement(NotifymeButton).click();
			
		}
		
		else {
			
			 driver.switchTo().window(s);
				
				System.out.println("Mainwindow Title is" + driver.getTitle());
				System.out.println("Mianwindow ID is" + driver.getWindowHandle());
		}
		
	}
	return phnprice;

}
	

}
