package ru.innopolis.uni.course2.javanet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by evgeniytupitsyn on 17/11/2016.
 */
public class ServerJava {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(3456);
            System.out.println("Ожидание подключения клиента...");
            Socket client=ss.accept();
            System.out.println("Подключён");
            client.getOutputStream().write(99);
            client.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}