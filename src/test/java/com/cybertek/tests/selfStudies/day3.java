package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class day3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://facebook.com");

        Thread.sleep(2000);
        WebElement emailSection = driver.findElement(By.id("email"));
        emailSection.sendKeys("aslan1987@gmail.com");
        Thread.sleep(2000);

        WebElement passwordSection = driver.findElement(By.id("pass"));
        passwordSection.sendKeys("ca30041987");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.name("login"));
        submitButton.click();

    }
}
