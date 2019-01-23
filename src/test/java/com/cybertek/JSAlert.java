package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSAlert { // JavaScript Popup different than HTML
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void close() throws InterruptedException {
        //Thread.sleep(4000);
        // driver.close();
    }

    @Test
    public void JSTest1(){
        driver.get("https://sweetalert.js.org");

        // triger the JS popup
        driver.findElement(By.xpath("(//button[@class='preview'])[1]")).click();

        Alert onebe = driver.switchTo().alert(); // Alert object done

        onebe.accept(); // cancel pupup
    }

    @Test
    public void JSTest2(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        // triger the JS popup
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        Alert onebe = driver.switchTo().alert(); // JS Alert object is set

        onebe.dismiss();
    }

    @Test
    public void JSTest3(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        // triger the JS popup
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert bunelan = driver.switchTo().alert(); // JS Alert object is set
        bunelan.sendKeys("Pata pata"); // type in the alert box
        bunelan.accept();
    }
}
