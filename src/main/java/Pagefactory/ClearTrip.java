package Pagefactory;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Utility.Property_data;
import Utility.Wait;

public class ClearTrip extends Wait{
	WebDriver driver;
	Property_data p=new Property_data();

	//**********locators by using factory method********
	@FindBy(xpath="//*[@id='RoundTrip']")
	WebElement Round_Trip;
	@FindBy(xpath="//*[@id='FromTag']")
	WebElement From;
	@FindBy(xpath="//*[@id='ui-id-34']")
	WebElement select_From_city;
	@FindBy(xpath="//*[@id='ToTag']")
	WebElement To;
	@FindBy(xpath="//*[@id='ui-id-39']")
	WebElement select_To_city;
	
	@FindBy(xpath="//*[@id='DepartDate']")
	WebElement Depart_on;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[5]/a")
	WebElement Select_Depart_on_date;
	@FindBy(xpath="//*[@id='ReturnDate']")
	WebElement Return_on;
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[5]/a")
	WebElement Select_Return_on_date;
	@FindBy(xpath="//*[@id='SearchBtn']")
	WebElement Search_flights;
	
	
	
	public ClearTrip(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	public void CloseWindowPopup(){
		try{
			System.out.println(driver.switchTo().alert().getText());
		
		    driver.switchTo().alert().dismiss();

		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		}
		catch(Exception e){
		e.printStackTrace();
		}
	}
	public void Select_Round_trip() throws InterruptedException{
		//highlight(driver,Round_Trip);
		Round_Trip.click();
		
	}
	public void select_from_city() throws InterruptedException, IOException{
		p.read_data_from_propertyfile();
		//highlight(driver,From);
		From.click();
		From.sendKeys(p.get_from_city());
		Thread.sleep(2000);
		//select_From_city.click();
		
		
	}
	public void select_To_city() throws IOException, InterruptedException{
		p.read_data_from_propertyfile();
		//highlight(driver,To);
		To.click();
		To.sendKeys(p.get_To_city());
		Thread.sleep(2000);
		//select_To_city.click();
	}
	public void Select_Departaon_Datepicker() throws InterruptedException{
		//highlight(driver,Depart_on);
		Depart_on.click();
		Thread.sleep(2000);
		Select_Depart_on_date.click();
		
	}
	
	public void Select_ReturnOn_Datepicker() throws InterruptedException{
		//highlight(driver,Return_on);
		Return_on.click();
		Thread.sleep(2000);
		Select_Return_on_date.click();
	}
	public void search_click() throws InterruptedException{
		//highlight(driver,Search_flights);
		Search_flights.click();
		Thread.sleep(20000);
		driver.close();
	}
		
}
