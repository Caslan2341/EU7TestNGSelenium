package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReporter extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //name of test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.userNameInput.sendKeys("User1");
        extentLogger.info("username : User1");

        loginPage.passwordInput.sendKeys("Somekeys");
        extentLogger.info("password : Somekeys");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
        extentLogger.pass("Wrong Password Test is Passed");
    }

    @Test
    public void wrongUserNameTest(){
        extentLogger = report.createTest("Wrong Username Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("username : someKeys");
        loginPage.userNameInput.sendKeys("someKeys");

        extentLogger.info("password : UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/loginqwe");
        extentLogger.pass("Wrong Username Test is Passed");
    }
}
