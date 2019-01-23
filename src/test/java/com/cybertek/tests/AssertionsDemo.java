package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

    // Tool compares and verifies the values and automatically report the results

    @Test
    public void testOne(){
        String str1 = "A";
        String str2 = "A";

        Assert.assertEquals(str1,str2);
    }

    @Test
    public void testTwo(){
        String str1 = "A";
        String str2 = "B";

        Assert.assertEquals(str1,str2);
    }

    @Test
    public void testThree(){
        String str1 = "ABBA";
        String str2 = "AB";

        Assert.assertTrue(str1.contains(str2)); // checks boolean value
        System.out.println("TESTING DONE"); // If any test should fail this will not run
    }
}

