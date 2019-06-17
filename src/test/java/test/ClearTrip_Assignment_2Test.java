package test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Pagefactory.ClearTrip;
import Pagefactory.DragAndDrop;

import Utility.Property_data;

public class ClearTrip_Assignment_2Test extends BaseTest{
	Property_data p;
	ClearTrip clear;
	SoftAssert s;

	@BeforeMethod
	public void get_objet(){
		p= new Property_data();
		clear=new ClearTrip(driver);
		s=new SoftAssert();
		
	}
	@Test(priority=1)
	public void open_application_url() throws IOException, InterruptedException{
		
		test=extent.createTest("Open_cleartrip.com");
		open_Browser2();
		test.log(Status.PASS, "open cleartrip successfully");
		
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void select_from_city() throws InterruptedException, IOException{
		test=extent.createTest("selct From city");
        clear.Select_Round_trip();
        test.log(Status.PASS, "selct Round Trip successfully");
		clear.select_from_city();
		test.log(Status.PASS, "select from city successfully");
		s.assertAll();
	}
	@Test(priority=3)
	public void select_To_city() throws InterruptedException, IOException{
		test=extent.createTest("Select to city");
		clear.select_To_city();
		test.log(Status.PASS, "select To city successfully");
		s.assertAll();
	}
	@Test(priority=4)
	
	public void select_Datepicker() throws InterruptedException, IOException{
		test=extent.createTest("Select date picket");
		clear.Select_Departaon_Datepicker();
		test.log(Status.PASS, "select from Date successfully");
		clear.Select_ReturnOn_Datepicker();
		test.log(Status.PASS, "select To date successfully");
		s.assertAll();
	}
	@Test(priority=5)
	public void click_On_Search() throws InterruptedException, IOException{
		test=extent.createTest("Search Flight");
		clear.search_click();
		
		test.log(Status.PASS, " click on search successfully");
		s.assertAll();
	}
	
	
	@AfterMethod
		public void after(ITestResult result) throws IOException {

			if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS,
					
						MarkupHelper.createLabel(result.getName().toUpperCase() + "-Test Case Passed ", ExtentColor.GREEN));
			}
				else if(result.getStatus()==ITestResult.FAILURE){
					  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" is Failed ", ExtentColor.RED));
					  test.fail(result.getThrowable().getMessage());}
				else{
					  test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +" is Skipped ", ExtentColor.YELLOW));
					  test.skip(result.getThrowable().getMessage());
				}
					  
			

			
		}}

