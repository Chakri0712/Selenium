package selenium_practice;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AllLocators {
	
	static WebDriver driver = new ChromeDriver();
	String[] message;
	static String newPassword;

    public static void main(String[] args) throws InterruptedException {
    	

        //implicit wait - 5 seconds time out

        System.setProperty("webdriver.chrome.driver", "D:/drivers_selenium/chromedriver_win32/chromedriver.exe");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        driver.findElement(By.className("signInBtn")).click();

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        
        AllLocators a = new AllLocators();
        
        newPassword = a.password();
        
        //System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(newPassword);

        driver.findElement(By.id("chkboxOne")).click();

        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        
        Thread.sleep(2000);
        
        Assert.assertEquals(driver.findElement(By.cssSelector(".login-container p")).getText(), "You are successfully logged in.");
        
        Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello rahul,");

        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
    }
    
    public String password() {
    	message=driver.findElement(By.cssSelector("form p")).getText().split("'");
    	return message[1];
    }

}
