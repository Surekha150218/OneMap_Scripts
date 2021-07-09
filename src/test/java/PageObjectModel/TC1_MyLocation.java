package PageObjectModel;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.paulhammant.ngwebdriver.NgWebDriver;
import Object_Repository_Xpath.OneMap_FrontPage;
import Utilities.DriverManager;
import Utilities.TakeScreenShot;
import Utilities.getCurrentDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1_MyLocation {

	WebDriver driver=null;
	ExtentTest logger;
	ExtentReports extent;
	String ResultPath=Utilities.ProjectConfigurations.LoadProperties("ResultPath");
	
	@BeforeTest
	public void setUp() {
		
		//extent = new ExtentReports(System.getProperty("user.dir")+ResultPath+"SeleniumReport.html",false);
		
		
	}
	@BeforeMethod
	public void Launch() throws IOException {
		
		Utilities.InitialSetup.Setup();	
			
					
	}

	@AfterMethod
public void TearDown() throws IOException {
		
	DriverManager.killWebDriver();
			
			
					
	}
	
	
	@Test
	public void validateMyLocation(){
		
		
		Functions.OneMapFunctions.validateMyLocation();
		
	}
}
