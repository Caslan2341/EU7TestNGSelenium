package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");
        //getting title with selenium
        //System.out.println(driver.getTitle());
        String title = driver.getTitle();//shorcut for creating variable--> after methods press alt + enter + enter
        System.out.println("title = " + title);// shorcut soutv+enter

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
