package ru.innopolis.uni.course2.multithreading;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by evgeniytupitsyn on 03/11/2016.
 */
public class MyThread extends Thread {

   /* public void run(){
        for (int i = 0; i<1000; i++){
            System.out.println(i);
        }
    }*/

/*   //2
    static int sum = 0;
    static Object monitor = new Object();
*//*
    MyThread(Collection sharedResource){
        this.sharedResource = sharedResource;
    }*//*

    @Override
    public void run(){
        for (int i = 0; i<1000000; i++){
            synchronized (monitor){  //передаём один монитор
                sum++;
            }
        }
    }*/


    ///3

    private Object monitor;
    public MyThread(Object monitor){
        this.monitor = monitor;
    }

    @Override
    public void run(){
        System.out.println("Thread runned!");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                System.out.println("This - catch block!");
            }
        }
        System.out.println("Thread execution!");
    }
}
