package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextDissapear extends TestBase {

    @Test

    public void verify1(){
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        // use ID  whenever possible instead of xpath
        WebElement text = driver.findElement(By.id("myDIV"));
        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//button[@class='w3-btn w3-hover-black w3-dark-grey']"));

        button.click();

        Assert.assertFalse(text.isDisplayed()); // check text disappears upon clicking the button

        // Assert.assertTrue(!text.isDisplayed()); // alternative


    }
}
