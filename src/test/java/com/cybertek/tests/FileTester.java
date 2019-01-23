package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTester {

    @Test
    public void test(){

        // check the current folder location
        String currentFolder = System.getProperty("user.dir");

        System.out.println(currentFolder);

        // check where the user folder is located in the local system
        String userFolder = System.getProperty("user.home");

        System.out.println(userFolder);

        // Set a path on local
        String path = userFolder+"/Downloads/hebe.txt";
        // or \\Downloads\\hebe.txt"; double back slash

        System.out.println(path);

        // check if the files exist in the local path
        Assert.assertTrue(Files.exists(Paths.get(path)));


    }
}
