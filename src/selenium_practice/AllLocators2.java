package selenium_practice;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class AllLocators2 {



public static void main(String[] args) {

// TODO Auto-generated method stub



//System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

WebDriver driver = new ChromeDriver();

// Sibling - Child to parent traverse

//header/div/button[1]/following-sibling::button[1]

driver.manage().window().maximize();

driver.get("https://rahulshettyacademy.com/AutomationPractice/");

System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());



System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());


}



}




