package WesternUnion_NZsitePageClass;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import TestBaseClass.TestBase;
import Utilities.ScreenshotCapture;
import WesternUnion_NZsitePage.TrackTransferPage;

public class TrackTransferClass extends TestBase
{
	
	@BeforeMethod
	public void CreateTest(Method method)
	{
		e3=e2.createTest(this.getClass().getSimpleName() + " : : "+ method.getName() + " started");
	}
	
	@AfterMethod
	public void GetResult(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			e3.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.GREEN));
			e3.log(Status.PASS, result.getMethod().getMethodName() + " module has been successfully passed.");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			e3.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.RED));
			e3.log(Status.FAIL, result.getThrowable());
			String capture=ScreenshotCapture.CaptureScreenshot(driver, result.getMethod().getMethodName()+ " module");
			e3.addScreenCaptureFromPath(capture);
			e3.log(Status.FAIL, result.getMethod().getMethodName() + " module has been failed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			e3.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName(), ExtentColor.ORANGE));
			e3.log(Status.SKIP, result.getThrowable());
			e3.log(Status.FAIL, result.getMethod().getMethodName() + " module has been skipped");
		}
	}
	
	TrackTransferPage ObjTrackTransferPage;
	
	@Test(priority=0)
	public void TrackTransferModule()
	{
		e3.log(Status.INFO, "TrackTransferModule started now");
		ObjTrackTransferPage=PageFactory.initElements(driver, TrackTransferPage.class);
		ObjTrackTransferPage.TrackTransferModule();
	}
	
	@Test(priority=1)
	public void EnterWrongMTCNNumber()
	{
		e3.log(Status.INFO, "TrackTransferModule started now");
		ObjTrackTransferPage.EnterwrongMTCNnumber("2342342349");
	}
	
	@Test(priority=2)
	public void ErrorMessageInString()
	{
		e3.log(Status.INFO, "ErrorMessageInString started now");
		String Message_Error=ObjTrackTransferPage.ErrorMessageInStringForm();
		System.out.println(Message_Error);
		String strMessage="We can't find that transfer. Please check and re-enter the information below.";
		System.out.println("The error message is ==> : " + Message_Error);
		Assert.assertEquals(Message_Error, strMessage, "Error message is correct.");
	}
	
	@Test(priority=3)
	public void ErrorMessageInNumber()
	{
		e3.log(Status.INFO, "ErrorMessageInNumber started now");
		String Message_ErrorNumber=ObjTrackTransferPage.ErrorMessageInNumberForm();
		System.out.println(Message_ErrorNumber);
		String strErrorMessage="C1620";
		System.out.println("The error number is ==> : " + Message_ErrorNumber);
		Assert.assertEquals(Message_ErrorNumber,strErrorMessage, "Error is number is valid one.");
	}
	
	@Test(priority=4)
	public void EnterCorrectMTCNnumber() throws InterruptedException
	{
		e3.log(Status.INFO, "EnterCorrectMTCNnumber started now");
		ObjTrackTransferPage.EnterCorrectMTCNnumber("7485054208");
	}
	
	@Test(priority=5)
	public void StatusOfValidMTCNnumber() throws InterruptedException
	{
		Thread.sleep(3000);
		e3.log(Status.INFO, "StatusOfValidMTCNnumber started now");
		String Status=ObjTrackTransferPage.StatusOfCorrectMTCNnumber();
		System.out.println("Current Status of MTCN is ===> : "+ Status);
	}
	
	@Test(priority=6)
	public void TrackNewTransfer() throws InterruptedException
	{
		e3.log(Status.INFO, "TrackNewTransfer started now");
		ObjTrackTransferPage.TrackNewtransfer();
	}
	
	@Test(priority=7)
	public void DontHaveMTCNNumber() throws InterruptedException
	{
		e3.log(Status.INFO, "DontHaveMTCNNumber started now");
		ObjTrackTransferPage.WhenWeDontHaveMTCNNnumber();
		
	}
	@Test(priority=8)
	public void SearchMTCNWithoutMTCNNumber()
	{
		e3.log(Status.INFO, "Search MTCN Without MTCN Number started now");
		System.out.println("Skipping this test as this is not yet ready for testing..");
		throw new SkipException("Skipping this test as this is not yet ready for testing..");
	}
	
	@Test(priority=9)
	public void FailingThisMethod()
	{
		e3.log(Status.INFO, "FailingThisMethod started now");
		System.out.println("failing this one.");
		Assert.assertEquals(false, true);
	}
	
	@Test(priority=10)
	public void SenderPhoneNumberModule() throws InterruptedException
	{
		ObjTrackTransferPage.SenderPhoneNumber("38985976443", "1000", "In");
	}

}
