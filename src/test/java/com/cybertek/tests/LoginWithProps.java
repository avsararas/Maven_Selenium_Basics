package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.utils.ConfReader;
import com.cybertek.utils.TestBase;
import org.testng.annotations.Test;

public class LoginWithProps extends TestBase {

    @Test
    public void readProp(){
        String browser = ConfReader.getProperty("browser");

        driver.get(ConfReader.getProperty("url")); // url from external file
        HomePage hp = new HomePage();

        String usn = ConfReader.getProperty("username");
        String pwd = ConfReader.getProperty("password");

        hp.login(usn, pwd);

    }
}
