package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OfferFrame {
	
	/**
	 * locators and methods for Offer Frame
	 * @author Vaishali
	 */
	
 //	@FindBy(id="mmd-frame-shopperplatform")
//	WebElement OFFER_FRAME;
	
	@FindBy(name = "shopper.zip")
	WebElement ZIP_CODE;
	
	@FindBy(name = "shopper.firstName")
	WebElement FIRST_NAME;
	
	@FindBy(name = "shopper.lastName")
	WebElement LAST_NAME;
	
	@FindBy(name = "shopper.email")
	WebElement EMAIL;
	
	@FindBy(name = "shopper.phone")
	WebElement PHONE;
	
	@FindBy (id="sp_shopper_message")
	WebElement MESSAGE;
	
	@FindBy (xpath=".//*[@class='btn btn-primary']")
	WebElement SENDMYOFFER_BUTTON;
	
	public OfferFrame(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterZipCode(String Zipcode) {
		ZIP_CODE.sendKeys(Zipcode);
	}
	
	public void enterFirstName(String FirstName) {
		FIRST_NAME.sendKeys(FirstName);
	}
	
	public void enterLastName(String LastName) {
		LAST_NAME.sendKeys(LastName);
	}
	
	public void enterEmail(String Email) {
		EMAIL.sendKeys(Email);
	}
	
	public void enterPhone(String Phone) {
		PHONE.sendKeys(Phone);
	}
	
	public void enterMessage(String Message)
	{
		MESSAGE.sendKeys(Message);
	}

	public void clickSendMyOffer(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", SENDMYOFFER_BUTTON);
		
		SENDMYOFFER_BUTTON.click();
		System.out.println("User Offer has been sent");
	}
	
	
	
	
}
