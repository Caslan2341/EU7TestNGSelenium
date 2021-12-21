package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class YouTubeMostView {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.youtube.com/?gl=TR&hl=tr");
        //Thread.sleep(1500);

        driver.findElement(By.xpath("//input[@id='search']")).click();
        //Thread.sleep(1500);

        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium test otomasyon");
        //Thread.sleep(1500);

        driver.findElement(By.xpath("//*[@id='search-icon-legacy']")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//tp-yt-paper-button[@aria-label='Arama filtreleri']")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//yt-formatted-string[contains(text(), 'Görüntüleme sayısı')]/../../..")).click();
        Thread.sleep(1500);

        ArrayList<WebElement> views = new ArrayList<>(driver.findElements(By.xpath("//*[@id='metadata-line']/span[contains(text(), 'görüntüleme')]")));
        String[] viewCount = new String[views.size()];

        int x=0;
        for(int i=0; i<views.size(); i++){
            if(views.get(i).getText().contains(" B")){
                viewCount[x] = views.get(i).getText().substring(0, views.get(i).getText().indexOf(" B"));
                x++;
            }

        }
        System.out.println(Arrays.toString(viewCount));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
