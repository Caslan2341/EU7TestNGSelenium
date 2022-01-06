package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {
    WebDriver driver = null;
    WebDriverWait wait = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /*@Test
    public void oneImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");



    }*/

    @Test
    public void multipleImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> imgs = driver.findElements(By.tagName("img"));
        List<WebElement> h5s = driver.findElements(By.tagName("h5"));
        Actions action = new Actions(driver);



        for (int i=0; i<3; i++){
            Thread.sleep(500);
            action.moveToElement(imgs.get(i)).perform();
            Thread.sleep(500);
            Assert.assertTrue(h5s.get(i).isDisplayed());

        }

    }
}
