package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) throws InterruptedException {

        /*Verify URL changed
        open browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent*/


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");



        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("aslan1987@gmail.com");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        Thread.sleep(3000);
        retrievePasswordButton.click();

        String urlCurrent = driver.getCurrentUrl();
        String urlExpected = "http://practice.cybertekschool.com/email_sent";

        if(urlCurrent.equals(urlExpected)){
            System.out.println("PASS");
            System.out.println("Expected URL: " + urlExpected);
            System.out.println("Current URL : " + urlCurrent);
        }else{
            System.out.println("FAIL");
            System.out.println("Expected URL: " + urlExpected);
            System.out.println("Current URL : " + urlCurrent);
        }
        Thread.sleep(3000);
        driver.quit();



    }
}
