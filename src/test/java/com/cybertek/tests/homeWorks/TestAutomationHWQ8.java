package com.cybertek.tests.homeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAutomationHWQ8 {
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

        driver.get("http://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();

        String expectedHeader = "Autocomplete";
        String actualHeader = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        Assert.assertEquals(expectedHeader,actualHeader,"wrong page!!");

        Thread.sleep(1000);
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='button']")).click();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You selected: United States of America","verify rigth selection!!");


    }
}
