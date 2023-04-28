package mercuryToursDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetLinks {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		// get the link
//		String url = driver.findElement(By.linkText("REGISTER")).getAttribute("href");
//		System.out.println(url);
		
		
		Actions actions = new Actions(driver);
		WebElement rightClickRegister = driver.findElement(By.linkText("Testing"));
		actions.contextClick(rightClickRegister).perform();
	}

}
