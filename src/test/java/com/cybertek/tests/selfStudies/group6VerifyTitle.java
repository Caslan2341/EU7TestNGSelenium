package com.cybertek.tests.selfStudies;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class group6VerifyTitle {
    public static void main(String[] args) throws InterruptedException {

        /*Automation Task

        1- Open an empty browser
        2- Navigate to https://www.amazon.com/
        3- Get the page title
        4- Verify the title "Amazon.com. Spend less. Smile more."
        5- Navigate to https://www.youtube.com/
        6- Get the page title
        7- Verify the title "YouTube"
        8- Navigate back to https://www.amazon.com/
        9- Refresh the web page
        10-Quit the page

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        String amazonTitle = driver.getTitle();

        if(amazonTitle.equals("Amazon.com. Spend less. Smile more.")){
            System.out.println("Amazon title : " + amazonTitle);
            System.out.println("PASS");
        }else{
            System.out.println("Amazon title : " + amazonTitle);
            System.out.println("FAIL");
        }

        driver.navigate().to("https://www.youtube.com/");
        String youtubeTitle = driver.getTitle();

        if(youtubeTitle.equals("YouTube")){
            System.out.println("Youtube title : " + youtubeTitle);
            System.out.println("PASS");
        }else{
            System.out.println("Youtube title : " + youtubeTitle);
            System.out.println("FAIL");
        }

        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.quit();

    }
}
