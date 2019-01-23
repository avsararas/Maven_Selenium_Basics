package com.cybertek.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver; // singleton design, static; initialized once

    //constructor to prevent anyone else to create the same object
    private Driver(){

    }

    // getter checks if the driver has a value given before
    // and it will be initialized
    public static WebDriver getDriver(){
        if (driver==null){

            // Without the configuration.properties file use
            //WebDriverManager.chromedriver().setup();
            //driver=new ChromeDriver();

            // get browser info form the external file
            String browser = ConfReader.getProperty("browser");

            // select driver according to browser type
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){ // reset driver to null
        if (driver!=null){
            driver.quit(); // quitting is not enough, need to set null
            driver=null;
        }

    }
}


