package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEtsy extends TestBase {

    @Test
    public void test(){

    driver.get("https://etsy.com");
    driver.findElement(By.id("search-query")).sendKeys("gift"+ Keys.ENTER);

    softass.assertTrue(driver.getTitle().contains("AAA"));
    softass.assertAll(); // able to see the results of soft assertions

    }
}
