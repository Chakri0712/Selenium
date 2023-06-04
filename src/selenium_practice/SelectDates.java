package selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDates {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.spicejet.com");

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button']")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("div[data-testid=\"departure-date-dropdown-label-test-id\"]")).click();

		driver.findElement(By.xpath(
				"//div[@data-testid='undefined-month-May-2023'] //div[@data-testid='undefined-calendar-day-30']"))
				.click();

		driver.findElement(By.xpath(
				"//div[@data-testid='undefined-month-June-2023'] //div[@data-testid='undefined-calendar-day-30']"))
				.click();

	}

}
