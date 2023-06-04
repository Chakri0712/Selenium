package selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SeliIntroduction {



    public static void main(String[] args) {

        //Invoking Browser

        //Chrome - ChromeDriver exten->Methods close get

        //Firefox- FirefoxDriver ->methods close get

        // WebDriver  close  get

        //WebDriver methods + class methods

        // Chrome

        System.setProperty("webdriver.chrome.driver", "D:/drivers_selenium/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://animepahe.ru/");

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        driver.close();

        //Firefox

        System.setProperty("webdriver.gecko.driver", "D:/drivers_selenium/geckodriver-v0.33.0-win64/geckodriver.exe");

        WebDriver driver1 = new FirefoxDriver();


        driver1.get("https://animepahe.ru/");

        System.out.println(driver1.getTitle());

        System.out.println(driver1.getCurrentUrl());

        driver1.close();


        //Microsoft Edge

        System.setProperty("webdriver.edge.driver", "D:/drivers_selenium/edgedriver_win64/msedgedriver.exe");

        WebDriver driver2 = new EdgeDriver();

        driver2.get("https://animepahe.ru/");

        System.out.println(driver2.getTitle());

        System.out.println(driver2.getCurrentUrl());

        driver2.close();
        //driver.quit();

    }

}