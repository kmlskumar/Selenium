package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Pagefactory.DragAndDrop;

import Utility.Property_data;

public class ResizeAndDrag_Assignment_1Test extends BaseTest{
Property_data p;

SoftAssert s;
DragAndDrop drag;

@BeforeMethod
public void get_objet(){
	p= new Property_data();
	
	s=new SoftAssert();
	drag=new DragAndDrop(driver);
	
}
@Test(priority=1)
public void open_Demoqa() throws IOException, InterruptedException{
	test=extent.createTest("open demoqa url ");
	open_Browser();	
	test.log(Status.PASS, "denoqa url open successsfully");
}
@Test(priority=2)
public void perform_resize(){
	test=extent.createTest("Resize the text box");
	drag.Click_On_resize();
	test.log(Status.PASS, "click on resize link successsfuly");
	//drag.RresizeText();
	test.log(Status.PASS, "Resized text inbox successsfuly");
	s.assertAll();
}
@Test(priority=3)
public void perform_drag_drop() throws IOException, InterruptedException{
	test=extent.createTest("Drag and Drop ");
	drag.clic_on_Droppable();
	test.log(Status.PASS, "Droppable Clicked successsfuly");
	drag.dragAndDrop();
	test.log(Status.PASS, "Drag and drop successsfuly");
	boolean status=drag.dropped_isvisible();
	Assert.assertTrue(status, "Dropped is not visible ");
	test.log(Status.PASS, "Droped is  visible");
	Thread.sleep(3000);
	drag.dragAndDropBack();
	test.log(Status.PASS, "Drag Back and drop successsfuly");
	boolean status1=drag.dropped_isvisible();
	Assert.assertTrue(status1, "Dropped is not visible, after drop Back ");
	test.log(Status.PASS, "Droped is visible, after drop back");
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

