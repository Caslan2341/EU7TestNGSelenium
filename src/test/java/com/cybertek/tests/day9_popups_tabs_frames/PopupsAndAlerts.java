package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PopupsAndAlerts {
    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //click confirm button
        driver.findElement(By.xpath("//span[.='Confirm']")).click();

        //click NO button
        driver.findElement(By.xpath("//span[.='No']")).click();

    }


    @Test
    public void test2() throws InterruptedException {
        Alert alert = driver.switchTo().alert();

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(1000);
        alert.accept();

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(1000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(1000);
        alert.sendKeys("sample");
        alert.accept();

    }

}
