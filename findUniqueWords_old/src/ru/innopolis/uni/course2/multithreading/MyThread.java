package ru.innopolis.uni.course2.multithreading;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by evgeniytupitsyn on 03/11/2016.
 */
public class MyThread extends Thread {

    private Object monitor;
    public MyThread(Object monitor){
        this.monitor = monitor;
    }
    
}
