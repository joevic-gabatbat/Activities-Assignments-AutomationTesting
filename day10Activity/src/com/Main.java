package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class Main {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com/");
		
		HomePage hm = new HomePage();
		
		hm.inputEmail("Joe.123@gmail.com");
		
		hm.inputPassword("Password@123");

	}

}
