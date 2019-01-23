package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementRemove extends TestBase {

    @Test
    public void verify1(){
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");

        // need to swith to iframe
        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.xpath("//body/p"));
        System.out.println(text.getText());
        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//body/button"));
        button.click();

        // Element is invisible on the page and will give an error

        Assert.assertFalse(elementExist(By.xpath("//body/p")));
    }

    // new method using By class for locators
    public boolean elementExist(By zort){

       try { // try finding it, else return false
           driver.findElement(zort);
           return true;
       }catch (NoSuchElementException e){
           return false;

       }

    }
     // Using findelementS
    public boolean elementDisp (By zart){
        return driver.findElements(zart).isEmpty();
    }
}

