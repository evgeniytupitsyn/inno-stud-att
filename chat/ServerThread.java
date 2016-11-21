package ru.innopolis.uni.course2.URL.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by Андрей on 17.11.2016.
 */
public class ServerThread extends Thread {

    private BufferedWriter writer;
    private Socket socket;

    public ServerThread (Socket socket) throws IOException {
        this.socket = socket;
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void run() {
        System.out.println("Connection started");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String str;
            while (true) {
                str = reader.readLine();
                System.out.println("debug: " + str);
                if (str.equals("end")) break;
                synchronized(Server.connections) {
                    for (ServerThread st : Server.connections) {
                        st.writer.write(str);
                        st.writer.newLine();
                        st.writer.flush();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
