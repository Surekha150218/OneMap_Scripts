package Utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class fn_Scroll_to_WebElement 
{
	public static boolean scrollToWebElement(WebDriver driver,WebElement Element)
	{
		boolean res = false;
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			res = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception " + e + " occured while scrolling to webelement " + Element);
			res = false;
		}
		finally
		{
			return res;
		}
	}
}
