package com.cybertek;

// select object is needed, dropdowns need two steps
// everything is webelement except dropdown which is a select element

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dropdown");
        // make it slower for some sites, otherwise it fails to find element
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
// 1- Select the elemtn with select tag
        WebElement sel = ((ChromeDriver) driver).findElementById("dropdown");
// 2- Create select object using webelement
        Select list = new Select(sel); // provide the above to the constructor
// print the selected object
        String selecedOption = list.getFirstSelectedOption().getText();
        System.out.println(selecedOption);

        // Print all available options
        List<WebElement> options = list.getOptions();
        System.out.println("Options Size:" + options.size());

        for (WebElement option:options) {
            System.out.println(option.getText()); // get text is needed to see the text
        }
        // 1- select different options by visible index
        list.selectByVisibleText("Option 2");
        System.out.println("Selected is: "+list.getFirstSelectedOption().getText());

        // 2- select different options by visible index
        list.selectByIndex(0);
        System.out.println("Selected is: "+list.getFirstSelectedOption().getText());

        // 3- select different options by visible index



    }
}
