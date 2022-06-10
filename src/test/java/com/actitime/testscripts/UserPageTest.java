package com.actitime.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;
import com.actitime.pages.LoginPage;
import com.actitime.pages.TimeTrackPage;
import com.actitime.pages.UserPage;
import com.actitime.utility.Log;

public class UserPageTest extends BaseTest {
	
	@Test(groups = {"Smoke"})
	public void verifyUserPage() throws Throwable {
		Log.startTestCase("verifyUserPage");
		Log.info("Navigated to given url");
		Log.info("Give Username and Paassword and click on singin button");
		new LoginPage().loginPage(new FileLib().readProprertyData(Prop_Path, "username"), new FileLib().readProprertyData(Prop_Path, "password"));
		Log.info("Login is sucessful");
		Log.info("Going to on Users Option");
		new TimeTrackPage().clickUser();
		Log.info("Going to verify User List Webpage Title ");
		Assert.assertEquals(new TimeTrackPage().getTitleofUserPage(),new FileLib().readProprertyData(Prop_Path, "userPageTitle"));
		Log.info("Sucessfully verified User List Webpage Title");
		Log.endTestCase("verifyUserPage");
		
	}
	@Test(groups = {"Sanity"})
	public void createUserList() throws Throwable {
		Log.startTestCase("verifyUserPage");
		Log.info("Navigated to given url");
		Log.info("Give Username and Paassword and click on singin button");
		new LoginPage().loginPage(new FileLib().readExcelData(Excel_Path, "Sheet1", 1, 0), new FileLib().readExcelData(Excel_Path, "Sheet1", 1, 1));
		Log.info("Login is sucessful");
		Log.info("Going to on Users Option");
		new TimeTrackPage().clickUser();
		Log.info("Going to create newuser with all deatils and click on save button");
		String fn = new FileLib().readExcelData(Excel_Path, "Sheet1", 0, 0);
		String ln=new FileLib().readExcelData(Excel_Path, "Sheet1", 0, 1);
		String mailId=new FileLib().readExcelData(Excel_Path, "Sheet1", 0, 2);
		new UserPage().createNewUser(fn, ln, mailId);
		Log.info("Going to verify Sucess message after creating new user");
		boolean result = new UserPage().verifySuccesMsg();
		Assert.assertTrue(result,"Success message Boolean values are nor same");
		Log.info("Sucessfully verified Sucess message of new user");
		Log.info("Going to click close button after verifying Sucess Message");
		new UserPage().clickCloseBtn();
		Log.endTestCase("verifyUserPage");
		
		
	}
	
	
	

}
