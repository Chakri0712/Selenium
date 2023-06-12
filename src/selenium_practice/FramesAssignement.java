package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesAssignement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Actions a = new Actions(driver);
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		
		WebElement top = driver.findElement(By.name("frame-top"));
		
		WebElement bottom = driver.findElement(By.name("frame-bottom"));
		
		driver.switchTo().frame(top);
		
		WebElement left = driver.findElement(By.name("frame-left"));
		
		WebElement right = driver.findElement(By.name("frame-right"));
		
		WebElement middle = driver.findElement(By.name("frame-middle"));
		
		driver.switchTo().frame(middle);
		
		System.out.println(driver.findElement(By.id("content")).getText());
		
		driver.switchTo().defaultContent();

	}

}
