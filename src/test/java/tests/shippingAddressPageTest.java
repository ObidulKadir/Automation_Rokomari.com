package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.ShippingAddressPage;
import utilities.ExtentFactory;

public class shippingAddressPageTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() {
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Shipping Address.</b></p>").assignAuthor("QA TEAM").assignDevice("windows");
	}
	
	@Test (priority = 0)
	public void shippingAddress() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Shipping Address\r\n"
				+ "(Please Fill Out Your Information)</b></p>");
		
		ShippingAddressPage shippingPage = new ShippingAddressPage(childTest);
		shippingPage.shippingAddressGiven();
	
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
