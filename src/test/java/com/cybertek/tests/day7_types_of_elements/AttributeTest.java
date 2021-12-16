package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));

        System.out.println(blueRadioButton.getAttribute("value"));

        System.out.println(blueRadioButton.getAttribute("type"));

        System.out.println(blueRadioButton.getAttribute("name"));

        System.out.println(blueRadioButton.getAttribute("checked"));

        //trying to get attribute that does not exist
        //when we use non exist attribute it will return null to us
        System.out.println(blueRadioButton.getAttribute("href"));

        System.out.println(blueRadioButton.getAttribute("outerHTML"));

        driver.navigate().to("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println("Outer HTML : " + button2.getAttribute("outerHTML"));
        System.out.println("Inner HTML : " + button2.getAttribute("innerHTML"));

        driver.quit();
    }
}
