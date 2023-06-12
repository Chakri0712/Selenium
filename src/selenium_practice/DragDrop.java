package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		
		Actions a = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();
		
		//switch to frame using index
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(0);
		
		//switch to frame using webelement locator
		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class= 'demo-frame']")));
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
	}

}
