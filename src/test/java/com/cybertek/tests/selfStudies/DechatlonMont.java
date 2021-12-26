package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class DechatlonMont {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

        //dechatlon ana sayfasını aç
        driver.get("https://www.decathlon.com.tr/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='didomi-notice-agree-button']")).click();
        Thread.sleep(500);

        //erkek menüsünü seç
        driver.findElement(By.xpath("//button[@class='menu-button svelte-1pqed2z']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='cat-01']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='cat-12']")).click();
        Thread.sleep(1000);

        //mont menüsünü aç
        driver.findElement(By.xpath("//span[text()='Montlar']/..")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@class='cta cta--outline cta--2nd cta--small'])[2]")).click();
        Thread.sleep(1000);

        //beden belirle
        driver.findElement(By.xpath("//span[text()='3XL']/../..")).click();
        Thread.sleep(1000);

        //tür belirle
        driver.findElement(By.xpath("//span[text()='Dış giyim']/../..")).click();
        Thread.sleep(1000);

        //sıralama
        driver.findElement(By.xpath("//button[@class='svelte-1whykta']")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//li[@id='option-list-sort-select-1']")).click();
        Thread.sleep(750);


        //min fiyat gir
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='input-price-min']")).click();
        action.doubleClick(driver.findElement(By.xpath("//input[@id='input-price-min']"))).perform();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='input-price-min']")).sendKeys("700");
        driver.findElement(By.xpath("//span[text()='Fiyat']")).click();
        Thread.sleep(2000);


        //ürünü seç
        driver.findElement(By.xpath("//div[@data-supermodelid='177091']")).click();
        Thread.sleep(1000);

        //beden seç
        driver.findElement(By.xpath("//button[@class='svelte-1whykta']")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//li[@id='option-product-size-selection-6']")).click();

        //sepete ekle
        driver.findElement(By.xpath("//button[@data-anly='pdp-add-to-cart']")).click();
        Thread.sleep(750);

        //sepete git
        driver.findElement(By.xpath("//a[@class='cart-button svelte-1xmi1u5']")).click();
        Thread.sleep(1000);

        //teslimat sayfsına git
        driver.findElement(By.xpath("//button[@class='cta cta--big svelte-ic3f7o']")).click();



    }
}
