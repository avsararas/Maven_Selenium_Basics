package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {

    @Test
    public void test() throws InterruptedException {

        driver.get("https://youtube.com");

        actor.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);

        actor.sendKeys(Keys.PAGE_DOWN).perform();


    }

}
