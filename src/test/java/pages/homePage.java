package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import baseDrivers.PageDriver;
import utilities.getScreenshot;

public class homePage {
	
	private ExtentTest test;
	
	public homePage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInbutton;
	
	@FindBy(xpath="//body/div[@id='login-registration']/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/button[2]")
	WebElement googleBtn;
	
	
	
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
	
	public void ClickOnSingIn() throws IOException {
		try {
			test.info("Click On the sign button");
			
			if(signInbutton.isDisplayed()) {
					signInbutton.click();
					passCase("<p style=\"color:green; font-size:13px\"><b>Sign-in Button Clicked.</b></p>");
					passCaseWithSC("Clicked on the Sign Button.", "signInBtnPass");	
	
					try {
						if(googleBtn.isDisplayed()) {
								googleBtn.click();
								passCase("<p style=\"color:green; font-size:13px\"><b>Google Button Clicked.</b></p>");
								passCaseWithSC("Clicked on the google Button.", "googleBtnPass");	
						}	
					} 
					catch (Exception e) {
						failCase("googleBtnFail", "googleBtnFail");
					}
						
						
				}
				
		} catch (Exception e) {
			failCase("SignInBtnFail", "SignInBtnFail");
		}
	}
	
	

}
	


