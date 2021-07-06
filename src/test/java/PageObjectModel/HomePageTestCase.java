package PageObjectModel;

import org.testng.annotations.Test;

import Helper.ReadExcel;
import TestBase.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;






public class HomePageTestCase {
	WebDriver driver= null;
	ReadExcel e1 = null;
	TestBase tb = null;
	@BeforeTest
	public void Launch() throws IOException {
		
		 //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Praveen\\Documents\\Newfolder\\chromedriver.exe");
			
		WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.get("https://www.flipkart.com/");
			
			
			
			
			
	}
	
	
	
	
  @Test(dataProvider = "dp")
  public void SelectApplePhone(String Model,String URL) throws InterruptedException, IOException, RowsExceededException, WriteException{
	  //System.out.println(URL);
	  
	  //driver.get(URL);
	  tb = new TestBase();
	  
	  String url = tb.getObject("URL");
	  
	  driver.get(url);
	  
	  FlipkartTestCase f1 = new FlipkartTestCase(driver);
	  
	 String prc = f1.Selectphone(Model);
	 
	 System.out.println("Price for iPhone is: "+ prc);
	 
	 
	 e1.writeData(2, 1, prc);
  }
  
  
  @DataProvider
  public Object[][] dp() throws BiffException, IOException 
  {
	  e1 = new ReadExcel();
	int rowcount  = e1.getRowCount(0);
	  
	  Object[][] info = new Object[rowcount][2];
	  
	  for(int i=1; i < rowcount ;i++)
	  {
		  info[i][0]= e1.getData(0, 0, i);  // Model
		  info[i][1]= e1.getData(0, 1, i);   //URL
	  }
    return info;
  }
    
}
 