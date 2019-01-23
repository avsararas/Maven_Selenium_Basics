package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeSwitching {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tinymce");
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

    @Test
    public void switcher1(){
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.tagName("body")).sendKeys("leblebi");

    }

    @Test
    public void switcher2(){
        driver.switchTo().frame(0);
        driver.findElement(By.tagName("body")).sendKeys("leblebi");

    }
}
