package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class PopUp {

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
    public void PoUpTest(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//span[.='No']")).click(); // click no on the popup window



        //Assert.assertTrue(driver.getCurrentUrl().contains("default")); // checks the url with overloaded assert method
    }

    @Test
    public void PoUpTest2(){
        driver.get("https://sweetalert.js.org/");

        // trigger the pop up
        driver.findElement(By.xpath("(//button[@class=‘preview’])[2]")).click();

        // close the pop up
        driver.findElement(By.xpath("//button[.=‘OK’]")).click();
    }
}

