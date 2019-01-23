package com.cybertek;

//go to amazon.com and check if a searched item still shows in the next page
// To get the text:
//1. element.getText();
//2. element.getAttribute("value");
//3. element.getAttribute("innerHTML");

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class AmazonSearch {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        String searchterm="charger";

        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys(searchterm+ Keys.ENTER);
// getText does not work, try getAttribute and value
        String actual= driver.findElement(By.id("twotabsearchtextbox"))
                .getAttribute("value");

        System.out.println("Actual item searched: "+actual);

        if (searchterm.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}
