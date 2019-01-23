package com.cybertek.pages;

import com.cybertek.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrestaHome {

    public PrestaHome(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (linkText = "Sign in")
    public WebElement signIn;

    public WebElement product(String proName){
        String xpath = "(//h5//a[@title='"+proName+"'])[1]"; // dynamic xpath changing middle part accordingly
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
}
