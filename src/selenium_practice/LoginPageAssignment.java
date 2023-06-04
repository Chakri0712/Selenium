package selenium_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPageAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/"); // URL in the browser
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.xpath("//span[text()=' User']")).click();
				
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body p")));
		
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement dropdown = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		
		Select s = new Select(dropdown);
		
		s.selectByValue("consult");
		
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.name("signin")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()= 'ProtoCommerce']")));
		
		AddCart(driver);
		
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		
		driver.findElement(By.xpath("//button[contains(.,'Checkout')]")).click();
		
		driver.findElement(By.id("country")).sendKeys("India");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestions")));
		
		driver.findElement(By.xpath("//a[contains(text(),'India')]")).click();
				
		driver.findElement(By.cssSelector("label[for*='checkbox2']")).click();
		
		driver.findElement(By.cssSelector("input[value=\"Purchase\"]")).click();
		
		Assert.assertEquals(GetSuccessMsg(driver), "Success! Thank you! Your order will be delivered in next few weeks :-).");
		
		driver.close();
		
	}
	
	public static void AddCart(WebDriver driver) {
		
		List<WebElement> buttons = driver.findElements(By.cssSelector(".card-footer button"));
		
		for(int i=0; i<buttons.size(); i++ ) {
			
			buttons.get(i).click();
		}
		
	}
	
	public static String GetSuccessMsg(WebDriver driver) {
		
		WebElement div_element = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		
		List<WebElement> a_elements = div_element.findElements(By.xpath(".//a"));
		
        for (WebElement aElement : a_elements) {
        	
            // Remove the text within <a> tag
        	
            ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", aElement);
        }
        
        // Get the remaining text from the div element
        
        	String text = div_element.getText();
        	
        	System.out.println(text);
        	
        	return text; 	
	}
	
}
