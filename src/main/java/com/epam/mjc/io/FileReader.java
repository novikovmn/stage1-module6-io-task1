package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))){
            List<String[]> pairs = breakFileToPairs(bufferedReader);
            profile = constructProfile(pairs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }

    private Profile constructProfile(List<String[]> pairs){
        Profile profile = new Profile();
        for (int i = 0; i < pairs.size(); i++) {
            String[] tmp = pairs.get(i);
            if (tmp[0].equalsIgnoreCase("name")) {
                profile.setName(tmp[1]);
            }
            if (tmp[0].equalsIgnoreCase("age")) {
                profile.setAge(Integer.parseInt(tmp[1]));
            }
            if (tmp[0].equalsIgnoreCase("email")) {
                profile.setEmail(tmp[1]);
            }
            if (tmp[0].equalsIgnoreCase("phone")) {
                profile.setPhone(Long.parseLong(tmp[1]));
            }
        }
        return profile;
    }

    private List<String[]> breakFileToPairs(BufferedReader bufferedReader) throws IOException {
        List<String[]> pairs = new ArrayList<>();
        while(bufferedReader.ready()){
           String[] pair = bufferedReader.readLine().split(": ");
           pairs.add(pair);
        }
        return pairs;
    }
}
