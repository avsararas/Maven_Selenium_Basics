package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    // AutoIT, Sikuli or Robot Framework is needed to automate OS windows

@Test
    public void test(){
    driver.get("https://the-internet.herokuapp.com/upload");
    WebElement chooseFile = driver.findElement(By.id("file-upload"));

    String path = "C:\\Users\\admin\\Desktop\\test.txt";

    chooseFile.sendKeys(path);

    driver.findElement(By.id("file-submit")).click();

    // check if the File Uploaded message is shown on the next page
    Assert.assertTrue(
            driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());

}

}
