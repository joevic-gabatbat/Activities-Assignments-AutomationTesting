package textExtent;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FaceBookExtentTest {
	
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports("ExecutionReport.html");
		test = report.startTest("Extent Demo");
	}

	@Test
	public void openRegisterMethod() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		
		
		if (driver.getTitle().equals("Google")) {
			test.log(LogStatus.PASS, "Passed");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}

	}

	@AfterClass
	public static void endTest() {

		report.endTest(test);
		report.flush();

	}
}
