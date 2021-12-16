package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfimationMessage {
    public static void main(String[] args) throws InterruptedException {
        /*Verify confirmation message
        open browser
        go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!' */


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        String expectedEmail = "aslan1987@gmail.com";
        emailInputBox.sendKeys(expectedEmail);

        //verify that email is displayed in the input box
        //somehow we should get text from web elements
        //two main ways to get txt from webelements
            //1. getText()--> it will work %99 and it will return string
            //2. getAttribute("value") --> second way of getting text especially input boxes
        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actual email : " + actualEmail);

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //click on retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //verify that confirmation message says 'Your e-mail's been sent!'

       WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

       String expectedConfirmationMessage = "Your e-mail's been sent!";
       Thread.sleep(2000);
       if(actualConfirmationMessage.getText().equals(expectedConfirmationMessage)){
           System.out.println("Expected Message : " + expectedConfirmationMessage);
           System.out.println("Actual Message : " + actualConfirmationMessage.getText());
           System.out.println("PASS");
       }else{
           System.out.println("Expected Message : " + expectedConfirmationMessage);
           System.out.println("Actual Message : " + actualConfirmationMessage.getText());
           System.out.println("FAIL");
       }

       driver.quit();
    }
}
