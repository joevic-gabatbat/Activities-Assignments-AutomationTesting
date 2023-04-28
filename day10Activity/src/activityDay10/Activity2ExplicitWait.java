package activityDay10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity2ExplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(10000));
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		
		String expectedTitle = "Welcome: Mercury Tours";
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		if(pageTitle.equals(pageTitle)) {
			System.out.println("PASSED: Page title macthed.");
		}else {
			System.out.println("FAILED: Page title not macthed.");
		}
		
		WebElement clickReg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
		System.out.println("Waiting for 10 seconds if REGISTER button is not yet loaded.");
		clickReg.click();
		
		driver.close();
		driver.quit();

	}

}
