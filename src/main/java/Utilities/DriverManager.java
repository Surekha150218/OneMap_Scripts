package Utilities;


import Utilities.MyLogger;

import Utilities.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;



public class DriverManager {

  

    public static WebDriver createWebDriver(String browser) {

        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")){
        	WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.prompt_for_download", "false");
            chromePrefs.put("download.", "false");
            chromePrefs.put("download.default_directory", "DownloadedFiles");
            chromePrefs.put("safebrowsing.enabled", "false");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("start-maximized");
            options.setExperimentalOption("prefs", chromePrefs);
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new ChromeDriver(options);
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
;
            Driver.webDriver = driver;
        }

        return driver;
    }

    public static void killWebDriver(){
        Driver.webDriver.close();
        Driver.webDriver.quit();
    }

    
}