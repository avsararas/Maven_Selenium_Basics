package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://amazon.com");

        WebElement signIn = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
        actor.moveToElement(signIn).perform();

        driver.findElement(By.xpath("//span[.='Your Hearts']")).click();

        Assert.assertTrue(driver.getTitle().contains("Interesting"));

    }

    @Test
    public void test2(){
        driver.get("https://amazon.com");

        // scrolls down on the page to Help link
        WebElement helpLink = driver.findElement(By.xpath("(//a[.='Help'])[2]"));

        actor.moveToElement(helpLink).perform(); // moves to the bottom

    }
}
