package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lexus350Main {

	/**
	 * locators and methods for Offer page
	 * @author Vaishali
	 */
	
	@FindBy(id="finance-input-offer")
	WebElement OFFER_PRICE;
	
	@FindBy(id="finance-cash-down")
	WebElement CASH_DOWN;
	
	@FindBy(id="finance-credit-tier")
	 WebElement CREDIT_SCORE;
	 
	@FindBy(id="send-my-offer")
	WebElement SENDMYOFFER_BUTTON;

	
	public Lexus350Main(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	
	public void selectOfferPrice(WebDriver driver, String offerPrice) {
		
	
		if(OFFER_PRICE.getAttribute("value") != null) {
		OFFER_PRICE.clear();
		}
		OFFER_PRICE.sendKeys(offerPrice);
	}

	public void selectCashDown(WebDriver driver, String cashDown) {
		
		if (CASH_DOWN.getAttribute("value")!= null) {
		CASH_DOWN.clear();
		}
		CASH_DOWN.sendKeys(cashDown);
	
	}
	
	public void selectCreditScore(WebDriver driver, String CreditScore) {

		Select creditDropdown = new Select(CREDIT_SCORE);
		creditDropdown.selectByValue(CreditScore);

	}

	public void clickOnSendMyOffer(WebDriver driver) {

		SENDMYOFFER_BUTTON.click();
	}
	
	
}
