package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //locating radio buttons

        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        Thread.sleep(2000);

        redRadioButton.click();
        //how to check buttons selected
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());
        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        //verify blue is selected red is not selected
        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue is selected");
        Assert.assertTrue(redRadioButton.isSelected(),"verify that red is NOT selected");

        Thread.sleep(3000);
        driver.quit();

    }
}
