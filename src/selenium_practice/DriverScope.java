package selenium_practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverScope {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		int c = driver.findElements(By.tagName("a")).size();
		
		System.out.println(c);
		
		//limiting the scope to footer
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		int fc = footerDriver.findElements(By.tagName("a")).size();
		
		System.out.println(fc);
		
		//limiting the scope further more to one part of the footer
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		int dc = columnDriver.findElements(By.tagName("a")).size();
		
		System.out.println(dc);
		
		clickOnTheLink(driver, columnDriver, dc);
		
		Set<String> windows =  driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		iterate(driver, dc, it);
		
		driver.quit();
	}

public static void clickOnTheLink(WebDriver driver, WebElement columnDriver, int dc) {
	
	for(int i=1; i<dc; i++) {
	
	String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
	
	columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);

	}
}

public static void iterate(WebDriver driver, int dc, Iterator<String> it) {
	
	for(int j=1; j<=dc; j++) {
		
		String k = "window"+Integer.toString(j);
		
		System.out.println(k);
		
		k = it.next();
		
		driver.switchTo().window(k);
		
		System.out.println(driver.getCurrentUrl());
		
	}
	
}

}


	


