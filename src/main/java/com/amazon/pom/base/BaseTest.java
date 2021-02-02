package com.amazon.pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.pom.utils.CommonUtils;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseTest(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/amazon/pom/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browserName");
		String url = prop.getProperty("url");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saheli\\Documents\\myJava\\Selenium Files\\WEBDRIVERS - IE CR FF\\chromedriver_win32_2021\\chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();  
            options.addArguments("test-type");
            options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Saheli\\Documents\\myJava\\Selenium Files\\WEBDRIVERS - IE CR FF\\geckodriver-v0.15.0-win32\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.get(url);

		driver.manage().timeouts().pageLoadTimeout(CommonUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CommonUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
	}
	
	
}
