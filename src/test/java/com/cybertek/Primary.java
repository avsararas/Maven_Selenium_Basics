package com.cybertek;

import com.github.javafaker.Faker;

public class Primary {

    public static void main(String[] args) {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker(); // This has been imported from Maven Repository, POM file dependency

        System.out.println(faker.address().country());
    }

}
