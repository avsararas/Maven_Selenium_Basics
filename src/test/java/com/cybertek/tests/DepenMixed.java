package com.cybertek.tests;

import org.testng.annotations.*;

public class DepenMixed {

    @Test()
    public void openBrowser(){
        System.out.println("Browser is Opening");
    }

    @Test (dependsOnMethods = "openBrowser" )
    public void login(){
        System.out.println("Login");
    }

    @AfterMethod
    public void clear(){
        System.out.println("Browser is Closing");
    }
}