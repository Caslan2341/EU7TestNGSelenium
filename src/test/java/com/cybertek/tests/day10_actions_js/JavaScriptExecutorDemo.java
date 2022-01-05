package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class JavaScriptExecutorDemo {
    WebDriver driver = null;
    WebDriverWait wait = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("safari");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void clickWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",dropDownLink);

    }

    @Test
    public void typeWithJS(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String text = "Hello World with JS";

        jse.executeScript("arguments[0].setAttribute('value','" + text + "')", inputBox );

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i=0; i<10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,250)");
        }

        for (int i=0; i<10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }

    @Test
    public void scrollToElement() throws InterruptedException {

        driver.get("https://amazon.com");

        WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(1000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true);",eng);
    }
}













