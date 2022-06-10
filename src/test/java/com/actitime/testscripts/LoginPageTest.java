package com.actitime.testscripts;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;
import com.actitime.pages.LoginPage;
import com.actitime.pages.TimeTrackPage;
import com.actitime.utility.ExtentManager;
import com.actitime.utility.Log;

public class LoginPageTest extends BaseTest {
	
	
	@Test(groups = {"Smoke","Sanity"})
	public void verifyLoginPageTitle() throws Throwable {
		
		new ExtentManager().extentTest.assignAuthor("Kumar");
		new ExtentManager().extentTest.assignCategory("Sanity");
		
		
		Log.startTestCase("verifyLoginPageTitle");
		Log.info("Navigated to given url");
		Log.info("Going to verify  Login page Title");
		String title=new LoginPage().verifyLoginPage();
		Assert.assertEquals(title, new FileLib().readProprertyData(Prop_Path, "loginPageTitle"));
		Log.info("Sucessfully verified Login page Title");
		Log.endTestCase("verifyLoginPageTitle");
		
	}
	
	
	@Test(groups = {"Sanity","Regression"})
	public void loginTest() throws Throwable {
		Log.startTestCase("loginTest");
		Log.info("Navigated to given url");
		Log.info("Give Username and Paassword and click on singin button");
		new LoginPage().loginPage(new FileLib().readProprertyData(Prop_Path, "username"), new FileLib().readProprertyData(Prop_Path, "password"));
		Log.info("Login is sucessful");
		Log.info("Going to verify Webpage Title after Login");
		Assert.assertEquals(new TimeTrackPage().getTitleOfTimetrack() , new FileLib().readProprertyData(Prop_Path, "timeTrackPageTitle"));
		Log.info("Sucessfully verified Webpage Title");
		Log.endTestCase("loginTest");
	}
	

}
