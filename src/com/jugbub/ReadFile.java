package com.jugbub;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {

    public static void readFile(String specifiedFile){
        String string = "";
        String[] stringArray;


        string = fileToString(specifiedFile);
        string = string.replaceAll("\\s+"," ");
        System.out.println(string);
        System.out.println(numberOfCharacters(string,'/'));
        System.out.println(numberOfCharacters(string,"///"));
        stringArray = string.split("///");
        System.out.println(Arrays.toString(stringArray));
    }

    static String[] removeEmptyStrings(String[] strings){
        int[] remove;

        for (int i = 0; i < strings.length; i++) {
            if(strings[i] == "")
                System.out.println("edit this");
        }
        return strings;
    }

    static String fileToString(String specifiedFile) {
        String data = "";

        try {
            File myObj = new File(specifiedFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }

    static int numberOfCharacters(String string, char wanted){
        final int STRING_LENGTH = string.length();
        int numberOfWanted = 0;

        for (int i = 0; i < STRING_LENGTH; i++) {
            if(string.charAt(i) == wanted)
                numberOfWanted++;
        }
        return numberOfWanted;
    }
    static int numberOfCharacters(String string, String wanted){
        final int STRING_LENGTH = string.length();
        final int WANTED_LENGTH = wanted.length();

        int numberOfWanted = 0;
        boolean matched = true;


        for (int i = 0; i < STRING_LENGTH - WANTED_LENGTH + 1; i++) {
            matched = true;
            for (int j = 0; j < WANTED_LENGTH; j++) {
                if(string.charAt(i+j) == wanted.charAt(j))
                    continue;
                else
                    matched = false;
            }
            if(matched)
                numberOfWanted++;
        }
        return numberOfWanted;
    }

}