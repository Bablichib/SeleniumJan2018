package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	public static String getCurrentDateAndTime() {
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		Date date = new Date();
		String formattedDate =dateFormat.format(date);
		return formattedDate;
		
	}
public static String captureScreenShot(WebDriver driver) {
	String Screenshot =System.getProperty("user.dir")+"/Screenshots/"+Utility.getCurrentDateAndTime()+".png";
	
	File dest = new File (Screenshot);
	TakesScreenshot ts = (TakesScreenshot) driver;
	File scr =ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scr, dest);
	} catch (IOException e) {
	System.out.println("Unable to capture screenshot");
	System.out.println("Error"+e.getMessage());
	}
return Screenshot;
}
public static void highLightElement(WebDriver driver, WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {

		System.out.println(e.getMessage());
	}

	js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

}

public static void syncWebElement(WebDriver driver, WebElement element, int time) {

	WebDriverWait wait = new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOf(element));
	wait.until(ExpectedConditions.elementToBeClickable(element));

}

public static WebElement waitForWebElement(WebDriver driver, WebElement element, int time) {

	syncWebElement(driver, element, time);

	highLightElement(driver, element);

	return element;
}

}
