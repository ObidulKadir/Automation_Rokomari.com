package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import baseDrivers.PageDriver;
import utilities.getScreenshot;

public class writerPage{
	
	private ExtentTest test;
	
	public writerPage(ExtentTest test) {
		
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//locator finding.
	@FindBy(xpath="//*[@id=\"js--AB-test-popup\"]/div[1]/button/i")
	WebElement dismissBtn;
	
	@FindBy(xpath="//a[@id='js--authors']")
	public WebElement writerSec;
	
	@FindBy(xpath ="//a[contains(text(),'হুমায়ূন আহমেদ')]")
	WebElement writerName;
	
	@FindBy(xpath="//label[contains(text(),'সমকালীন উপন্যাস')]")
	WebElement selectFirstCategory;
	
	@FindBy(xpath="//label[contains(text(),'রচনা সংকলন ও সমগ্র')]")
	WebElement selectSecondCategory;

	@FindBy(xpath="//a[contains(text(),'Next')]")
	WebElement categoryNextBtn;
	
	@FindBy(xpath="//a[contains(text(),'Next')]")
	WebElement paginationNextBtn;
	
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
	
	public void writerSection() throws IOException, InterruptedException {
		//dismiss the pop-up alert.
		try {
			test.info("Click on the dyanamic content appears.");
			if(dismissBtn.isDisplayed()) {
				dismissBtn.click();
				Thread.sleep(3000);
				passCaseWithSC("Removed the dyanmic content.", "dyanmicAddPass");
			}
		} catch (Exception e) {
			failCase("The dissmiss button of dyanamic content is unable to locate.", "dyanmicAddFail");
		}
		
		// hover on the writer module..
		try {
			test.info("Hover on the: লেখক module.");
			if(writerSec.isDisplayed()) {
					Actions action = new Actions(PageDriver.getCurrentDriver());
					Thread.sleep(2000);
					action.moveToElement(writerSec).perform();
					Thread.sleep(2000);
					passCaseWithSC("Writer section hovered properly.", "writerSectionHvrPass");
					
					//select the writer name.
					try {
						test.info("Click on the হুমায়ূন আহমেদ");
						if(writerName.isDisplayed()) {
								writerName.click();
								Thread.sleep(3000);
								passCase("Clicked on the writer name: হুমায়ূন আহমেদ");
								passCaseWithSC("Clicked on the Writer Name", "writerNamePass");
						}
					} catch (Exception e) {
						failCase("The writer name is unable to locate.", "writerNameFail");
					}
				
			}
		} catch (Exception e) {
			failCase("The writer section module is unable to locate.", "writerSectionHvrFail");
		}
		
	}
	//Selecting by category
	public void selectCategory() throws IOException, InterruptedException {
		//select the first category
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		try {
			test.info("Select the : 'সমকালীন উপন্যাস' ");
			if(selectFirstCategory.isDisplayed()) {
				Thread.sleep(2000);
				selectFirstCategory.click();
				Thread.sleep(3000);
				passCase("Selected the 'সমকালীন উপন্যাস' ");
				passCaseWithSC("Select the first category", "selectFirstCategoryPass");
			}
		} catch (Exception e) {
			failCase("selectFirstCategory is unable to locate.", "selectFirstCategoryFail");
		}
		//select the second category.
		
		js.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(2000);
		try {
			test.info("Select the 'রচনা সংকলন ও সমগ্র'");
			if(selectSecondCategory.isDisplayed()) {
				selectSecondCategory.click();
				Thread.sleep(3000);
				passCase("Selected the 'রচনা সংকলন ও সমগ্র' ");
				passCaseWithSC("Select the Second category", "selectSecondCategoryPass");
			}
		} catch (Exception e) {
			failCase("selectSecondCategory is unable to locate.", "selectSecondCategoryFail");
		}
		
	}
	
	//scrolling to the pagination
	public void scrollingPage() throws InterruptedException, IOException {
		try {
			test.info("Scrolling the page");
			JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
			js.executeScript("window.scrollBy(0,4000)", "");
			Thread.sleep(2000);
			passCaseWithSC("Sucessfully scrolled the page.", "passScrolling");
		} catch (Exception e) {
			failCase("Fail to scrolling the page.", "failScrolling");
		}
	}
	
	//select the next button to move next page.
	public void selectToNextPage() throws IOException {
		try {
			if(paginationNextBtn.isDisplayed()) {
				paginationNextBtn.click();
				Thread.sleep(2000);
				passCaseWithSC("Clicked on the next button from pagination", "paginationNextBtnPass");
			}
		} catch (Exception e) {
			failCase("paginationNext element is unable to locate.", "paginationNextBtnFail");
		}
	}
	
}
