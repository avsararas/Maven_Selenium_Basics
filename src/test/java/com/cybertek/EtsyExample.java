package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EtsyExample {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://etsy.com");
        // make it slower for some sites, otherwise it fails to find element
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement inp = driver.findElement(By.id("search-query"));
        inp.sendKeys("decal");
       // below will not work due to spaces in the class name
        // WebElement sub = driver.findElement(By.className("btn btn-primary"));
        // will use xpath
        // element that has a tag 'button' and attribute 'type' with the value 'submit'
        // XPATH:  //button[@type='submit']
        // E - tag name
        // A - attribute
        // t - value of that attribute
        // E[@A='t']

        WebElement submit = driver.findElement
                (By.xpath("//button[@class='btn btn-primary']")); // E[@A='t']
        submit.click();

    }
}
