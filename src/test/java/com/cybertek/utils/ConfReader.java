package com.cybertek.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfReader { // referring to the configuration.properties file in the root

    private static Properties props;

    static {
        String path = "configuration.properties";

        try {
            // Java needs inputstream to read files
            FileInputStream fis = new FileInputStream(path);

            //Reads porperties with key value pairs
            props = new Properties();

            // file content is load to properties through inputstream
            props.load(fis);

            // all inputstreams need to be closed
            fis.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
// returns the value of specific property
    public static String getProperty(String property){
        return props.getProperty(property);
    }
}
