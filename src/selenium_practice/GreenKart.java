package selenium_practice;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GreenKart {
	
	
	static String [] items = {"Brocolli", "Cauliflower", "Tomato", "Grapes"};
	
	static int j= 0;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/"); // URL in the browser
		
		driver.manage().window().maximize();
		
		GreenKart cart = new GreenKart();
		
		cart.addItems(driver);
		
		driver.findElement(By.cssSelector(".cart-icon img")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()= 'PROCEED TO CHECKOUT']")).click();
		
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.xpath("//button[text()= 'Apply']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[text()= 'Place Order']")).click();
		
		Thread.sleep(1000);
		
		WebElement selectoption = driver.findElement(By.cssSelector("div select"));

		Select dropdown = new Select(selectoption);
		
		dropdown.selectByValue("India");
		
		Thread.sleep(1000);

		driver.findElement(By.cssSelector("input.chkAgree")).click();
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[text()= 'Proceed']")).click();
		
	}
	
	public void addItems(WebDriver driver) throws InterruptedException {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size();i++) {
			
			String item =  products.get(i).getText();
			
			String[] name = item.split(" - ");
			
			System.out.println(name[0]);
			
			List<String> veggies = Arrays.asList(items);
			
			if(veggies.contains(name[0])) {
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				Thread.sleep(2000);
				
				j++;
				
				if(j == veggies.size()) {
					
					break;
				}
				
			}
			
		}
	}

}
