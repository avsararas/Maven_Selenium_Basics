package com.cybertek;

// go to the web site and click on monday if it is not already clicked

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        // make it slower for some sites, otherwise it fails to find element
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement mon= driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));

        // check if Monday is selected, true/false
        if (!mon.isSelected()){
            mon.click(); // click on Monday
        }
        System.out.println(mon.isSelected());
    }
}
