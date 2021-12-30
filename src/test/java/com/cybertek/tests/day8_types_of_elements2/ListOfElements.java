package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

   /* @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }*/

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our Web Elements inside the List
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("button size() is : " + buttons.size());

        Assert.assertEquals(buttons.size(), 6, "verify buttons size");

        for (WebElement button : buttons) {
            System.out.println(button.getText());
        }

        for (WebElement button : buttons) {
            System.out.println("button.isDisplayed() : " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(), "verify button is displayed");
        }
        //click the element of the List.
        buttons.get(1).click();


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        /*ddWebElement button = driver.findElement(By.tagName("buttonasfdsafa"));
        in this case test will be fail. Because there is no element found.*/

        List<WebElement> buttons = driver.findElements(By.tagName("buttonasfdsafa"));
        /*but in this case test will not be failed, By the way we must verify (assert) the size of List for to be sure
        the success */

    }

}
