package Pagefactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.Property_data;

public class Resize{
	
WebDriver driver;

//**********locators by using factory method********
@FindBy(xpath="//*[text()='Resizable']")
WebElement resize;

@FindBy(xpath="//*[@class='demo-frame']")
WebElement resize_box;

@FindBy(xpath="//*[@id='resizable']")
WebElement resize_text;



//*******************wait**********

public Resize(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
}
	



//*****************Action method*********
public void resizable_click()throws IOException{
	resize.click();
}
	
	

public void resizeText(){
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("demo-frame")));
	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/div[2]")));
	WebElement widget = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
	Actions action = new Actions(driver);
	// Code for resize 
	action.clickAndHold(widget).moveByOffset(120, 120).release().build().perform();
	System.out.println("abc");
}
}