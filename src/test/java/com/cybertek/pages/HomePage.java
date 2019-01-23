package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    // In page object model we put all locators in this class
    //any page object needs a constructor for selenium to call objects properly
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this); // Needed Selenium method
    }

    // Selenium annotation needs a value and locator
    @FindBy(id = "ctl00_MainContent_username") // locator goes here
    public WebElement username;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginbtn;

    // login method
    public void login(String username, String password){
        this.username.sendKeys(username); // using same vars in class level
        this.password.sendKeys(password);
        loginbtn.click();

    }
}
