package ru.innopolis.uni.course2.javanet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by evgeniytupitsyn on 17/11/2016.
 */
public class NetServer {
    public static final int PORT = 2500;
    private static final int TIME_SEND_SLEEP = 100;
    private static final int COUNT_TO_SEND = 3;
    private ServerSocket servSocket;

    public static void main(String[] args) {
        NetServer server = new NetServer();
        server.go();
    }

    public NetServer() {
        try{
            servSocket = new ServerSocket(PORT);
        } catch(IOException e) {
            System.err.println("Unable to open Server Socket : " + e.toString());
        }
    }

    public void go() {

        // Класс-поток для работы с
        //подключившимся клиентом
        class Listener implements Runnable {
            Socket socket;
            public Listener(Socket aSocket) {
                socket = aSocket;
            }
            public void run() {
                try {
                    System.out.println("Listener started");
                    int count = 0;
                    OutputStream out = socket.getOutputStream();
                    OutputStreamWriter writer = new
                            OutputStreamWriter(out);
                    PrintWriter pWriter = new PrintWriter(writer);
                    while (count<COUNT_TO_SEND) {
                        count++;
                        pWriter.print(((count>1)?", ":"")+ "Something" + count);
                        sleeps(TIME_SEND_SLEEP);
                    }
                    pWriter.close();
                } catch(IOException e) {
                    System.err.println("Exception : " + e.toString());
                }
            }
        }

        // Основной поток, циклически выполняющий метод accept()
        System.out.println("Server strated");
        while (true) {
            try {
                Socket socket = servSocket.accept();
                Listener listener = new Listener(socket);
                Thread thread = new Thread(listener);
                thread.start();
            } catch(IOException e) {
                System.err.println("IOException : " + e.toString());
            }
        }
    }

    public void sleeps(long time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException e) {
        }
    }
}
