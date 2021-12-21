package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;


public class NewCheckBoxHW {
    /*
    Test Case Verify CheckBox CheckAll and UncheckAll Buttons
1. Go to
http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2. Login with-----Username: Tester, password: test
3. Click on check all button verify all the checkboxes are checked
4. Click on uncheck all button verify that all the checkboxes are unchecked
5. Select one of the checkbox and delete one person
6. Then verify that deleted item is no longer exists
    */

    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));

        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));

        password.sendKeys("test");

        WebElement loginBtn = driver.findElement(By.xpath("//*[@name='ctl00$MainContent$login_button']"));

        loginBtn.click();

        WebElement chekAllBoxes = driver.findElement(By.cssSelector("#ctl00_MainContent_btnCheckAll"));

        chekAllBoxes.click();


        ArrayList<WebElement> checkBoxInitial = new ArrayList<>(driver.findElements(By.cssSelector("input[type='checkbox']")));


        for (int i=2; i<=9; i++){

            WebElement checkBox = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl0"+ i + "_OrderSelector"));
            Assert.assertTrue(checkBox.isSelected(),"verify the checkBox" + i + " selected");
        }

        System.out.println("All Box Checked");

        WebElement uncheckAllBoxes = driver.findElement(By.cssSelector("#ctl00_MainContent_btnUncheckAll"));
        uncheckAllBoxes.click();

        for (int i=2; i<=9; i++){

            WebElement checkBox = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl0"+ i + "_OrderSelector"));
            Assert.assertFalse(checkBox.isSelected(),"verify the checkBox" + i + " NOT selected");
        }

        System.out.println("All Box UnChecked");

        Random num = new Random();
        int x = num.nextInt(2,10);

        WebElement delCheckBox = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl0"+ x + "_OrderSelector"));
        delCheckBox.click();

        WebElement deleteBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));
        deleteBtn.click();


        ArrayList<WebElement> checkBoxLast = new ArrayList<>(driver.findElements(By.cssSelector("input[type='checkbox']")));


        Assert.assertTrue(checkBoxInitial.size()>checkBoxLast.size(), "Verify the selected Item deleted");
        System.out.println("Selected Item Deleted");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(1500);
        driver.quit();
    }
}
