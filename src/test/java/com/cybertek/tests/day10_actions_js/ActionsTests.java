package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    WebDriver driver = null;
    WebDriverWait wait = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("safari");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        //Actions class contains all user the user interactions

        Actions actions = new Actions(driver);

        //movetoElement method moves your mouse to over your Web Element(hover over)
        //perform method complete the action
        Thread.sleep(1000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(),"verify view link displayed!");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        wait.until(ExpectedConditions.elementToBeClickable(source));

        driver.findElement(By.xpath("//*[.='Accept Cookies']")).click();

        Thread.sleep(1500);

        actions.dragAndDrop(source,target).perform();
        //this two way does same action
        //actions.moveToElement(source).clickAndHold().moveToElement(target).pause(1500).release().perform();


    }
}
