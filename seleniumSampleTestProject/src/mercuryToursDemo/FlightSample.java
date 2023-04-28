package mercuryToursDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlightSample {

	public static void main(String[] args) {
		// //a[contains(text(),'SIGN-ON')]
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		
		System.out.println(driver.getTitle());
		String actualTitle = driver.getTitle();
		String expectedTitle = "Welcome: Mercury Tours";
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("PASS: You are on the Homepage of Mercury Tours");
		}else {
			System.out.println("FAIL: You are not on the Homepage of Mercury Tours");
		}
		
		driver.findElement(By.linkText("SIGN-ON")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("userName")).sendKeys("joe123");
		driver.findElement(By.name("password")).sendKeys("joe@123");
		driver.findElement(By.name("submit")).click();

	}

}
