package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	
	static WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static ConfigFileReader config = new ConfigFileReader();

	static String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	public static WebDriver luanchBrowser() {

		String browserName = config.getSpecificUrlProperties("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		return driver;
	}

	public static ExtentTest generateExtentReports() {
		File file = new File(dateName);
		file.mkdir();
		report = new ExtentReports(dateName + "/ExecutionReport.html");
		test = report.startTest("Extent Demo");
		return test;
	}

	public static void closeExtentReports() {
		report.endTest(test);
		report.flush();
	}

	public static String captureScreenShots() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + "ScreenShots" + dateName
				+ ".png";
		test.log(LogStatus.FAIL, "Test Failed" + test.addScreenCapture(destination));
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
}
