package com.actitime.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager{
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	public void setUpExtentReport() {
		
		sparkReporter=new ExtentSparkReporter("ExtentReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		
		
		extentReports.setSystemInfo("Tester Name", "Ashok");
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
	}
	public void endExtentReport() throws IOException {
		extentReports.flush();
		//Desktop.getDesktop().browse(new File("ExtentReport.html").toURI());
	}

}
