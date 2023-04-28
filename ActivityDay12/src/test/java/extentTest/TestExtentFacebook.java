package extentTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestExtentFacebook {

	WebDriver driver = new ChromeDriver();
//	WebDriver driver = new SafariDriver();
	static ExtentTest test;
	static ExtentReports report;

	@Test(priority = 1)
	public void getFacebookMethod() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.getTitle().equals("Facebook - log in or sign up")) {
			test.log(LogStatus.PASS, "Facebook title: " + driver.getTitle());
		} else {
			test.log(LogStatus.FAIL, "Test Failed, wrong title.");
		}
	}

	@Test(priority = 2)
	public void openRegisterFormMethod() {

		Actions action = new Actions(driver);
		WebElement regButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		action.moveToElement(regButton).perform();
		regButton.click();

		WebElement regForm = driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']"));
		if (regForm.isDisplayed()) {
			test.log(LogStatus.PASS, "Facebook Registration Form is Displayed.");
		} else {
			test.log(LogStatus.FAIL, "Facebook Registration Form is not Displayed.");
		}

	}

	@Test(priority = 3)
	public void checkInputFields() {

		String inputFirstname = driver.findElement(By.xpath("//input[@type='text' and @name='firstname']")).getAttribute("value");
		String inputLastname = driver.findElement(By.xpath("//input[@type='text' and @name='lastname']")).getAttribute("value");
		String inputMobileOrEmail = driver.findElement(By.xpath("//input[@type='text' and @name='reg_email__']"))
				.getAttribute("value");
		String inputPassword = driver.findElement(By.xpath("//input[@type='password' and @name='reg_passwd__']"))
				.getAttribute("value");

		if (inputFirstname == null || inputLastname == null || inputMobileOrEmail == null || inputPassword == null) {
			test.log(LogStatus.INFO, "Firstname, Lastname, Mobile or Email and Password input fields are empty.");
		} else {
			test.log(LogStatus.INFO, "Firstname, Lastname, Mobile or Email and Password input fields are not empty.");
		}

	}

	@Test(priority = 4)
	public void validateInputErrorMessage() {

		WebElement inputFirstname = driver.findElement(By.xpath("//input[@type='text' and @name='firstname']"));
		WebElement inputLastname = driver.findElement(By.xpath("//input[@type='text' and @name='lastname']"));

		inputFirstname.click();
		inputLastname.click();
		inputFirstname.click();

		WebElement inputErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'What’s your name?')]"));

		if (inputErrorMessage.isDisplayed()) {
			test.log(LogStatus.WARNING, "Input error message is displayed.");
		} else {
			test.log(LogStatus.FAIL, "Input error message is not displayed.");
		}

	}

	@Test(priority = 5)
	public void inputCredentials() {

		WebElement inputFirstname = driver.findElement(By.xpath("//input[@type='text' and @name='firstname']"));
		inputFirstname.sendKeys("Joe");

		WebElement inputLastname = driver.findElement(By.xpath("//input[@type='text' and @name='lastname']"));
		inputLastname.sendKeys("Gabatbat");

		WebElement inputMobileOrEmail = driver.findElement(By.xpath("//input[@type='text' and @name='reg_email__']"));
		inputMobileOrEmail.sendKeys("123456789012");

		WebElement inputPassword = driver.findElement(By.xpath("//input[@type='password' and @name='reg_passwd__']"));
		inputPassword.sendKeys("Joe@123456789");

		Select birthMonth = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
		birthMonth.selectByVisibleText("May");

		Select birthDay = new Select(driver.findElement(By.xpath("//select[@name='birthday_day']")));
		birthDay.selectByVisibleText("6");

		Select birthYear = new Select(driver.findElement(By.xpath("//select[@name='birthday_year']")));
		birthYear.selectByVisibleText("1995");

		WebElement customGender = driver
				.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='-1']"));
		customGender.click();

		Select prederPronoun = new Select(driver.findElement(By.xpath("//select[@name='preferred_pronoun']")));
		prederPronoun.selectByIndex(2);

		WebElement inputErrorMessage = driver.findElement(By.xpath("//input[@name='custom_gender']"));
		inputErrorMessage.sendKeys("Test");

		test.log(LogStatus.SKIP, "Skip to input validation");

	}

	@Test(priority = 6)
	public void validateInputCredentials() {

		String inputFirstname = driver.findElement(By.xpath("//input[@type='text' and @name='firstname']")).getAttribute("value");

		String inputLastname = driver.findElement(By.xpath("//input[@type='text' and @name='lastname']")).getAttribute("value");

		String inputMobileOrEmail = driver.findElement(By.xpath("//input[@type='text' and @name='reg_email__']")).getAttribute("value");

		String inputPassword = driver.findElement(By.xpath("//input[@type='password' and @name='reg_passwd__']"))
				.getAttribute("value");

		WebElement customGender = driver
				.findElement(By.xpath("//input[@type='radio' and @name='sex' and @value='-1']"));

		String prederPronoun = driver.findElement(By.xpath("//select[@name='preferred_pronoun']")).getAttribute("value");

		String inputErrorMessage = driver.findElement(By.xpath("//input[@name='custom_gender']")).getAttribute("value");
		
		int countMobileNumber = inputMobileOrEmail.length();

		if (inputFirstname != null || inputLastname != null || inputMobileOrEmail != null || inputPassword != null
				|| customGender.isSelected() || prederPronoun != null || inputErrorMessage != null) {
			test.log(LogStatus.PASS, "Validate input credentials successfully. Total digit for mobile number: " + countMobileNumber);
		} else {
			test.log(LogStatus.FAIL, "Validate input credentials failed.");
		}

	}
	
	@Test(priority = 7)
	public void submitMethod() {
		/*
		 * Intentional fail, wrong xpath for button submit
		 * Actual xpath (//button[@type='submit' and @name='websubmit'])
		 */
		try {
			WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit' and @name='wrongSubmitButton']"));
			submitButton.click();
			test.log(LogStatus.PASS, "Account creation successfully");
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Intentional fail, wrong xpath for submit button.");
		}
		
	}

	@BeforeClass
	public void beforeClass() {
		report = new ExtentReports("ExecutionReport.html");
		test = report.startTest("Extent Demo");
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
		driver.close();
		driver.quit();
	}

}
