package selenium_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class DropDowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(2);
		
		dropdown.selectByValue("INR");
		
		dropdown.selectByVisibleText("USD");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		driver.findElement(By.id("hrefIncAdt")).click();
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@value='IXI']")).click();
		
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();
		
		Thread.sleep(2000);	
		
		driver.findElement(By.id("autosuggest")).sendKeys("Am");
		
		Thread.sleep(2000);		
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("Cambodia")) {
				option.click();
				System.out.println(option.getText());
			}
		
		}
	
		//Assert.assertFalse(false);
	}

}

