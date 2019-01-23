package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchTab2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/");
    }

    @AfterMethod
    public void close() throws InterruptedException {
        //Thread.sleep(4000);
       // driver.close();
    }

    @Test
    public void changeTab(){
        driver.findElement(By.partialLinkText("Try it Yourself")).click();

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle); // prints window id generated

        Set<String> windowHandles = driver.getWindowHandles(); // returns a set

        for(String handle : windowHandles){

            System.out.println(handle);

            driver.switchTo().window(handle); // switches tabs according to the handle ID

            if(driver.getTitle().equals("New Window")){ // find the matching tab name and stop
                break;
            }
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("default")); // checks the url with overloaded assert method
    }
}
