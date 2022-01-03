package com.cybertek.tests.homeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAutomationHWQ6 {
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

        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(1000);

        String tempEmail = driver.findElement(By.xpath("//span[@id='email']")).getText();

        Thread.sleep(1000);
        driver.navigate().to("http://practice-cybertekschool.herokuapp.com");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']")).click();

        driver.findElement(By.xpath("//input[@name='full_name']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Mike Smith");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(tempEmail);

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();

        Assert.assertEquals(actual,expected,"Verify the right selection");

        driver.navigate().to("https://www.tempmailaddress.com/");
        Thread.sleep(500);
        String emailAddressExpected = " do-not-reply@practice.cybertekschool.com";
        String emailAddressActual = driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[1]")).getText();
        Assert.assertEquals(emailAddressActual,emailAddressExpected,"Verify you get email from cybertekschool.com");
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id='schranka']/tr[1]/td[1]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='odesilatel']")).getText(),"do-not-reply@practice.cybertekschool.com","verify the email");

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='predmet']")).getText(),"Thanks for subscribing to practice.cybertekschool.com!","verify the subject");
    }
}
