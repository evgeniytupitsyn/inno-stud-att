package ru.innopolis.uni.course2.multithreading;

/**
 * Created by evgeniytupitsyn on 07/11/2016.
 */
public class Thread1 extends Thread {
    private Main.A app;

    public Thread1(Main.A app) {
        this.app = app;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            this.app.add();
        }
    }
}
