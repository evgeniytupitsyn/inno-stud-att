package ru.innopolis.uni.course2.deadlock;

/**
 * Created by evgeniytupitsyn on 07/11/2016.
 */
public class Main {

    public static void main(String[] args) {
        Main test = new Main();

        final resourceA resourcea = test.new resourceA();
        final resourceB recourceb = test.new resourceB();

        Runnable thread1 = new Runnable() {
            public void run() {
                synchronized (resourcea) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (recourceb) {
                        System.out.println("Block resource 1");
                    }
                }
            }
        };

        Runnable thread2 = new Runnable() {
            public void run() {
                synchronized (recourceb) {
                    synchronized (resourcea) {
                        System.out.println("Block resource 2");
                    }
                }
            }
        };

        new Thread(thread1).start();
        new Thread(thread2).start();
    }

    private class resourceA {
        private int i = 5;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
            //System.out.println("test A");
        }
    }

    private class resourceB {
        private int i = 13;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
            //System.out.println("test B");
        }
    }
}
