package ru.innopolis.uni.course2.URL.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Андрей on 17.11.2016.
 */
public class Client {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 3456);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
            try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {
                String str = "";
                ClientReader clientReader = new ClientReader(reader);
                clientReader.start();
                while (!str.equals("end")) {
                    str = scan.nextLine();
                    writer.write(str);
                    writer.newLine();
                    writer.flush();
                }
            }
        }
    }
}
