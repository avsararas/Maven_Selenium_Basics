package com.cybertek.tests;

import org.testng.annotations.*;

public class TestNgDemo {

    // In any unit testing tool annotations are used in methods

    @Test
    public void testOne(){ System.out.println("Hello One!"); }

    @BeforeMethod // runs each time before any @ test method runs
    public void beforeMethod(){ System.out.println("BeforeMethod"); }

    @BeforeClass // runs one time per class only
    public void beforeClass(){ System.out.println("BeforeClass"); }

    @Test
    public void testTwo(){ System.out.println("Hello Two!"); }

    @Test // tests run in alphabetical order of method names
    public void testThree(){ System.out.println("Hello Three!"); }

    @AfterMethod
    public void testAfterMethod(){ System.out.println("AfterMethod"); }

    @AfterClass
    public void testAfterClass(){ System.out.println("AfterClass"); }

}



