package ru.innopolis.uni.course2.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgeniytupitsyn on 03/11/2016.
 */
public class Main {
    //2
     /*public static void main(String[] args) throws InterruptedException {
        *//*Thread thread = new MyThread();
        thread.start();
        System.out.println("Main method closed!");*//*

        //2 способ
        //List<String> sharedNames = new ArrayList<>();
        List<Thread> threads = new ArrayList<>() ;
        Thread thread = null;
        for (int i=0; i<10; i++) {

            thread = new MyThread();
            threads.add(thread);
            thread.start();
        }

        for (Thread thread1: threads){
            thread1.join();
        }
        System.out.println(MyThread.sum);
    }*/

    public static void main(String[] args) throws InterruptedException {

        Object globalMonitor = new Object();
        Thread thread = new MyThread(globalMonitor);
        thread.start();

        calculate();
        synchronized (globalMonitor) {
            globalMonitor.notify();
        }
        //System.out.println("Main method is over!");
    }

        private static void calculate() {
        try{
            Thread.sleep(3_000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            System.out.println("Calculate is over!");
    }

}
