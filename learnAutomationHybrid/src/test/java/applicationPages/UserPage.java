package applicationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class UserPage {
	WebDriver driver;
public UserPage(WebDriver ldriver) {
	this.driver = ldriver;
	
	}
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']") WebElement admin;
	
	@FindBy(xpath="//*[@id='menu_admin_UserManagement']") WebElement usermanagement;
	
	@FindBy(xpath="//*[@id='menu_admin_viewSystemUsers']") WebElement users;
	
	@FindBy(xpath="//*[@id='btnAdd']") WebElement addbutton;
	
	@FindBy(xpath="//*[@id='systemUser_userName']") WebElement username;
	
	@FindBy(xpath="//*[@id='systemUser_employeeName_empName']") WebElement empname;
	

	public void addUser() {
		
		Actions act = new Actions(driver);
		act.moveToElement(Utility.waitForWebElement(driver, admin, 20)).perform();
		act.moveToElement(Utility.waitForWebElement(driver, usermanagement, 20)).perform();
		act.moveToElement(Utility.waitForWebElement(driver, users, 20)).click().build().perform();
		Utility.waitForWebElement(driver, addbutton, 20).click();
		Utility.waitForWebElement(driver, username, 20).sendKeys("Babli");
		Utility.waitForWebElement(driver, empname, 20).sendKeys("R");
		List<WebElement> list= driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		for(WebElement abc: list) {
			String list1= abc.getAttribute("innerHTML");
			if(list1.contains("Robert")) {
		abc.click();
		break;
			}
		}
		
	}
}

