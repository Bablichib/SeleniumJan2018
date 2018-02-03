package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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
}
