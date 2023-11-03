package tests;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import pages.googleFormPage;
import utilities.ExtentFactory;

public class googleFormTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void startUp() throws InterruptedException {
		
//		PageDriver.getCurrentDriver().get(url);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Create An Account</b></p>").assignAuthor("QA TEAM").assignDevice("window");
		
		
	}
	@Test
	public void gogleFormTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Google Account.</b></p>");
		googleFormPage gft = new googleFormPage(childTest);
		gft.googleLogin();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
