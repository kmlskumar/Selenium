package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public boolean isvisible(WebElement webe,WebDriver driver){
		 try
		 { 
			     WebDriverWait wait = new WebDriverWait(driver,20);
			     wait.until(ExpectedConditions.visibilityOf(webe));
			     return true;
		 }
		  catch (Exception e)
		 {
			     return false;
	     }
	 }
	
	public void highlight(WebDriver driver, WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		Thread.sleep(1000);
		try {
			Thread.sleep(500);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
}
