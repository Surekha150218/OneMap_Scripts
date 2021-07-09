package Utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public  class TakeScreenShot {

	
	public static void saveScreenShot(String FolderPath,WebDriver driver){
//		FolderPath=System.getProperty("user.dir")+FolderPath;
		File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrnsht, new File(FolderPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

	public static void saveScreenShot(String FolderPath, Alert alert) {
		File scrnsht =((TakesScreenshot)alert).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrnsht, new File(FolderPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}