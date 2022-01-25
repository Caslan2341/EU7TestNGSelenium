package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        loginPage.userNameInput.sendKeys(ConfigurationReader.get("driver_username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager1(){

        LoginPage loginPage = new LoginPage();

        String userName = ConfigurationReader.get("storemanager_username");
        String passWord = ConfigurationReader.get("storemanager_password");

        loginPage.userNameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(passWord);
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoreManager3(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

}
