package mercuryToursDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchBrowser extends Thread{

	public static void main(String[] args) throws InterruptedException {
		
		Thread td = new Thread();
		
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
		
		System.out.println("DONE: Click on Register link");
		driver.findElement(By.linkText("REGISTER")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("firstName")).sendKeys("Joe");
		driver.findElement(By.name("lastName")).sendKeys("Gabatbat");
		driver.findElement(By.name("phone")).sendKeys("09654450501");
		driver.findElement(By.name("userName")).sendKeys("joevic.gabatbat@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("Cigaras");
		driver.findElement(By.name("city")).sendKeys("Magdalena");
		driver.findElement(By.name("state")).sendKeys("Laguna");
		driver.findElement(By.name("postalCode")).sendKeys("4007");
		
		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByValue("PHILIPPINES");
		
		driver.findElement(By.name("email")).sendKeys("joe123");
		driver.findElement(By.name("password")).sendKeys("joe@123");
		driver.findElement(By.name("confirmPassword")).sendKeys("joe@123");
		
		driver.findElement(By.name("submit")).click();
		
		String expectedOutput = "Note: Your user name is joe123.";
		
		String verifyReg = driver.findElement(By.xpath("//b[contains(text(),' Note: Your user name is ')]")).getText();
		System.out.println(verifyReg);
		if(verifyReg.equals(expectedOutput)) {
			System.out.println("DONE: Successfully registered");
		}else {
			System.out.println("FAIL: Registration Failed");
		}
		
		
//		driver.close();
//		driver.quit();
		
	}

}
