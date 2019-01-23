package com.cybertek.tests;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SleepAndImplicitWaitExample { // does not extend testbase

    // for waiting puropses thread.sleep is not advised but can be used

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void closer()throws InterruptedException{
        Thread.sleep(1000);
        Driver.closeDriver();
    }

    @Test
    public void testSleep() throws InterruptedException{

    driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
    driver.findElement(By.tagName("button")).click();

        Thread.sleep(10000); // put here to make the code wait for the text

        System.out.println(driver.findElement(By.id("finish")).getText());

    }


    @Test
    public void implicitWait(){

        // waits while finding elements in 10 seconds as defined below
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();

        // implicit wait applies here
        System.out.println(driver.findElement(By.id("finish")).getText());

    }


}
