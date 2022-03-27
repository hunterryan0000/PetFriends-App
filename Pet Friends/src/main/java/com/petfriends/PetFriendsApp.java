package com.petfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

//Step 1: create class and Main method
//step 2: pom.xml file. Spring initializer or Copy/paste from old projects
//step 3: add Spring to the main method and SpringBoot annotation

@SpringBootApplication //Connects app to SpringBoot ... magic otw
public class PetFriendsApp {
    public static void main(String[] args) {
        SpringApplication.run(PetFriendsApp.class, args);
    }
}
