package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	
	public void inputEmail(String email) {

		WebElement setEmail = driver.findElement(By.id("email"));
		setEmail.sendKeys(email);
		
	}
	
	public void inputPassword(String password) {
		
		WebElement setEmail = driver.findElement(By.id("pass"));
		setEmail.sendKeys(password);
		
	}
	
}
