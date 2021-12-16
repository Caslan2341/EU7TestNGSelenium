package com.cybertek.tests.day5_xPath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

        WebElement searcBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searcBox.sendKeys("Java");

        //click search button
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        WebElement result = driver.findElement(By.xpath("//span[contains(text(), 'results for')]"));

        String resultText = result.getText();

        String expextedResult = "1-48 of over 6,000 results for";

        if(expextedResult.equals(resultText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expextedResult);
            System.out.println("resultText = " + resultText);
        }

        driver.quit();
    }
}
