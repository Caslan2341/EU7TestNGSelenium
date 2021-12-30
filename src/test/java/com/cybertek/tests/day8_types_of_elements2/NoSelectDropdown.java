package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));

        //click dropdownElement to see options
        dropdownElement.click();

        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());

        Assert.assertEquals(dropdownOptions.size(),5);

        for (WebElement dropdownOption : dropdownOptions) {
            System.out.println(dropdownOption.getText());
        }

        dropdownOptions.get(2).click();


    }
}
