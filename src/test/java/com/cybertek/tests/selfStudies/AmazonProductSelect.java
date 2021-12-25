package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;

public class AmazonProductSelect {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        Thread.sleep(1000);
        searchBox.click();
        searchBox.sendKeys("asus vivobook pro 15");

        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        Thread.sleep(1000);
        searchBtn.click();

        ArrayList<WebElement> searchingItems = new ArrayList<>(driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/..")));

        Random num = new Random();
        searchingItems.get(num.nextInt(0,searchingItems.size())).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();



    }

  @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(4000);
        driver.quit();
    }
}
