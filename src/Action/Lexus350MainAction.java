package Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.Lexus350Main;
import Pages.OfferFrame;

public class Lexus350MainAction {

	/**
	 * This is action class for Lexus 350 Main Offer page
	 * @author Vaishali
	 * @throws InterruptedException 
	 *
	 */
	
	public static void fillOfferForm (WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement offerFrame = driver.findElement(By.id("mmd-frame-frame2"));
		driver.switchTo().frame(offerFrame);
	
	Lexus350Main main = new Lexus350Main(driver) ;
	
	driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
	main.selectOfferPrice(driver,"51000");
	main.selectCreditScore(driver, "tier_2");
	main.selectCashDown(driver, "2500");
	main.clickOnSendMyOffer(driver);
	}
	
	
}
