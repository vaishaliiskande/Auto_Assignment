package Action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.OfferFrame;

public class OfferFrameAction {
	
	/**
	 * This is action class for Lexus 350 Review My Offer page
	 * @author Vaishali
	 * @return 
	 *
	 */
	
	public static void fillUserDetails (WebDriver driver) {
	
		OfferFrame frameObj = new OfferFrame(driver);
		
		driver.switchTo().defaultContent();
		
		WebElement frame1 = driver.findElement(By.xpath(".//*[@id='mmd-frame-frame4']"));
		driver.switchTo().frame(frame1);
			
		WebElement frame2 = driver.findElement(By.xpath(".//*[@id='mmd-frame-shopperplatform']"));
		driver.switchTo().frame(frame2);
		
		frameObj.enterZipCode("30338");
		frameObj.enterFirstName("Vaishali");
		frameObj.enterLastName("Jackson");
		frameObj.enterEmail("abcd@gmailha.com");
		frameObj.enterPhone("4563451212");
		frameObj.enterMessage(randomAlphaNumeric(20));
	
	}

	public static void sendMyOffer (WebDriver driver)
	{
		
	
		
		OfferFrame frameObj = new OfferFrame(driver);
		frameObj.clickSendMyOffer(driver);
		
	}
	
	public static void verifyDownPayment(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement city =driver.findElement(By.id("sp_shopper_city"));
		
		wait.until(ExpectedConditions.visibilityOf(city));
		WebElement CashDown = driver.findElement(By.xpath(".//*[@id='downPayment']/span[2]"));
		
		//System.out.println("Cash Down : " + CashDown.getText());
		Assert.assertTrue(CashDown.getText().equalsIgnoreCase("$2,500"), "Down Payment Value doesn't match with the Actual entered Value");
		System.out.println("Down Payment Value is correct!");
		
	}
	
	public static void verifyProtectBrowser(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		WebElement protectEle = driver.findElement(By.xpath(".//*[@id='dr-sp-shopper-education']/div[1]"));
		
		Assert.assertTrue(protectEle.getText().contains("PROTECT YOUR VEHICLE"),"Some error occured in sending the Offer to Dealer");
		System.out.println("User Offer has been sent successfully!");
		
	}

	public static String randomAlphaNumeric(int count) {
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
		}
		
}
