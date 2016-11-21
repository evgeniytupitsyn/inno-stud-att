package ru.innopolis.uni.course2.URL.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Андрей on 17.11.2016.
 */
public class Server {

    static final List<ServerThread> connections = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3456);
        while (true) {
            Socket socket = ss.accept();
            System.out.println("connected");
            ServerThread st = new ServerThread(socket);
            connections.add(st);
            st.start();
        }
    }
}
