package applicationFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApllication(String browser, String Url) {
		WebDriver driver = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver(cap);
					
		}
		else if(browser.equalsIgnoreCase("ChromeHeadless")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver(options);
		}
		
		else if (browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver(cap);
		}
		else if (browser.equalsIgnoreCase("FirefoxHeadless")) {
			FirefoxBinary binary = new FirefoxBinary ();
			binary.addCommandLineOptions("--headless");
			System.setProperty("webdriver.gecko.driver", ".Drivers/geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary(binary);
			cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
			
		}
		
		else if(browser.equalsIgnoreCase("IE")) {
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver(cap);
		}
		
		else {
			System.out.println("Sorry we support only Chrome, Firefox and IE Browsers");
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Browser and application is set");
		return driver;
		
	}
	public static WebDriver startApllicationOnCloud(String browser, String Url, String osName, String version) {
		System.out.println("INFO: Setting up the browser on cloud");
		
		WebDriver driver = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability("os", osName);
		cap.setCapability("os_version", version);
		
		
		 final String USERNAME = "bablichib1";
		 final String AUTOMATE_KEY = "JUzT6ykyT8U16Xhutape";
		  final String hubURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		  URL urlCloud = null;
		try {
			urlCloud = new URL(hubURL);
		} catch (MalformedURLException e) {
		}
		    
		if(browser.equalsIgnoreCase("Chrome")) {
			cap.setCapability("browser", "Chrome");
			driver=new RemoteWebDriver(urlCloud, cap);
					
		}
		
		
		else if (browser.equalsIgnoreCase("Firefox")){
			cap.setCapability("browser", "Firefox");
			driver=new RemoteWebDriver(urlCloud, cap);
		}
		
		else if(browser.equalsIgnoreCase("IE")) {
			cap.setCapability("browser", "IE");
				driver=new RemoteWebDriver(urlCloud, cap);
		}
		
		else {
			System.out.println("Sorry we support only Chrome, Firefox and IE Browsers");
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Browser and application is set");
		return driver;
		
	}
}
