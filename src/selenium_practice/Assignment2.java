package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();

		driver.findElement(By.id("checkBoxOption1")).click();
		
		String optionSelected = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		
		System.out.println(optionSelected);
		
		WebElement dropdown = driver.findElement(By.name("dropdown-class-example"));
		
		Select s = new Select(dropdown);
		
		s.selectByVisibleText(optionSelected);
		
		driver.findElement(By.name("enter-name")).sendKeys(optionSelected);
		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		
		alert(driver, alertText, optionSelected);
		
		driver.switchTo().defaultContent();
		
		driver.close();
		
	}

	public static void alert(WebDriver driver, String text, String option ) {
		
		if(text.contains(option)) {
			
			System.out.println(text);
			
			driver.switchTo().alert().accept();
			
		}
		
	}
}
