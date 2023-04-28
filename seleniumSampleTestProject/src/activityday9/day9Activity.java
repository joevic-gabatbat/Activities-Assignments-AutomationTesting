package activityday9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class day9Activity {

	public static void main(String[] args) throws InterruptedException {
		Thread td = new Thread();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		
		// Click the Selenium dropdown
		WebElement dropDown = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(), 'Selenium')]"));
		dropDown.click();
		
		td.sleep(3000);
		
		// Navigate to Login page
		driver.findElement(By.xpath("//a[contains(text(), 'Login')]")).click();
		System.out.println("DONE: Navigate to Login Page");
		
		// Click the Forgot your password?
		driver.findElement(By.xpath("//a[contains(text(), 'Forgot your password?')]")).click();
		System.out.println("DONE: Forgot password has been clicked");
		
		// Input username and password then submit
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[@name='SubmitLogin']")).click();
		System.out.println("DONE: Login successful");
		
		td.sleep(3000);
		
		// Click the Selenium dropdown
		WebElement drpDown = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(), 'Selenium')]"));
		drpDown.click();
		
		// Navigate to Login page
		driver.findElement(By.xpath("//a[contains(text(), 'Drag and Drop Action')]")).click();
		System.out.println("DONE: Navigate to Drag and Drop Action Page");
		
		td.sleep(5000);
		
		String adsLink = "https://demo.guru99.com/test/success.html#google_vignette";
		td.sleep(5000);
		String getLink = driver.getCurrentUrl();
		System.out.println(getLink);
		if(getLink.equals(adsLink)) {
			driver.findElement(By.xpath("//div[@class='ns-33olp-e-14 button-common close-button']")).click();
		}

	}

}
