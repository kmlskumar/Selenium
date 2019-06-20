package Pagefactory;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
public void resize(WebElement elementToResize, int xOffset, int yOffset) {
    try {
        if (elementToResize.isDisplayed()) {
            Actions action = new Actions(driver);
            action.clickAndHold(elementToResize).moveByOffset(xOffset, yOffset).release().build().perform();
        } else {
            System.out.println("Element was not displayed to drag");
        }
    } catch (StaleElementReferenceException e) {
        System.out.println("Element with " + elementToResize + "is not attached to the page document "  + e.getStackTrace());
    } catch (NoSuchElementException e) {
        System.out.println("Element " + elementToResize + " was not found in DOM " + e.getStackTrace());
    } catch (Exception e) {
        System.out.println("Unable to resize" + elementToResize + " - " + e.getStackTrace());
    }
}
public void resizable_click()throws IOException{
	
	
	
	
}
	
	

public void resizeText(){
try{
	 WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
    WebElement resizeableElement = driver.findElement(By.cssSelector("#resizable > div.ui-resizable-handle.ui-resizable-e"));
    resize(resizeableElement, 50, 50);
}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
}


