package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://youtube.com");
       // Thread.sleep(2000);
        //driver.navigate().to("https://facebook.com");
        //Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("title = " + title);
        driver.quit();
    }
}