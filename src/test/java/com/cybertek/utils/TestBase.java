package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver; // access modifier is needed for subclass access
    protected SoftAssert softass;
    protected Actions actor; // set actions here for all subclass use

    @BeforeClass
    public void setUpClass(){

     //  WebDriverManager.chromedriver().setup(); // moved to Driver class
    }

    @BeforeMethod
    public void setUpMethod(){

        driver = Driver.getDriver(); // this is done by the driver class, static variable

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actor = new Actions(driver);

        softass = new SoftAssert();
    }

    @AfterMethod
    public void closeMethod(){
       // driver.quit(); // old
        // Driver.closeDriver(); // new
        softass.assertAll();
    }
}
