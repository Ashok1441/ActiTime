package com.actitime.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org. testng.Reporter;

import com.actitime.actions.Action;
import com.actitime.genericLib.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class MyListeners extends ExtentManager implements ITestListener  {
	
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.assignAuthor("ashok");
		extentTest.assignCategory("Smoke");
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.pass(result.getName()+" test method is Passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.fail(result.getName()+" test method is Failed");
		extentTest.fail(result.getThrowable());
		try {
			String path = new Action().screenShot(BaseTest.driver,result.getName());
			extentTest.fail("Failed test Screenshot is attached",MediaEntityBuilder.createScreenCaptureFromPath(path,result.getName()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.skip(result.getName()+" test method is Skipped");
		extentTest.skip(result.getThrowable());
		try {
			String path = new Action().screenShot(BaseTest.driver,result.getName());
			extentTest.skip("Failed test Screenshot is attached",MediaEntityBuilder.createScreenCaptureFromPath(path,result.getName()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
