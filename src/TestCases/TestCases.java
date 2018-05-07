package TestCases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Action.Lexus350MainAction;
import Action.OfferFrameAction;
import BaseClass.BaseProgram;


public class TestCases extends BaseClass.BaseProgram{
	
	static WebDriver driver;
	String browserType;
	

	
	@Test (priority=1, description = "This Test Case will verify the User offer has correct Down Payment value and the User form is sent to Dealer")
	public void TestCase1()
	{		
		//Fill the form for Offer Price
		
		Lexus350MainAction.fillOfferForm(driver);
		//Once the Offer is ready to send, Fill the user details on "Ready to Send" page.
		OfferFrameAction.fillUserDetails(driver);
		
		/* Test Verifications
	 	Verify if the Down payment is $2500.
		*/
		OfferFrameAction.verifyDownPayment(driver);
							
	}
	
	
	
	@Test(priority=2, dependsOnMethods= {"TestCase1"}, description = "This test case verify if the User offer is successfully sent and 'Protect your Vehicle' page is displayed")
	public void TestCase2()
	{
		// Send the Offer to the dealer
		OfferFrameAction.sendMyOffer(driver);
		
		/* Test Verifications : 
		Once the offer is sent to Dealer, 'Protect Your Vehicle' page is displayed
		*/
		OfferFrameAction.verifyProtectBrowser(driver);
	}
	
	@BeforeTest 
	@Parameters ({"BrowserType"})
	public void setUp(String browserType) {
		driver = BaseProgram.getDriver(browserType);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(BASE_URL);
	
	}
	
	@AfterTest
	public void tearDown() {
		closeBrowser(driver);
		}
}
