package ru.innopolis.uni.course2.javanet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by evgeniytupitsyn on 17/11/2016.
 */
public class DatagramDemoClient {
    public static void main(String[] args) {
        DatagramDemoClient client = new DatagramDemoClient();
    }

    public DatagramDemoClient() {
        try {
            DatagramSocket s =
                    new DatagramSocket(3466);
            byte data[]=new byte[3];
            DatagramPacket p =
                    new DatagramPacket(data, 3);
            System.out.println("Waiting...");
            s.receive(p);
            System.out.println("Datagram received: "+
                    data[0]+", "+data[1]+", "+data[2]);
            s.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
