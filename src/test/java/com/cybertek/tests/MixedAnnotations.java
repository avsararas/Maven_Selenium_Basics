package com.cybertek.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MixedAnnotations {
    WebDriver driver; // define driver here to use in further tests

    @BeforeClass
    public void beforeClass(){
        System.out.println("Setting up web drivers");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("Open web address");
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }
    @Test
    public void testOne(){


    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Logout");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.quit();
    }
    @AfterClass

    public void afterClass(){

 }

}
