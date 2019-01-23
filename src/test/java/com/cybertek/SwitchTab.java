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

public class SwitchTab {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/windows");
    }

    @AfterMethod
    public void close() throws InterruptedException {
       Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void changeTab(){
        driver.findElement(By.linkText("Click Here")).click();

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle); // prints window id generated

        Set<String>windowHandles = driver.getWindowHandles(); // returns a set

        for(String handle : windowHandles){

            System.out.println(handle);

            driver.switchTo().window(handle); // switches tabs according to the handle ID

            if(driver.getTitle().equals("New Window")){ // find the matching tab name and stop
                break;
            }
        }

      Assert.assertEquals(driver.getTitle(),"New Window"); // verify the page has been changed
        Assert.assertNotEquals(driver.getTitle(),"The Internet"); // again verify the page has been changed


    }


}
