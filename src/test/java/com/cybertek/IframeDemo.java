package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeDemo {

    // double HTML page due to iframe

    @Test
    public void test(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tinymce");

        // change focus with switching
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(iframe);

        // clear content/pre-set text
        driver.findElement(By.tagName("body")).clear();

        driver.findElement(By.tagName("body")).sendKeys("zorta");

        // switch back to the main frame
        driver.switchTo().parentFrame();

        // or in a deeper nested frame
        driver.switchTo().defaultContent();

        // go to the link on the bottom
        driver.findElement(By.linkText("Elemental Selenium")).click();


    }
}