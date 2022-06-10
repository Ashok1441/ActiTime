package com.actitime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.actitime.actions.Action;
import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;

public class TimeTrackPage extends BaseTest {
	
	@FindBy(id="container_users") public WebElement user;
	
	public TimeTrackPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	
	public String getTitleOfTimetrack() throws Throwable {
		new Action().explicitWaitForTitle(driver, 20, new FileLib().readProprertyData(Prop_Path, "timeTrackPageTitle"));
		String title = new Action().getTitle(driver);
		return title;
	}
	
	public void clickUser() {
		user.click();
	}
	
	public String getTitleofUserPage() throws Throwable {
		new Action().explicitWaitForTitle(driver, 20, new FileLib().readProprertyData(Prop_Path, "userPageTitle"));
		String title = new Action().getTitle(driver);
		return title;
	}

}
