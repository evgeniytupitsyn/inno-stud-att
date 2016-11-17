package ru.innopolis.uni.course2.javanet;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by evgeniytupitsyn on 17/11/2016.
 */
public class ClientJava {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 3456);
            InputStream is = s.getInputStream();
            System.out.println("Read: "+is.read());
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
