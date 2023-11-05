package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.addToCartBookPage;
import pages.homePage;
import utilities.ExtentFactory;

public class addToCartBookTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() {
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Shooping the book.</b></p>").assignAuthor("QA TEAM").assignDevice("windows");
	}
	
	@Test (priority = 0)
	public void hoverTheFirstBook() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Hover the first book.</b></p>");
		addToCartBookPage bookCart = new addToCartBookPage(childTest);
		bookCart.firstBookHover();
	
	}
	@Test (priority = 1)
	public void addToCartBookTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Book Added to cart</b></p>");
		addToCartBookPage bookCart = new addToCartBookPage(childTest);
		bookCart.firstBookAddToCart();
	
	}
	
	@Test(priority = 2)
	public void visitCart() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Visit the cart page.</b></p>");
		addToCartBookPage bookCart = new addToCartBookPage(childTest);
		bookCart.visitCartPage();
	
	}
	@Test (priority = 3)
	public void placeTheOrder() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Placing the order.</b></p>");
		addToCartBookPage bookCart = new addToCartBookPage(childTest);
		bookCart.placeOrder();
	
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
	
	

}
