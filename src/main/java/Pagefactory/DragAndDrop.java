package Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Utility.Wait;

import org.openqa.selenium.interactions.Actions;
public class DragAndDrop extends Wait {
	WebDriver driver;

	//**********locators by using factory method********
	@FindBy(xpath="//a[@href='https://demoqa.com/droppable/']")
	WebElement Dropable;
	@FindBy(xpath="//*[@id='draggable']")
	WebElement Dragme_From_here;
	
	@FindBy(xpath="//*[text()='Dropped!']")
	WebElement Dropped;
	
	@FindBy(xpath="//*[@id='droppable']")
	WebElement Drop_me_here;
	

	public DragAndDrop(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	//*****************Action method*********
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
		
		action.dragAndDrop(Drop_me_here,Dragme_From_here).build().perform(); 
		
	}
public boolean dropped_isvisible() throws InterruptedException{
	highlight(driver,Dropped);
	return isvisible(Dropped,driver);
	
}
	
}
