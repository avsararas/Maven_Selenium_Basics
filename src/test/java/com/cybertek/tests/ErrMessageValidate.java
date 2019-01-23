package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.utils.ConfReader;
import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrMessageValidate extends TestBase {

    HomePage homePage = new HomePage(); // holds locator properties in its own class

    @Test
    public void wrongEmail(){

        // old version
        // driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        // new getting url from the external file
        driver.get(ConfReader.getProperty("url"));

        // comes from the HomePage class, taking over below driver.findEelement lines
        homePage.username.sendKeys("admin");
        homePage.username.sendKeys("test");
        homePage.loginbtn.click();

        // driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("admin");
        // driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        // driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        String error = "Invalid Login or Password.";
        String actualErr = driver.findElement(By.id("ctl00_MainContent_status")).getText();

        Assert.assertEquals(actualErr,error);
    }

    @Test
    public void wrongPass(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        // using shorter way
        homePage.username.sendKeys("Tester");
        homePage.username.sendKeys("wrong password");
        homePage.loginbtn.click();

        String expErr = "Invalid Login or Password.";
        String actErr = driver.findElement(By.id("ctl00_MainContent_status")).getText();

        Assert.assertEquals(actErr,expErr);
    }

    @Test
    public void blankUser(){

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        homePage.login("","password"); // blank username
    }
}
