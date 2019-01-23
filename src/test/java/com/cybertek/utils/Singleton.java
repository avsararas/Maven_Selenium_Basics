package com.cybertek.utils;

public class Singleton {

    private static String str;

    public static String get(){

        if (str==null){
            System.out.println("Adding value");
            str="kelek";
        }

        return str;
    }

    public static void main(String[] args) {

        String one = Singleton.get();
        System.out.println("First Time:"+one); // first statement in if

        String two = Singleton.get();
        System.out.println("Second time:"+two); // assigned a value after if
    }
}
