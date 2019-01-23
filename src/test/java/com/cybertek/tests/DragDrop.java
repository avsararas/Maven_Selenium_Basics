package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragDrop extends TestBase {

    @Test
    public void test(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        // actor.dragAndDrop(source,target).perform();

        actor.clickAndHold(source).moveToElement(target).
                release()
                .build() // Generates a composite action containing all actions so far
                .perform();




    }
}
