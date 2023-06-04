package selenium_practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		Thread.sleep(1000);
		
		driver.manage().window().maximize();
		
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select dropdown = new Select(staticDropdown);
		
		WebElement dateOfBirthField = driver.findElement(By.cssSelector("input[type='date']"));

        // Get the minimum and maximum date attributes
        String minDate = dateOfBirthField.getAttribute("min");
        String maxDate = dateOfBirthField.getAttribute("max");

        // Parse the minimum and maximum dates
        LocalDate minDateObj = LocalDate.parse(minDate);
        LocalDate maxDateObj = LocalDate.parse(maxDate);

        // Choose a date within the range
        LocalDate selectedDate = LocalDate.now().minusDays(7);  // Replace with your desired date logic

        // Format the selected date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = selectedDate.format(formatter);
		
		driver.findElement(By.name("name")).sendKeys("chakri");
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("email")).sendKeys("chakri@gmail.com");
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("chakri071220");
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("exampleCheck1")).click();
		
		Thread.sleep(1000);
		
		dropdown.selectByVisibleText("Male");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//label[contains(.,'Student')]")).click();
		
		Thread.sleep(1000);
		
        // Enter the date into the field
        dateOfBirthField.sendKeys(formattedDate);
        
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        
        WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        
        System.out.println(success.getText());
		
	

	}

}
