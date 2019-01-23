package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        // make it slower for some sites, otherwise it fails to find element
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement blu = driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red = driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));

        blu.click();

    }
}
