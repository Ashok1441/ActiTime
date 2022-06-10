package com.actitime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.actions.Action;
import com.actitime.genericLib.BaseTest;

public class LoginPage extends BaseTest {
   	
	
	
	@FindBy(name="username") public WebElement untb;
	
	@FindBy(name="pwd") public WebElement passWord;
	
	@FindBy(id="loginButton") public WebElement lgnbutton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPage() throws Throwable {
		String ActitimeLoginPagetitle = new Action().getTitle(driver);
		return ActitimeLoginPagetitle;
		 
	}
	
	public void loginPage(String un,String pwd) throws Throwable {
		new Action().type(untb, un);
		new Action().type(passWord, pwd);
		new Action().click(driver, lgnbutton);
	}
	
}
