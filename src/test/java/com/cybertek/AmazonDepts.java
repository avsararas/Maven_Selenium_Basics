package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.w3c.dom.html.HTMLSelectElement;

import java.util.List;

public class AmazonDepts {
    WebDriver driver;
    Select allDept;

    @BeforeClass
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");
    }

    @Test(priority = 1)  // run from here since the is no main method
    public void testDefault() {
        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));

        allDept = new Select(selectElement);

        String selectedOpt = allDept.getFirstSelectedOption().getText();

       // Assert.assertEquals(selectedOpt,"All");
    }
        @Test(priority = 2)  // run from here since the is no main method
        public void sortAlpha() {

        // list all text in the dropdown list options
        for (WebElement option: allDept.getOptions()) {
            System.out.println(option.getText());
        }

        // sort them alphabetically by comparing one with one after
            for (int i=0; i<allDept.getOptions().size()-1; i++){

                String currentItem = allDept.getOptions().get(i).getText();
                String nextItem = allDept.getOptions().get(i+1).getText();

                System.out.println("Comparing: "+currentItem+" to "+nextItem);

                Assert.assertTrue(currentItem.compareTo(nextItem)<=0);


            }
    }
    @Test(priority = 3)  // run from here since the is no main method
    public void click() throws InterruptedException {


        driver.findElement(By.cssSelector("i.hm-icon.nav-sprite")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='/gp/site-directory?ref_=nav_em_T1_0_2_2_33__fullstore']")).click();


        List<WebElement> mainsDepts = (List<WebElement>) driver.findElement(By.cssSelector("h2.fsdDeptTitle"));

        for (WebElement option: mainsDepts){

            System.out.println(option.getText());
        }

   }

    @AfterClass  // close the browser
    public void close(){

        driver.close();

    }
}
