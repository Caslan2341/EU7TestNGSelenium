package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //make browsers fullscreen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        Thread.sleep(1000);
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Cihan ASLAN");
        // you can write this code like this:
        // driver.findElement(By.name("full_name")).sendKeys("Cihan ASLAN");

        Thread.sleep(1000);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("aslan1987@gmail.com");
        // you can write this code like this:
        // driver.findElement(By.name("email")).sendKeys("aslan1987@gmail.com");


        Thread.sleep(1000);
        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();
        Thread.sleep(1000);
        WebElement homeButton = driver.findElement(By.id("wooden_spoon"));
        homeButton.click();
    }
}
