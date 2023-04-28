package activityDay11;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class ScreenShotSample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try{
			
			Files.copy(screenShot, new File("/Users/collabera/Desktop/ScreenShots/ScreenShotSample.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		driver.close();

	}

}
