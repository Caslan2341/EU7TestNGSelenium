package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

   /* @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }*/

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //this page include 2 frame/html
        //how we switch to next frame
        //there is 2 option;
        //1.  name/ID
        driver.switchTo().frame("mce_0_ifr");

        //if we want clear the text area before send some keys. we use clear() method.
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //first way of goes back to main html
        driver.switchTo().defaultContent();

        //2. index way to switch the frame
        //main html not has a index number. index numbers begins at first child html.

        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with index");


        //this method allways turns to the main html
        driver.switchTo().defaultContent();

        //this method go back just one level up
        driver.switchTo().parentFrame();

        //3. way using web element switch to frame

        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with Web Element");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());

    }
}
