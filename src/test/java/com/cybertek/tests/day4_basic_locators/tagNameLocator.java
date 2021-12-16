package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.tagName("input")).sendKeys("Cihan ASLAN with TagName");

        //we can use Tagname just one input is there or our input area the first input.

        driver.findElement(By.name("email")).sendKeys("aslan1987@gmaill.com");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
