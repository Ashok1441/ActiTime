package com.actitime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.actions.Action;
import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;

public class UserPage extends BaseTest {
	
	@FindBy(xpath="//div[text()='New User']") public WebElement newUserBtn;
	@FindBy(id="createUserPanel_firstNameField") public WebElement firstName;
	@FindBy(id="createUserPanel_lastNameField") public WebElement lastName;
	@FindBy(id="createUserPanel_emailField") public WebElement email;
	@FindBy(xpath="(//div[text()='-- department not assigned --'])[1]") public WebElement clickDepartment;
	@FindBy(xpath="//div/div[2]/div[text()='Quality Control']") public WebElement selectQualityDept;
	@FindBy(xpath="//div[text()='Save & Send Invitation']") public WebElement saveButton;
	@FindBy(xpath="//div[contains(text(),'Account for')]") public WebElement sucessMsg;
	@FindBy(xpath="(//span[text()='Close'])[1]") public WebElement closeBtn;
	
	
	public UserPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	public void createNewUser(String fn,String ln,String mailId) throws Exception  { //
		newUserBtn.click();
		new Action().fluentWait(driver, firstName, 10);
		new Action().type(firstName,fn);
		new Action().type(lastName,ln);
		new Action().type(email,mailId);
		new Action().click(driver, clickDepartment);
		new Action().click(driver, selectQualityDept);
		new Action().click(driver, saveButton);
		
		
	}
	public boolean verifySuccesMsg() {
		return new Action().isDisplayed(driver, sucessMsg);
		
	}
	
	public void clickCloseBtn() {
		new Action().click(driver, closeBtn);
	}

}
