package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.utils.TestBase;
import org.testng.annotations.Test;

public class Presta extends TestBase {

    HomePage hp = new HomePage();

    @Test
    public void test(){
        driver.get("http://automationpractice.com/index.php");
    }
}
