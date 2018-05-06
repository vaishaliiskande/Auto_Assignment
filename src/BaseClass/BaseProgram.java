package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseProgram {

		/**
		 * Base class for the Cox Auto Assignment - Program to instantiate WebDriver object
		 * 
		 * @author Vaishali
		 *
		*/
		public static final String BASE_URL = "https://lexus.roimotors.com/new/LEXUS/2018-LEXUS-GS+350-9478ae060a0a00f93a13f68a2e7fb412.htm";

			public static WebDriver getDriver(String browserType) {
			WebDriver driver = null;
			
			String Path = System.getProperty("user.dir");
					
			if (browserType.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
						Path + "\\drivers\\chromedriver.exe");
				
				driver = new ChromeDriver();
				
			}
			else if (browserType.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",
						Path + "\\drivers\\geckodriver.exe");
				
			driver = new FirefoxDriver();
			}
			
			return driver;
			}
			
		public static void closeBrowser(WebDriver driver) {
				try {
					driver.quit();
				} catch (WebDriverException wde) {
					System.out.println("Received WebDriverException during WebDriver quit()");

				}
		}
}
