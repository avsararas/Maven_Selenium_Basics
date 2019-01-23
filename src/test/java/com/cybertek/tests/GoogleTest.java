package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

// TestBase class containing drivers is a superclass

public class GoogleTest extends TestBase {

    @Test
    public void titleTest(){

        driver.get("https://google.com");
        driver.findElement(By.name("q"))
                .sendKeys("selenium cookbook"+ Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("selenium cookbook"));
    }
}
