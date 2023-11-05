package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import baseDrivers.PageDriver;
import utilities.getScreenshot;

public class ShippingAddressPage {
	
	ExtentTest test;
	
	public ShippingAddressPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//locating the element
 
	@FindBy(id = "phone")
	WebElement phoneNumber;
	
	@FindBy(xpath ="//select[@id='js--city']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='js--area']")
	WebElement area;
	
	@FindBy(xpath = "//fieldset//textarea[@name='address']")
    WebElement Address;
	
	@FindBy(xpath = "//select[@id='js--zone']")
	 WebElement ZoneDropDown;
	

	
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
	
	public void shippingAddressGiven() throws IOException {
		try {
			test.info("Enter Phone Number");
			if(phoneNumber.isDisplayed()) {
				phoneNumber.sendKeys("013132555");
				passCase("Phone number enetered.");
			}
		} catch (Exception e) {
			failCase("Phone number field is unable to locate.", "phoneNumberFail.");
		}
		
		try {
			test.info("Select the city.");
			if(city.isDisplayed()) {
				city.click();
				Select selectItems = new Select(city);
		        selectItems.selectByIndex(3);
				Thread.sleep(2000);
				passCase("The city is succesfully is selected.");
			}
		} catch (Exception e) {
			failCase("The city element is not locateable..", "CityFail.");
		}
		
		try {
			test.info("Select the area of city.");
			if(area.isDisplayed()) {
				area.click();
				Select selectItems = new Select(area);
		        selectItems.selectByIndex(3);
				Thread.sleep(2000);
				passCase("The area is succesfully is selected.");
			}
		} catch (Exception e) {
			failCase("The area element is not locateable..", "AreaFail.");
		}
		
		try {
			test.info("Select the Zone.");
			if(ZoneDropDown.isDisplayed()) {
				ZoneDropDown.click();
				Select selectItems = new Select(ZoneDropDown);
		        selectItems.selectByIndex(3);
				passCaseWithSC("The ZoneDropDown is selected", "zoneDropDownPass");
			}
		} catch (Exception e) {
			failCase("The ZoneDropDown element is not locateable..", "zoneDropDownFail.");
		}
		
		try {
			test.info("Enter the address.");
			if(Address.isDisplayed()) {
				Address.sendKeys("mirpur-12, dhaka.");
				Thread.sleep(2000);
				passCaseWithSC("Successfully place the address", "addressPass");
				
			}
		} catch (Exception e) {
			failCase("The address element is not locateable.", "addressFail.");
		}
		
		
	}
	
//	public void selectItemByIndex(WebElement element, int index) {
//        
//    }
}
