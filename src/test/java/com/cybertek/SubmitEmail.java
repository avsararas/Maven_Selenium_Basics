package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

// https://the-internet.herokuapp.com/forgot_password
// go to the above
public class SubmitEmail {
    public static void main(String[] args) {

        // driver path for chrome using webdriver manager
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement input = driver.findElement(By.id("email"));
        // hits enter after email
       // input.sendKeys("someemail@someemail.com"+ Keys.ENTER);

        input.sendKeys("someemail@someemail.com");
        input.submit();

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.id("content")).getText();

        if (actual.equals(expected)){
            System.out.println("PASS");
        }else {

            System.out.println("FAIL");
            System.out.println(actual);


        }




    }
}
