package activityDay10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1ImplicitWait {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		
		driver.close();
		driver.quit();
	}

}
