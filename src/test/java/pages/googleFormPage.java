package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import baseDrivers.PageDriver;
import utilities.getScreenshot;

public class googleFormPage {
	
	private ExtentTest test;
	
	public googleFormPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement userEmail;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement userEmailnextBtn;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement userPwd;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement userPwdNextBtn;
	
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
	
	
	public void googleLogin() throws IOException {
		
		//Enter email on form
		try {
			test.info("Enter the the email address.");
			if(userEmail.isDisplayed()) {
				userEmail.sendKeys("96demotests@gmail.com");;
//				Thread.sleep(3000);
				passCase("Email address entered.");
				passCaseWithSC("Email address entered", "userEmailEnterPass");
				
			}
			
		} catch (Exception e) {
			failCase("User email address fields unable to locate.", "userEmailFail");
		}
		
		// click on the next button on  the form.
		
		try {
			test.info("Click on the next button.");
			if(userEmailnextBtn.isDisplayed()) {
				userEmailnextBtn.click();
				Thread.sleep(3000);
				passCaseWithSC("Next button in email page is clicked ", "userEmailNextBtnPass");
				
			}
		} catch (Exception e) {
			failCase("Next button in email page is unable to locate.", "userEmailNxtFail");
		}
		
		
		// Enter the password.
		try {
			test.info("Enter the password.");
			if(userPwd.isDisplayed()) {
				userPwd.sendKeys("Demo123!!");
				Thread.sleep(3000);
				passCase("Password Entered.");
				passCaseWithSC("Entered the user password. ", "userPwdPass");
				
			}
		} catch (Exception e) {
			failCase("Password field is unable to locate.", "userPwdFail");
		}
		
		try {
			test.info("Click on the next button.");
			if(userPwdNextBtn.isDisplayed()) {
				userPwdNextBtn.click();
				Thread.sleep(3000);
				passCaseWithSC("Next button in password page clicked ", "userPwdNextBtnPass");
				
			}
		} catch (Exception e) {
			failCase("Next button in password page is unable to locate.", "userPwdNextBtnFail");
		}
		
		
		
	}
	
	
	

}
