package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:/www.facebook.com/");
		
//		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
//		driver.findElement(By.cssSelector("input[id='password_step_input']")).click();
		
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.name("pass"));
		
		WebElement loginButton = driver.findElement(By.name("login"));
		username.sendKeys("Joe");
		password.sendKeys("ThePassword@123");
		loginButton.click();

	}

}
