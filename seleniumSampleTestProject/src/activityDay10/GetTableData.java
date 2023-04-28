package activityDay10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTableData {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/table.html");
		
		Thread.sleep(3000);
		
		List<WebElement> colCount;
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[contains(@cellspacing, 1)]/tbody/tr"));
		
		for(int i = 1; i <= rowCount.size(); i++) {
			colCount = driver.findElements(By.xpath("//table[contains(@cellspacing, 1)]/tbody/tr["+i+"]/td"));
			for(int j = 1; j <= colCount.size(); j++ ) {
				System.out.print(driver.findElement(By.xpath("//table[contains(@cellspacing, 1)]/tbody/tr["+i+"]/td["+j+"]")).getText()+"	");
			}
			System.out.println();
		}
	}

}
