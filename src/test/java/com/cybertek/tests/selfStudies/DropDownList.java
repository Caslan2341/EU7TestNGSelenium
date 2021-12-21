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

public class DropDownList {

    WebDriver driver = null;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {

        Random num = new Random();

        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
        Thread.sleep(1000);

        ArrayList<WebElement> option = new ArrayList<>(driver.findElements(By.xpath("//select[@id='dropdown']/option[@value]")));
        option.get(num.nextInt(1,3)).click();
        Thread.sleep(1000);

        ArrayList<WebElement> year = new ArrayList<>(driver.findElements(By.xpath("//*[@id='year']/option")));
        year.get(num.nextInt(0,100)).click();
        Thread.sleep(1000);

        ArrayList<WebElement> month = new ArrayList<>(driver.findElements(By.xpath("//*[@id='month']/option")));
        month.get(num.nextInt(0,12)).click();
        Thread.sleep(1000);

        ArrayList<WebElement> day = new ArrayList<>(driver.findElements(By.xpath("//*[@id='day']/option")));
        day.get(num.nextInt(0,31)).click();
        Thread.sleep(1000);

        ArrayList<WebElement> state = new ArrayList<>(driver.findElements(By.xpath("//*[@id='state']/option")));
        state.get(num.nextInt(1,52)).click();
        Thread.sleep(1000);

        ArrayList<WebElement> devLang = new ArrayList<>(driver.findElements(By.xpath("//*[@name='Languages']/option")));
        devLang.get(num.nextInt(0,6)).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")).click();
        Thread.sleep(2000);

        ArrayList<WebElement> webSite = new ArrayList<>(driver.findElements(By.xpath("//div[@aria-labelledby='dropdownMenuLink']/a[@href]")));
        webSite.get(num.nextInt(0,5)).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
