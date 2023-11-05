package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import baseDrivers.BaseDriver;
import baseDrivers.PageDriver;
import pages.writerPage;
import utilities.ExtentFactory;

public class writerPageTest extends BaseDriver {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void reportStartup() {
//		PageDriver.getCurrentDriver().get(url);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>লেখক  Module</b></p>").assignAuthor("QA TEAM").assignDevice("windows");

	}
	
	@Test (priority = 0)
	public void writerPageTest() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Locate the লেখক module.</b></p>");
		writerPage wm = new writerPage(childTest);
		wm.writerSection();

	}
	
	@Test (priority = 1)
	public void selectCategory() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Select the category of writer.</b></p>");
		writerPage wm = new writerPage(childTest);
		wm.selectCategory();

	}
	
	@Test (priority = 2)
	public void scrollingPage() throws IOException, InterruptedException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Scrolling the page.</b></p>");
		writerPage wm = new writerPage(childTest);
		wm.scrollingPage();
	}
	
	@Test (priority = 3)
	public void moveToNxtPage() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Move to next page.</b></p>");
		writerPage wm = new writerPage(childTest);
		wm.selectToNextPage();
	}
	
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
