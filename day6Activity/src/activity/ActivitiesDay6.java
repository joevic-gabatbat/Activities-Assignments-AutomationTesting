package activity;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActivitiesDay6 extends Thread {

	static WebDriver driver = new ChromeDriver();
	static Thread t1 = new Thread();

	public static void main(String[] args) throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		loginMethod();
		
		t1.sleep(10000);

		String pageTitle = driver.getTitle();
		System.out.println("Page title is: " + pageTitle);

		getProduct1();
		
		t1.sleep(15000);
		
		getProduct2();
		
		t1.sleep(10000);
		
		// View cart and show the products
		WebElement viewCart = driver.findElement(By.id("attach-sidesheet-view-cart-button"));
		viewCart.click();
		
		driver.close();
		driver.quit();
	}
	
	// This is for login method
	public static void loginMethod() throws InterruptedException {
		
		WebElement loginButton = driver.findElement(By.id("nav-link-accountList"));

		loginButton.click();

		t1.sleep(10000);

		WebElement username = driver.findElement(By.id("ap_email"));
		username.sendKeys("09654450501");

		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();

		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("Joevic@0506");

		WebElement signInButton = driver.findElement(By.id("signInSubmit"));
		signInButton.click();
	}
	
	// This is for product 1
	public static void getProduct1() throws InterruptedException {
		
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("cell phone");

		WebElement searchSubmitButton = driver.findElement(By.id("nav-search-submit-button"));
		searchSubmitButton.click();

		t1.sleep(15000);

		WebElement selectProduct1 = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a"));
		selectProduct1.click();

		WebElement addToCartProduct1 = driver.findElement(By.id("add-to-cart-button"));
		addToCartProduct1.click();
	}
	
	
	// This is for product 2
	public static void getProduct2() throws InterruptedException {
		
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("computers");

		WebElement searchSubmitButton = driver.findElement(By.id("nav-search-submit-button"));
		searchSubmitButton.click();
		
		t1.sleep(15000);

		WebElement selectProduct2 = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a"));
		selectProduct2.click();

		WebElement addToCartProduct2 = driver.findElement(By.id("add-to-cart-button"));
		addToCartProduct2.click();
	}

}
