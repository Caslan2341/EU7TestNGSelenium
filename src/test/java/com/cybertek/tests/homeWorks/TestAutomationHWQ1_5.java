package com.cybertek.tests.homeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAutomationHWQ1_5 {

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

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Thread.sleep(1000);

        String expectedForm = "Registration form";
        String actualForm = driver.findElement(By.xpath("//div[@class='page-header']")).getText();
        Assert.assertEquals(expectedForm,actualForm,"Wrong page opened");


        WebElement dateOfBirth = driver.findElement(By.name("birthday"));
        Thread.sleep(1000);

        dateOfBirth.click();
        dateOfBirth.sendKeys("wrong_dob");

        WebElement warning = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        Assert.assertTrue(warning.isDisplayed());
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Thread.sleep(1000);

        String expectedForm = "Registration form";
        String actualForm = driver.findElement(By.xpath("//div[@class='page-header']")).getText();
        Assert.assertEquals(expectedForm,actualForm,"Wrong page opened");

        WebElement java = driver.findElement(By.xpath("//*[.='Java']"));
        WebElement cplus = driver.findElement(By.xpath("//*[.='C++']"));
        WebElement JScript = driver.findElement(By.xpath("//*[.='JavaScript']"));

        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(cplus.isDisplayed());
        Assert.assertTrue(JScript.isDisplayed());
    }

    @Test
    public void test3() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Thread.sleep(1000);

        String expectedForm = "Registration form";
        String actualForm = driver.findElement(By.xpath("//div[@class='page-header']")).getText();
        Assert.assertEquals(expectedForm,actualForm,"Wrong page opened");

        WebElement inputBox = driver.findElement(By.xpath("//input[@placeholder='first name']"));
        inputBox.click();
        inputBox.sendKeys("C");

        Assert.assertTrue(driver.findElement(By.xpath("//*[.='first name must be more than 2 and less than 64 characters long']")).isDisplayed());
    }

    @Test
    public void test4() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Thread.sleep(1000);

        String expectedForm = "Registration form";
        String actualForm = driver.findElement(By.xpath("//div[@class='page-header']")).getText();
        Assert.assertEquals(expectedForm,actualForm,"Wrong page opened");

        WebElement inputBox = driver.findElement(By.name("lastname"));
        inputBox.click();
        inputBox.sendKeys("C");

        Assert.assertTrue(driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).isDisplayed());

    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Thread.sleep(1000);

        String expectedForm = "Registration form";
        String actualForm = driver.findElement(By.xpath("//div[@class='page-header']")).getText();
        Assert.assertEquals(expectedForm,actualForm,"Wrong page opened");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='first name']")).click();

        driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("Mike");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='last name']")).click();

        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("Smith");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='username']")).click();

        driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("MSmith2341");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='email@email.com']")).click();

        driver.findElement(By.xpath("//input[@placeholder='email@email.com']")).sendKeys("msmith2341@gmail.com");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='password']")).click();

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("MSmith2341");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='phone']")).click();

        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("265-564-5698");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='male']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='birthday']")).click();

        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("01/01/1987");

        Thread.sleep(1000);
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='department']"));

        Thread.sleep(1000);
        Select dropDownOption = new Select(dropDown);

        dropDownOption.selectByValue("DE");

        Thread.sleep(1000);

        dropDown = driver.findElement(By.xpath("//select[@name='job_title']"));

        dropDownOption = new Select(dropDown);

        dropDownOption.selectByVisibleText("SDET");

        Thread.sleep(1000);

        driver.findElement(By.id("inlineCheckbox2")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success']/p")).isDisplayed());

        System.out.println("Test success");

    }
}

























