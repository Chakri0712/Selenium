package selenium_practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class windowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		Set<String> windows =  driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		String text = driver.findElement(By.cssSelector(".im-para strong a")).getText();
		
		System.out.println(text);
		
		String[] mailname = text.split("@");
		
		System.out.println(mailname[1]);
		
		String name = mailname[1].split("\\.")[0];
		
		driver.switchTo().window(parentId);
		
		a.click(driver.findElement(By.id("username"))).sendKeys(name).build().perform();
	}

}
