package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class handlingMouseActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.udemy.com");
		
		driver.manage().window().maximize();
		
		//Thread.sleep(3000);
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//span[text()='Udemy Business']"))).build().perform();
		
		a.click(driver.findElement(By.cssSelector(".ud-search-form-autocomplete-input"))).keyDown(Keys.SHIFT).sendKeys("java dsa").doubleClick().build().perform();
		
		

	}

}
