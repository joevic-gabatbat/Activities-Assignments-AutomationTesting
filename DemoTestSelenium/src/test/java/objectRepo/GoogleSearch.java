package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.CommonFunctions;

public class GoogleSearch {
	
	WebDriver driver;
	ExtentTest test;

	public GoogleSearch(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	By searchBox = By.name("q");
	By faceBookLogin = By.xpath("//h3[contains(text(), 'Facebook - log in or sign up')]");
	
	public void searchGoogle(String searchText) {
		String title = driver.getTitle();
		if(title.contains("Google")) {
			test.log(LogStatus.PASS, "Title contains " + title);
		}else {
			test.log(LogStatus.PASS, "Title does not contains " + title);
		}
		test.log(LogStatus.INFO, "Search for Text Facebook");
		driver.findElement(searchBox).sendKeys("facebook");
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
		test.log(LogStatus.INFO, "Search for Text Facebook");
		driver.findElement(faceBookLogin).click();
	}
	
	
}
