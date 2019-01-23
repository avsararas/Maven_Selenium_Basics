package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class XpathMulti {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement submit = driver.findElement

// using two stage xpath

        (By.xpath("//form[]")); // E[@A='t']
        submit.click();



    }
}

