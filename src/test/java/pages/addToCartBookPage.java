package pages;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import baseDrivers.PageDriver;
import utilities.getScreenshot;

public class addToCartBookPage {
	ExtentTest test;
	
	public addToCartBookPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//locating element.
	@FindBy(xpath ="//button[@product-id='892']")
	WebElement firstBookAddToCart;
	
	
	@FindBy(xpath="//div[@title='বাঘবন্দি মিসির আলি হুমায়ূন আহমেদ']")
	WebElement firstBookToHover;
	
	
	@FindBy(xpath="//*[@id='cart-icon']")
	WebElement cartBtn;
	
	@FindBy(xpath="//span[contains(text(),'Place Order')]")
	WebElement placeOrderBtn;
	
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = getScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName +".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	private void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = getScreenshot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		
	}

	private void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		
	}
	
	
	public void firstBookHover() throws IOException {
		try {
			test.info("First book hover.");
			if(firstBookToHover.isDisplayed()) {
					Actions action = new Actions(PageDriver.getCurrentDriver());
					action.moveToElement(firstBookToHover).perform();
					Thread.sleep(2000);
					
				passCaseWithSC("first book hover", "firstBookToHoverPass");
				
			}
		} catch (Exception e) {
			failCase("hoverOnBook element is unable to locate.", "firstBookToHoverFail");
		}
	}
	
	public void firstBookAddToCart() throws IOException {

		try {
			test.info("Click on the first book");
			if(firstBookAddToCart.isDisplayed()) {
					firstBookAddToCart.click();
					Thread.sleep(3000);
					passCaseWithSC("first book is added to a cart", "firstBookAddToCartPass");
			}
		} catch (Exception e) {
			failCase("First book element is unable to locate.", "firstBookAddToCartFail");
		}		
	}
	public void visitCartPage() throws IOException {
		try {
			test.info("click on the cart button.");
			if(cartBtn.isDisplayed()) {
				cartBtn.click();
				Thread.sleep(3000);
				
				passCaseWithSC("clicked on the cart button.", "cartBtnPass");
			}
		} catch (Exception e) {
			failCase("cartBtn element is unable to locate.", "cartBtnFail");
		}
	}
	
	public void placeOrder() throws IOException {
		try {
			test.info("Click on the place the order.");
			if(placeOrderBtn.isDisplayed()) {
				placeOrderBtn.click();
				Thread.sleep(2000);
				passCaseWithSC("clicked on the place order button.", "placeOrderBtnPass");
			}
		} catch (Exception e) {
			// TODO: handle exception
			failCase("placeOrderBtn element is unable to locate.", "placeOrderBtnFail");
		}
	}
}
