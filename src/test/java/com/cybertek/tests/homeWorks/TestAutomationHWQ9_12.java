package com.cybertek.tests.homeWorks;

import com.cybertek.utilities.WebDriverFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAutomationHWQ9_12 {

    WebDriver driver = null;
    WebDriverWait wait = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Status Codes']/a")).click();
        String expected = "Status Codes";
        String actual = driver.findElement(By.xpath("//div[@class= 'example']/h3")).getText();
        Assert.assertEquals(actual,expected,"Verify the right page");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='200']")).click();
        Thread.sleep(1000);
        expected ="This page returned a 200 status code.";
        actual = driver.findElement(By.xpath("//div[@id='content']/div/p")).getText();

        Assert.assertTrue(actual.contains(expected),"Verify you select right option");
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Status Codes']/a")).click();
        String expected = "Status Codes";
        String actual = driver.findElement(By.xpath("//div[@class= 'example']/h3")).getText();
        Assert.assertEquals(actual,expected,"Verify the right page");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='301']")).click();
        Thread.sleep(1000);
        expected ="This page returned a 301 status code.";
        actual = driver.findElement(By.xpath("//div[@id='content']/div/p")).getText();

        Assert.assertTrue(actual.contains(expected),"Verify you select right option");
    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Status Codes']/a")).click();
        String expected = "Status Codes";
        String actual = driver.findElement(By.xpath("//div[@class= 'example']/h3")).getText();
        Assert.assertEquals(actual,expected,"Verify the right page");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='404']")).click();
        Thread.sleep(1000);
        expected ="This page returned a 404 status code.";
        actual = driver.findElement(By.xpath("//div[@id='content']/div/p")).getText();

        Assert.assertTrue(actual.contains(expected),"Verify you select right option");
    }

    @Test
    public void test4() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[.='Status Codes']/a")).click();
        String expected = "Status Codes";
        String actual = driver.findElement(By.xpath("//div[@class= 'example']/h3")).getText();
        Assert.assertEquals(actual,expected,"Verify the right page");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='500']")).click();
        Thread.sleep(1000);
        expected ="This page returned a 500 status code.";
        actual = driver.findElement(By.xpath("//div[@id='content']/div/p")).getText();

        Assert.assertTrue(actual.contains(expected),"Verify you select right option");
    }
}
