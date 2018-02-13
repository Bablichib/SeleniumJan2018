package unitTestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridTestCase {
@Test
	public void testBrowser() throws MalformedURLException, InterruptedException {
	
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	URL url = new URL("http://192.168.2.6:4444/wd/hub");
	WebDriver driver = new RemoteWebDriver(url, cap);
	driver.get("https://www.google.co.in");
	System.out.println("Title Before" +driver.getTitle());
	driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");
	Thread.sleep(5000);
	driver.quit();

	}

}
