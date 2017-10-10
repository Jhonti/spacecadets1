package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

    	//take input from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an email id...");
        String id = reader.readLine();

        // Construct the url and open stream
        String url = "http://www.ecs.soton.ac.uk/people/" + id;
        URL page = new URL(url);
        BufferedReader pagereader = new BufferedReader(new InputStreamReader(page.openStream()));


        /*
        Go through each line of the html until <title> is found,
        stop on that line
         */
        String line;
        while((line = pagereader.readLine()) != null){
            if (line.contains("<title>")){
                break;
            }
        }

        // Define start/end indexes, name contained between
        int finishindex = line.indexOf("|");
        int startindex =  line.indexOf(">") + 1;

        String name =  line.substring(startindex,finishindex);

        System.out.println(name);
    }
}
