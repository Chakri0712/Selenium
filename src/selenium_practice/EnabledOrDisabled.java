package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnabledOrDisabled {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com");
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).getAttribute("style"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button']")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).getAttribute("style"));
		
		if(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")).getAttribute("style").contains("background-color")) {
			
			System.out.println("enabled");
			Assert.assertTrue(true);
			
		}
		else {
			
			System.out.println("disabled");
			Assert.assertFalse(false);
		}
		
	}

}
