package ru.innopolis.uni.course2.autoclosabletest;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by evgeniytupitsyn on 02/11/2016.
 */
public class MyResource implements Closeable {
    @Override
    public void close() throws IOException{
        System.out.println("Close method!");
        throw new RuntimeException("close");
    }
}
