package unitTestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumTestCloud {
	
	 public static final String USERNAME = "bablichib1";
	  public static final String AUTOMATE_KEY = "JUzT6ykyT8U16Xhutape";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
@Test
	public void testBrowser() throws MalformedURLException, InterruptedException {
	
	DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "Firefox");
    caps.setCapability("browser_version", "56.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "10");
    caps.setCapability("browserstack.debug", true);
    
	URL url = new URL(URL);
	WebDriver driver = new RemoteWebDriver(url, caps);
	driver.get("https://www.google.co.in");
	System.out.println("Title Before" +driver.getTitle());
	driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");
	Thread.sleep(5000);
	driver.quit();

	}

}
