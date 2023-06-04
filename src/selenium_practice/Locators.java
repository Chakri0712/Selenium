package selenium_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    static WebDriver driver; // Declare WebDriver object outside the main method

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/drivers_selenium/chromedriver_win32/chromedriver.exe");

 
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.ilovepdf.com/");
            driver.findElement(By.xpath("//a[contains(text(),'Merge PDF')]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
            driver.findElement(By.xpath("//input[@placeholder=\"Enter your email\"]")).sendKeys("hello@gmail.com");
            driver.findElement(By.name("LoginForm[password]")).sendKeys("gdsfhsujhdw");
            driver.findElement(By.id("loginEmail")).clear();
            List<WebElement> elements = driver.findElements(By.cssSelector("input.input"));
            WebElement secondone = elements.get(1);
            secondone.clear();
     
    }      	
}

