package ru.innopolis.uni.course2.URL.chat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Андрей on 17.11.2016.
 */
public class ClientReader extends Thread{

    private BufferedReader reader;

    public ClientReader(BufferedReader reader) {
        this.reader = reader;
        setDaemon(true);
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                String str = reader.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
