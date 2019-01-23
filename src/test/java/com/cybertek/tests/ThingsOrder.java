package com.cybertek.tests;

import org.testng.annotations.Test;

public class ThingsOrder {

    // Putting tests in order rather than alphabetical

    @Test(priority = 0)
    public  void test1(){
        System.out.println("Running Test 1");
    }

    @Test(priority = 5)
    public  void test2(){
        System.out.println("Running Test 1");
    }

    @Test(priority = 2)
    public  void test3(){
        System.out.println("Running Test 1");
    }

}
