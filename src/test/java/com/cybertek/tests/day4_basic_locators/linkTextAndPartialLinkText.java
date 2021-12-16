package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        Thread.sleep(2000);
        link1.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement link4 = driver.findElement(By.partialLinkText("Example 4"));
        Thread.sleep(2000);
        link4.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
