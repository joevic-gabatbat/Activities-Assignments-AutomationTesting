package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestActivityDay11 {

	WebDriver driver;

	@Test(dataProvider = "data-provider", groups = "accounts", priority = 1)
	public void verifyLoginTestMethod(String username, String password) {

		try {
			WebElement loginButton = driver.findElement(By.id("nav-link-accountList"));

			loginButton.click();

			WebElement userName = driver.findElement(By.id("ap_email"));
			userName.sendKeys(username);

			WebElement continueButton = driver.findElement(By.id("continue"));
			continueButton.click();

			WebElement passWord = driver.findElement(By.id("ap_password"));
			passWord.sendKeys(password);

			WebElement signInButton = driver.findElement(By.id("signInSubmit"));
			signInButton.click();

			Thread.sleep(3000);
			String expectedTitle = "Amazon.com. Spend less. Smile more.";
			String title = driver.getTitle();
			if (expectedTitle.equals(title)) {
				Reporter.log("PASS: Login successfully.");
				Assert.assertEquals(title, expectedTitle);
			} else {
				Reporter.log("FAIL: Login failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Login failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "accounts", priority = 2, dependsOnMethods = { "verifyLoginTestMethod" })
	public void verifyAccountMethod() {

		try {
			
			Thread.sleep(3000);
			WebElement accountButton = driver
					.findElement(By.xpath("//a[@data-csa-c-slot-id = 'nav-link-accountList']"));
			accountButton.click();

			Thread.sleep(3000);
			WebElement profileButton = driver.findElement(By.xpath("//div[@data-card-identifier = 'YourProfiles']"));
			profileButton.click();

			Thread.sleep(3000);
			String accountName = driver.findElement(By.xpath("//p[@id='home-profile-0']")).getText();
			String expectedAccountName = "Joevic Gabatbat";

			if (accountName.equals(expectedAccountName)) {
				Reporter.log("PASS: Verify Account page successfully.");
				Assert.assertEquals(accountName, accountName);
			} else {
				Reporter.log("FAIL: Verify Account page failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Verify Account page failed. " + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "accounts", priority = 3, dependsOnMethods = { "verifyAccountMethod" })
	public void verifyOrdersMethod() {

		try {
			
			Thread.sleep(3000);
			WebElement accountButton = driver
					.findElement(By.xpath("//a[@data-csa-c-slot-id = 'nav-link-accountList']"));
			accountButton.click();

			Thread.sleep(3000);
			WebElement ordersButton = driver.findElement(By.xpath("//div[@data-card-identifier = 'YourOrders']"));
			ordersButton.click();

			Thread.sleep(3000);
			String orders = driver.findElement(By.xpath("//span[@class = 'num-orders']")).getText();
			String expected = "0 orders";

			if (orders.equals(expected)) {
				Reporter.log("PASS: Verify Orders page successfully.");
				Assert.assertEquals(orders, expected);
			} else {
				Reporter.log("FAIL: Verify Orders page failed.");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Reporter.log("FAIL: Verify Orders page failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "accounts", priority = 4, dependsOnMethods = { "verifyOrdersMethod" })
	public void verifyBrowsingHistoryTestMethod() {

		try {
			
			Thread.sleep(3000);
			Actions action = new Actions(driver);
			WebElement accountButton = driver.findElement(By.xpath("//a[@data-nav-ref='nav_youraccount_btn']"));
			action.moveToElement(accountButton).perform();

			Thread.sleep(3000);
			WebElement browsingHistoryButton = driver.findElement(By.xpath("//a[contains(@href,'browsinghistory')]"));
			action.moveToElement(browsingHistoryButton).perform();
			Thread.sleep(3000);
			browsingHistoryButton.click();

			Thread.sleep(3000);
			String expectedTitle = "Your Browsing History";
			String title = driver.getTitle();
			if (expectedTitle.equals(title)) {
				Reporter.log("PASS: Verify Browsing History page successfully.");
				Assert.assertEquals(title, expectedTitle);
			} else {
				Reporter.log("FAIL: Verify Browsing History page failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Verify Browsing History page failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "accounts", priority = 5, dependsOnMethods = { "verifyBrowsingHistoryTestMethod" })
	public void verifyCustomerServiceTestMethod() {

		try {
			
			Thread.sleep(3000);
			WebElement customerServiceButton = driver
					.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_help']"));
			customerServiceButton.click();

			Thread.sleep(3000);
			String expectedTitle = "Help & Contact Us - Amazon Customer Service";
			String title = driver.getTitle();
			if (expectedTitle.equals(title)) {
				Reporter.log("PASS: Verify Customer Service page successfully.");
				Assert.assertEquals(title, expectedTitle);
			} else {
				Reporter.log("FAIL: Verify Customer Service page failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Verify Customer Service page failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "process", priority = 6, dependsOnMethods = { "verifyCustomerServiceTestMethod" })
	public void verifySearchTestMethod() {

		try {
			
			Thread.sleep(5000);
			WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
			searchBar.sendKeys("computers");

			WebElement searchSubmitButton = driver.findElement(By.id("nav-search-submit-button"));
			searchSubmitButton.click();

			Thread.sleep(5000);
			String expectedTitle = "Amazon.com : computers";
			String title = driver.getTitle();
			if (expectedTitle.equals(title)) {
				Reporter.log("PASS: Search successfully.");
				Assert.assertEquals(title, expectedTitle);
			} else {
				Reporter.log("FAIL: Search failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Search failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "process", priority = 7, dependsOnMethods = { "verifySearchTestMethod" })
	public void verifyAddProductTestMethod() {

		try {
			
			Thread.sleep(5000);
			WebElement selectProduct = driver.findElement(
					By.xpath("//div[@data-index='1']/div/div/div/div/div/div/div/div/div/div/div[1]/span[1]/a"));
			selectProduct.click();

			Thread.sleep(5000);
			WebElement addToCartProduct = driver.findElement(By.id("add-to-cart-button"));
			addToCartProduct.click();

			// Will check if pop-up add to cart Element with id=attach-sidesheet-view-cart-button is displayed
			Thread.sleep(5000);
			try {
				Boolean viewCart = driver.findElement(By.id("attach-sidesheet-view-cart-button")).isDisplayed();
				if (viewCart) {
					WebElement viewcart1 = driver.findElement(By.id("attach-sidesheet-view-cart-button"));
					viewcart1.click();
				}
			} catch (Exception e) {
				System.out.println(
						"Unable to use id=attach-sidesheet-view-cart-button for pop-up add to cart verification, use xpath instead. \n"
								+ e);
				WebElement viewCart2 = driver.findElement(By.xpath("//a[@id='nav-cart']"));
				viewCart2.click();
			}

			Thread.sleep(5000);
			String cartCount = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
			String expectedCount = "1";
			if (expectedCount.equals(cartCount)) {
				Reporter.log("PASS: Add Product to Cart successfully.");
				Assert.assertEquals(cartCount, expectedCount);
			} else {
				Reporter.log("FAIL: Add to Cart failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Add to Cart failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "process", priority = 8, dependsOnMethods = { "verifyAddProductTestMethod" })
	public void verifyDeleteProductTestMethod() {

		try {

			Thread.sleep(5000);
			WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
			searchBar.clear();
			searchBar.sendKeys("cell phone");

			WebElement searchSubmitButton = driver.findElement(By.id("nav-search-submit-button"));
			searchSubmitButton.click();

			Thread.sleep(5000);
			WebElement selectProduct = driver.findElement(
					By.xpath("//div[@data-index='1']/div/div/div/div/div/div/div/div/div/div/div[1]/span[1]/a"));
			selectProduct.click();

			Thread.sleep(5000);
			WebElement addToCartProduct = driver.findElement(By.id("add-to-cart-button"));
			addToCartProduct.click();

			// Will check if pop-up add to cart Element with id=attach-sidesheet-view-cart-button is displayed
			Thread.sleep(5000);
			try {
				Boolean viewCart = driver.findElement(By.id("attach-sidesheet-view-cart-button")).isDisplayed();
				if (viewCart) {
					WebElement viewcart1 = driver.findElement(By.id("attach-sidesheet-view-cart-button"));
					viewcart1.click();
				}
			} catch (Exception e) {
				System.out.println(
						"Unable to use id=attach-sidesheet-view-cart-button for pop-up add to cart verification, use xpath instead. \n"
								+ e);
				WebElement viewCart2 = driver.findElement(By.xpath("//a[@id='nav-cart']"));
				viewCart2.click();
			}

			Thread.sleep(5000);
			WebElement deleteButton = driver.findElement(By.xpath("//input[@data-action='delete']"));
			deleteButton.click();

			Thread.sleep(5000);
			String cartCount = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
			String expectedCount = "1";
			if (expectedCount.equals(cartCount)) {
				Reporter.log("PASS: Delete Product from Cart successfully.");
				Assert.assertEquals(cartCount, expectedCount);
			} else {
				Reporter.log("FAIL: Delete Product from Cart failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Delete Product from Cart failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "process", priority = 9, dependsOnMethods = { "verifyDeleteProductTestMethod" })
	public void verifyAddTwoProductTestMethod() {

		try {

			Thread.sleep(5000);
			WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
			searchBar.clear();
			searchBar.sendKeys("computers");

			WebElement searchSubmitButton = driver.findElement(By.id("nav-search-submit-button"));
			searchSubmitButton.click();

			Thread.sleep(5000);
			WebElement selectProduct = driver.findElement(
					By.xpath("//div[@data-index='1']/div/div/div/div/div/div/div/div/div/div/div[1]/span[1]/a"));
			selectProduct.click();

			Thread.sleep(5000);
			WebElement addToCartProduct = driver.findElement(By.id("add-to-cart-button"));
			addToCartProduct.click();

			// Will check if pop-up add to cart Element with id=attach-sidesheet-view-cart-button is displayed
			Thread.sleep(5000);
			try {
				Boolean viewCart = driver.findElement(By.id("attach-sidesheet-view-cart-button")).isDisplayed();
				if (viewCart) {
					WebElement viewcart1 = driver.findElement(By.id("attach-sidesheet-view-cart-button"));
					viewcart1.click();
				}
			} catch (Exception e) {
				System.out.println(
						"Unable to use id=attach-sidesheet-view-cart-button for pop-up add to cart verification, use xpath instead. \n"
								+ e);
				WebElement viewCart2 = driver.findElement(By.xpath("//a[@id='nav-cart']"));
				viewCart2.click();
			}

			Thread.sleep(5000);
			WebElement searchBar2 = driver.findElement(By.id("twotabsearchtextbox"));
			searchBar2.clear();
			searchBar2.sendKeys("cell phones");

			WebElement searchSubmitButton2 = driver.findElement(By.id("nav-search-submit-button"));
			searchSubmitButton2.click();

			Thread.sleep(5000);
			WebElement selectProduct2 = driver.findElement(
					By.xpath("//div[@data-index='1']/div/div/div/div/div/div/div/div/div/div/div[1]/span[1]/a"));
			selectProduct2.click();

			Thread.sleep(5000);
			WebElement addToCartProduct2 = driver.findElement(By.id("add-to-cart-button"));
			addToCartProduct2.click();

			// Will check if pop-up add to cart Element with id=attach-sidesheet-view-cart-button is displayed
			Thread.sleep(5000);
			try {
				Boolean viewCart = driver.findElement(By.id("attach-sidesheet-view-cart-button")).isDisplayed();
				if (viewCart) {
					WebElement viewcart1 = driver.findElement(By.id("attach-sidesheet-view-cart-button"));
					viewcart1.click();
				}
			} catch (Exception e) {
				System.out.println(
						"Unable to use id=attach-sidesheet-view-cart-button for pop-up add to cart verification, use xpath instead. \n"
								+ e);
				WebElement viewCart2 = driver.findElement(By.xpath("//a[@id='nav-cart']"));
				viewCart2.click();
			}

			Thread.sleep(5000);
			String cartCount = driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
			String expectedCount = "3";
			Assert.assertEquals(cartCount, expectedCount);
			if (expectedCount.equals(cartCount)) {
				Reporter.log("PASS: Add two Product to Cart successfully.");
			} else {
				Reporter.log("FAIL: Add two Product to Cart failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("FAIL: Add two Product to Cart failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Test(groups = "accounts", priority = 10, dependsOnMethods = { "verifyAddTwoProductTestMethod" })
	public void verifyLogoutTestMethod() {

		try {

			Thread.sleep(5000);
			Actions action = new Actions(driver);
			WebElement accountButton = driver.findElement(By.xpath("//a[@data-nav-ref='nav_youraccount_btn']"));
			action.moveToElement(accountButton).perform();

			Thread.sleep(5000);
			WebElement logoutButton = driver.findElement(By.xpath("//a[@id='nav-item-signout']"));
			action.moveToElement(logoutButton).perform();
			Thread.sleep(3000);
			logoutButton.click();

			Thread.sleep(10000);
			String expectedTitle = "Logged out successfully";
			String title = driver.getTitle();
			if (expectedTitle.equals(title)) {
				Reporter.log("PASS: Logout successfully.");
				Assert.assertEquals(title, expectedTitle);
			} else {
				Reporter.log("NOTE: Intentionally failed, wrong title page. \n");
				Reporter.log("FAIL: Logout failed.");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Reporter.log("NOTE: Intentionally failed, wrong title page. \n");
			Reporter.log("FAIL: Logout failed." + e);
			Assert.assertTrue(false);
		}

	}

	@Parameters({ "url" })
	@BeforeClass
	public void beforeClass(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {

		driver.close();
		driver.quit();

	}

	@DataProvider(name = "data-provider")
	public Object[][] getDataSet() {
		return new Object[][] { { "09654450501", "Joevic@0506" } };
	}

}
