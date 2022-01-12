package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrendyolProductBuy {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        //trendyol.com a git
        driver.get("https://www.trendyol.com/");
        Thread.sleep(1000);

        //Pop Up reklamı kapat
        driver.findElement(By.xpath("//div[@class='modal-close']")).click();
        Thread.sleep(1000);

        //Search box ı seç ve arama kelimesini gir.
        driver.findElement(By.xpath("//input[@class='search-box']")).click();
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys("xiaomi mi 10t pro");
        Thread.sleep(1000);

        //Search iconuna bas
        driver.findElement(By.xpath("//i[@class='search-icon']")).click();
        Thread.sleep(1500);

        //Pop up ı kapat
        driver.findElement(By.xpath("//div[@class='overlay']")).click();
        Thread.sleep(1000);

        //Akıllı Cep Telefonları seçilecek
        driver.findElement(By.xpath("//div[contains(text(), 'Akıllı Cep Telefonu')]/..")).click();
        Thread.sleep(1000);

        //Mi 10T Pro ürününü seç
        driver.findElement(By.xpath("//span[contains(text(), 'Mi 10T Pro')]")).click();
        Thread.sleep(2000);

        //Ürün özelliklerini aç
        /*if(driver.findElement(By.xpath("//a[@title='256 GB']")).isSelected()){
            driver.findElement(By.xpath("//div[contains(text(), 'Sepete Ekle')]/..")).click();
        }else{
            driver.findElement(By.xpath("//a[@title='256 GB']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[contains(text(), 'Sepete Ekle')]/..")).click();
        }*/

        driver.findElement(By.xpath("//div[contains(text(), 'Sepete Ekle')]/..")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Sepetim")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//i[@class='i-trash']")).click();
    }
}
