package ru.innopolis.uni.course2.javanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by evgeniytupitsyn on 17/11/2016.
 */
public class Main {
    public static void main(String[] args) { //basic goto server
        try {
            URL url = new URL("http://google.com");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ///
}
