package test_Scenarios;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import objectRepo.GoogleSearch;
import utils.CommonFunctions;
import utils.ConfigFileReader;

public class TestScenarios {

	WebDriver driver;
	ConfigFileReader config = new ConfigFileReader();
	ExtentTest test;

	@BeforeSuite
	public void beforeClass() {
		System.out.println("========== BEFORE CLASS ==========");
		driver = CommonFunctions.luanchBrowser();
		test = CommonFunctions.generateExtentReports();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("========== BEFORE TEST ==========");
		String url = config.getSpecificUrlProperties("googleUrl");
		driver.get(url);
		test.log(LogStatus.INFO, "Launch Url : " + url);
	}

	@Test
	public void searchInGoogle() {
		System.out.println("========== TEST ==========");
		GoogleSearch gs = new GoogleSearch(driver, test);
		test.log(LogStatus.INFO, "Search for text facebook");
		gs.searchGoogle("facebook");
	}

	@AfterTest
	public void afterTest() throws IOException {
		CommonFunctions.captureScreenShots();
		test.log(LogStatus.INFO, "Close the browser Chrome");
		System.out.println("========== AFTER TEST ==========");
		driver.quit();
	}

	@AfterSuite
	public void afterClass() {
		System.out.println("========== AFTER SUITE ==========");
		CommonFunctions.closeExtentReports();
	}

}
