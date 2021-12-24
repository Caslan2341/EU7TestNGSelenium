package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonProductSelectV2 {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

   /* @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        Thread.sleep(1000);
        searchBox.click();

        searchBox.sendKeys("asus vivobook pro 15");
        //Thread.sleep(1000);

        driver.findElement(By.id("nav-search-submit-button")).click();
        //Thread.sleep(1000);

        driver.findElement(By.xpath("//li[@id='p_n_feature_twenty-two_browse-bin/23447271011']")).click();
        //Thread.sleep(1500);

        driver.findElement(By.xpath("//li[@id='p_n_operating_system_browse-bin/17702486011']")).click();
       // Thread.sleep(1500);

        driver.findElement(By.xpath("//li[@id='p_n_size_browse-bin/2423841011']")).click();
      //  Thread.sleep(1500);

        driver.findElement(By.xpath("//li[@id='p_n_feature_twenty-nine_browse-bin/23447647011']")).click();
      //  Thread.sleep(1500);

        driver.findElement(By.xpath("//li[@id='p_n_feature_four_browse-bin/2289792011']")).click();
        //Thread.sleep(1500);

        driver.findElement(By.xpath("//li[starts-with(@id, 'p_n_feature_twenty-three_browse-bin/135807')]")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']")).click();
        Thread.sleep(1500);
    }
}
