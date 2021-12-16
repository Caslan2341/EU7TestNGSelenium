package com.cybertek.tests.day7_testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BeforeAfterMethod {

    @Test
    public void test1(){

        System.out.println("First Test Case");

    }

    @Test
    public void test2(){
        System.out.println("Second test case");
    }

    @Ignore
    @Test
    public void test3(){
        System.out.println("Third test case");
    }

    //we use "@Ignore" syntax for ignore any test case

    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver, Openning Driver");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Browser,Quit");
    }

    //before-after methods run with all tests(her case ile ayrı ayrı çalışır)
}
