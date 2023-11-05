package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseDrivers.BaseDriver;
import baseDrivers.PageDriver;
import pages.homePage;
import utilities.ExtentFactory;

public class homePageTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void startUp() throws InterruptedException {
		
		PageDriver.getCurrentDriver().get(url);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Create An Account</b></p>").assignAuthor("QA TEAM").assignDevice("windows");
		
	}
	
	@Test
	public void homePageTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Sign In</b></p>");
		homePage hp = new homePage(childTest);
		hp.ClickOnSingIn();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
	
	

}
