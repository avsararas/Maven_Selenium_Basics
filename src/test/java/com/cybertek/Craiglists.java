package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Craiglists {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver kebab = new ChromeDriver();
        kebab.get("https://inlandempire.craigslist.org/");

        // Several ways to find an element on page

       //  kebab.findElement(By.name("query")).sendKeys("Takoz");
       // kebab.findElement(By.linkText("electronics")).click();
        kebab.findElement(By.partialLinkText("+gard")).click(); // partial text

    }
}
