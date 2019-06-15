package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.Property_data;

public class BaseTest {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentHtmlReporter htmlReporter1;
	public static ExtentReports extent1;
	public static ExtentTest test1;
public static WebDriver driver;
	
Property_data p=new Property_data();
@BeforeSuite
public void report(){
	htmlReporter = new ExtentHtmlReporter(".\\Reports\\demoqa_reports.html");
	htmlReporter.config().setTheme(Theme.DARK);
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
}

public void open_Browser() throws IOException{
	
	
	p.read_data_from_propertyfile();
	if(p.getbrowser().equalsIgnoreCase("chrome")){
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-infobars","--start-maximized");
	System.setProperty("webdriver.chrome.driver", p.getDriverPath());
	driver =new ChromeDriver(options);
	driver.get(p.get_url());
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	else if(p.getbrowser().equalsIgnoreCase("firefox"))
	{
		  FirefoxOptions options = new FirefoxOptions();
		  //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
		  options.setCapability("marionette", true);
		  /*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		  capabilities.setCapability("moz:firefoxOptions", options);*/
		  System.setProperty("webdriver.gecko.driver", p.getDriverPath_firefox());
	    driver =new FirefoxDriver(options);
	        driver.get(p.get_url());
	   
	        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    
	}
	
}

public void open_Browser2() throws IOException{
	p.read_data_from_propertyfile();
	if(p.getbrowser().equalsIgnoreCase("chrome")){
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--disable-infobars","--start-maximized");
	System.setProperty("webdriver.chrome.driver", p.getDriverPath());
	driver =new ChromeDriver(options);
	driver.get(p.get_url2());
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	else if(p.getbrowser().equalsIgnoreCase("firefox"))
	{
		  FirefoxOptions options = new FirefoxOptions();
		  //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); 
		  options.setCapability("marionette", true);
		  /*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		  capabilities.setCapability("moz:firefoxOptions", options);*/
		  System.setProperty("webdriver.gecko.driver", p.getDriverPath_firefox());
	    driver =new FirefoxDriver(options);
	        driver.get(p.get_url2());
	   
	        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	    
	}
	
}
@AfterSuite
public void quit() throws InterruptedException{
    extent.flush();
   
    extent.close();
   
	Reporter.log("************BROWSER CLOSED SUCCESSFULLY*************");
	Thread.sleep(5000);
	driver.quit();
}
}
