package PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities {
	
	public static WebElement getShadowDOM(WebElement element,WebDriver driver){


		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement shadowDOM=(WebElement)js.executeScript("return arguments[0].shadowRoot",element);
		return shadowDOM;

	}

		

}
