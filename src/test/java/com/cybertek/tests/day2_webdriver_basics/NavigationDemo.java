package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        //driver.navigate().to("https://google.com"); direkt bu kodu da yazabilirsin. get ile aynı işlevi yapıyor.

        Thread.sleep(3000);//java dan glen bir kod/özellik. ilgili satırda bekleme kodu.

        driver.navigate().to("https://facebook.com");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();

        driver.close();
    }
}
