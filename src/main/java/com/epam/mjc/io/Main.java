package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File(Main.class.getClassLoader().getResource("Profile.txt").getPath());

        FileReader fileReader = new FileReader();

        Profile profile = fileReader.getDataFromFile(file);

        System.out.println(profile);



    }
}

