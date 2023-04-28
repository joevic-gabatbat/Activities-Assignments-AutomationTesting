package activityDay10;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4CheckBrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://shopee.ph/");

		HttpURLConnection huc = null;
		String url = "";
		int responseCode = 200;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> il = links.iterator();

		int totalCountLinks = 0;
		int totalCountBrokenLinks = 0;

		while (il.hasNext()) {
			totalCountLinks++;
			url = il.next().getAttribute("href");
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				responseCode = huc.getResponseCode();

				if (responseCode >= 400) {
					totalCountBrokenLinks++;
				}
//				else {
//					System.out.println("This is a valid link: " + url);
//				}

			} catch (MalformedURLException e) {
				System.out.println("Broken link: " + url);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Broken link: " + url);
				e.printStackTrace();
			}
		}

		System.out.println("Total links found: " + totalCountLinks);
		System.out.println("Total broken links found: " + totalCountBrokenLinks);
		
		driver.close();
		driver.quit();

	}

}
