package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClicker extends TestBase {

    @Test
    public void test(){
    driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

    // switch to iframe
        driver.switchTo().frame("iframeResult");

        // Actions class needs an object to perform advanced interaction in the browser
        // like: doubleclick, drag-drop,

        // A constructor is needed with the new Actions object
        Actions actions = new Actions(driver);

        //Identify the web element for actions
        WebElement text = driver.findElement(By.id("demo"));

        // Important to use perform for the action to engage
        actions.doubleClick(text).perform();

        // Color check the element
        Assert.assertTrue(text.getAttribute("style").contains("red"));







    }
}
