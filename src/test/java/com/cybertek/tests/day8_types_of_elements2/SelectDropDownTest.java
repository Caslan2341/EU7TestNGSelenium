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

public class SelectDropDownTest {
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
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        //1. locate your dropdown just like any other webelement with unique locater
        WebElement dropdownElement = driver.findElement(By.id("state"));
        //2. create select object by passing that element as a constructor
        Select stateDropDown = new Select(dropdownElement);

        List<WebElement> options = stateDropDown.getOptions();

        System.out.println("options.size() = " + options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }


    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");

        //1. locate your dropdown just like any other webelement with unique locater
        WebElement dropdownElement = driver.findElement(By.id("state"));
        //2. create select object by passing that element as a constructor
        Select stateDropDown = new Select(dropdownElement);

        //verify that first selection is Select a State
        String expectedoption = "Select a State";

        String actualSelectionOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedoption,actualSelectionOption,"verify the options the same");

        //how we select option we want with visible text

        Thread.sleep(1000);
        stateDropDown.selectByVisibleText("Utah");

        expectedoption = "Utah";
        actualSelectionOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedoption,actualSelectionOption,"verify the option");

        //how we select option we want with index
        Thread.sleep(1000);
        stateDropDown.selectByIndex(51);

        expectedoption = "Wyoming";
        actualSelectionOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedoption,actualSelectionOption,"verify the option");

        //how we select option we want with value
        Thread.sleep(1000);
        stateDropDown.selectByValue("TX");

        expectedoption = "Texas";
        actualSelectionOption = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedoption,actualSelectionOption,"verify the option");

    }
}
