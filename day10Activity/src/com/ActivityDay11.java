package com;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ActivityDay11 {
	
  @Test(priority = 2, groups = "Sample Methods")
  public void testSecondMethod() {
	  System.out.println("Launching Second Method");
	  Reporter.log("Launched Second Method");
  }
  
  @Parameters({"title"})
  @Test(priority = 3, dependsOnMethods={"testSecondMethod"}, groups = "Sample Methods")
  public void testThirdMethod(String title) {
	  String expectedTitle = "Hello World!";
	  System.out.println("Launching Third Method");
	  
	  // Intentionally making this third method fail
	  Assert.assertEquals(expectedTitle, title);
	  Reporter.log("Launched Third Method");
  }
  
  @Test(enabled = false, groups = "Sample Methods")
  public void testFirstMethod() {
	  System.out.println("Launching First Method");
	  Reporter.log("Launched First Method");
  }
  
  @Parameters({"browser"})
  @BeforeMethod
  public void beforeMethod(String browser) {
	  System.out.println("Launching browser: " + browser);
	  Reporter.log("Launching Browser Method");
  }

  @Parameters({"browser"})
  @AfterMethod
  public void afterMethod(String browser) {
	  System.out.println("Closing browser: " + browser);
	  Reporter.log("Launching Close Method");
  }
  
//
//  @BeforeClass
//  public void beforeClass() {
//  }
//
//  @AfterClass
//  public void afterClass() {
//  }
//
//  @BeforeTest
//  public void beforeTest() {
//  }
//
//  @AfterTest
//  public void afterTest() {
//  }
//
//  @BeforeSuite
//  public void beforeSuite() {
//  }
//
//  @AfterSuite
//  public void afterSuite() {
//  }

}
