package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class YouTubeVideoSearch {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.youtube.com");
        Thread.sleep(1500);
        WebElement searchArea = driver.findElement(By.xpath("//input[@id='search']"));
        searchArea.click();
        Thread.sleep(1000);
        searchArea.sendKeys("elgajiye");
        driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[starts-with(@title, 'Mikail Aslan  - Elqajiye')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();

    }
}
