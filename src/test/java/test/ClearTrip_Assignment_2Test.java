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
	public void perform_drag_drop() throws IOException{
		open_Browser2();
		test=extent.createTest("Open_cleartrip.com");
		
		
		
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

