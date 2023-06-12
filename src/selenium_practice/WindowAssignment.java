package selenium_practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Actions a = new Actions(driver);
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> windows =  driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();
		
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
		driver.switchTo().window(parentId);
		
		System.out.println(driver.findElement(By.cssSelector("#content .example h3")).getText());
		
		driver.close();
	}

}
