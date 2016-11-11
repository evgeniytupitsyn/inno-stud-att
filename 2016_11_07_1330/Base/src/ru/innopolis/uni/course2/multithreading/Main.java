package ru.innopolis.uni.course2.multithreading;

/**
 * Created by evgeniytupitsyn on 03/11/2016.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        new Main(300);
    }

    public Main(int startsession) throws InterruptedException {
        Ruler ruler = new Ruler();

        Thread1sec thread1Sec = new Thread1sec(ruler);
        Thread2 thread2 = new Thread2(ruler, "Alert! Test msg.");

        thread1Sec.start();
        thread2.start();

        System.out.println("Work!");
        Thread.sleep(startsession * 1000);

        thread1Sec.interrupt();
        thread2.interrupt();
    }

    class Thread1sec extends Thread {

        private Ruler app;

        public Thread1sec(Ruler app) {
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

    class Thread2 extends Thread {

        private Ruler app;
        private String message;

        public Thread2(Ruler app, String message) {
            this.app = app;
            this.message = message;
        }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                int n;
                try {
                    n = app.last();
                    System.out.println(n + " sec");

                    if (n % 5 == 0)
                        System.out.println(message);
                    if (n % 7 == 0)
                        System.out.println(message);

                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    class Ruler {

        private int d = 0;

        public synchronized void add() {
            this.d++;
            notify();
        }

        public synchronized int last() throws InterruptedException {
            wait();
            return this.d;
        }
    }
}
