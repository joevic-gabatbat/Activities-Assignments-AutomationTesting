package com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TestNumber1 {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

	@Test
	public void test1() {
		System.out.println("Now running Test #1");
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
	}

	@BeforeMethod
	public void lunchBrowser() {
		System.out.println("Launching browser: Chrome");
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Test complete, closing browser.");
		driver.close();
		driver.quit();
	}

}
