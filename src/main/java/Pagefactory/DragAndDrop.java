package Pagefactory;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Wait;

import org.openqa.selenium.interactions.Actions;
public class DragAndDrop extends Wait {
	WebDriver driver;

	//**********locators by using factory method********
	@FindBy(xpath="//*[text()='Resizable']")
	WebElement resize;

	@FindBy(xpath="//*[@class='demo-frame']")
	WebElement resize_box;

	@FindBy(xpath="//*[@id='resizable']")
	WebElement resize_text;
	
	
	@FindBy(xpath="//a[@href='https://demoqa.com/droppable/']")
	WebElement Dropable;
	@FindBy(xpath="//*[@id='draggable']")
	WebElement Dragme_From_here;
	
	@FindBy(xpath="//*[text()='Dropped!']")
	WebElement Dropped;
	
	@FindBy(xpath="//*[@id='droppable']")
	WebElement Drop_me_here;
	@FindBy(xpath="//*[@id='content,]/h1")
	WebElement Drop_me_bck;
	
	

	public DragAndDrop(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	//*****************Action method*********
	
	public void Click_On_resize(){
		try{
			
			Actions action = new Actions(driver);
			action.moveToElement(resize).click().build().perform();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clic_on_Droppable(){
		Actions action = new Actions(driver);
		action.moveToElement(Dropable).click().build().perform();
		//Dropable.click();
	}
	public void dragAndDrop(){
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(Dragme_From_here,Drop_me_here).build().perform(); 
	}
	
public void dragAndDropBack(){
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(Dragme_From_here,Drop_me_here).build().perform(); 
		
	}

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

	
	

public void RresizeText(){
try{
	WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#content > div.demo-frame")));
    WebElement resizeableElement = driver.findElement(By.cssSelector("#resizable > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
    resize(resizeableElement, 200, 200);
}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
public boolean dropped_isvisible() throws InterruptedException{
	highlight(driver,Dropped);
	return isvisible(Dropped,driver);
	
}
	
}
