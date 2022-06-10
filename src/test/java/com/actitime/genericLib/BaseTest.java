package com.actitime.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.actitime.actions.Action;
import com.actitime.utility.ExtentManager;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConsts {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void extentReport() {
		new ExtentManager().setUpExtentReport();
		DOMConfigurator.configure("log4j.xml");	
		
	}
	
	@AfterSuite
	public void endExtentReport() throws IOException {
		new ExtentManager().endExtentReport();
	}
	
	
	//@Parameters("browserName")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public static void launchApp(String browserName) throws Throwable {//String browserName
      //String browserName=new FileLib().readProprertyData(Prop_Path, "browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
		    driver= new EdgeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		else {
			Reporter.log("Given Browser name is Mismatched", true);
		}
	
		new Action().implicitWait(driver, 20);
		new Action().pageLoadTimeOut(driver, 20);
		driver.get(new FileLib().readProprertyData(Prop_Path, "url"));
		driver.manage().window().maximize();
	
	}
	
//	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
//	public void teardown() {
//		driver.quit();
//	}

}
