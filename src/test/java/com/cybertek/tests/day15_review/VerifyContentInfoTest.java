package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContentInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();

       // loginPage.loginAsSalesManager();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username : " + username);
        extentLogger.info("password : " + password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to --> Customers > Contacts");
        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage = new ContactsPage();

        extentLogger.info("Click on mbrackstone9@example.com");
        contactsPage.waitUntilLoaderScreenDisappear();

        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectedName = "Mariam Brackstone";
        String fullName = contactInfoPage.name.getText();
        extentLogger.info("Verify Full Name is : " + expectedName);
        Assert.assertEquals(expectedName, fullName,"Verify Name");

        String expectedPhoneNumber = "+18982323434";
        String phoneNumber = contactInfoPage.phone.getText();
        extentLogger.info("Verify Phone Number is : " + expectedPhoneNumber);
        Assert.assertEquals(expectedPhoneNumber,phoneNumber,"Verify Phone Number");

        String expectedEmail = "mbrackstone9@example.com";
        String email = contactInfoPage.email.getText();
        extentLogger.info("Verify Email is : " + expectedEmail);
        Assert.assertEquals(expectedEmail,email,"Verify Email");

        extentLogger.pass("PASSED");




    }


}
