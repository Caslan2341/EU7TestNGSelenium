package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";

        DashboardPage dashboardPage = new DashboardPage();

        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify Subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        actualSubtitle = calendarEventsPage.getPageSubTitle();
        expectedSubtitle = "Calendar Events";

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify subtitle!");

        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,10);
        calendarEventsPage.createCalendarEvent.click();


        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        //BrowserUtils.waitForClickablility(createCalendarEventsPage.repeat,10);
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected());

        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());
    }


    /*
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */


    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,10);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();

        List<WebElement> actualOptions = repeatsDropdown.getOptions();

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly","Yearly");

        List<String> actualList = new ArrayList<>();

        for (WebElement option:actualOptions) {
            actualList.add(option.getText());
        }

        //ready method for getting text of list of web elements
        //List<String> actualList = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(expectedList, actualList, "Verify options Daily, Weekly, Monthly,Yearly");

    }


}
