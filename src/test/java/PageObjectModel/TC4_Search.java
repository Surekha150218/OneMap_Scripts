package PageObjectModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Object_Repository_Xpath.OneMap_FrontPage;
import Utilities.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.read.biff.BiffException;

public class TC4_Search {

	
WebDriver driver= null;
boolean res=false;
String search,hospitalname;	
@BeforeMethod
public void Launch() throws IOException {
	

	Utilities.InitialSetup.Setup();	
		
		
		
				
}

@AfterMethod
public void TearDown() throws IOException {
	
DriverManager.killWebDriver();
		
		
				
}
	
	@Test(dataProvider="getTestData")
	public void ValidateSearch() throws InterruptedException{
		
		
		res=Functions.OneMapFunctions.ValidateSearch(search,hospitalname);
		if(res) {
			Assert.assertTrue(true);
		}else {
			System.out.println("Test Case is failed");
			Assert.assertTrue(false);
			
		
		
	
		
		
	}
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() throws BiffException, IOException{
		
		ArrayList<Object[]> testData =Utilities.GetdatafromExcel.getDataFromExcel();
		
		return testData.iterator();
	}
}
