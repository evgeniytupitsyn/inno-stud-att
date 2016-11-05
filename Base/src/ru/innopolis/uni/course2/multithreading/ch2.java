package ru.innopolis.uni.course2.multithreading;

import java.util.TimerTask;

/**
 * Created by evgeniytupitsyn on 03/11/2016.
 */
public class ch2 {

    public static void main(String[] args) throws InterruptedException {
        Messenger m1 = new Messenger(1, 1);
        Messenger m5 = new Messenger(5, 2);
        Messenger m7 = new Messenger(7, 3);
        m1.run();
        m5.run();
        m7.run();
    }

    public class Messenger implements Runnable {
        int time;
        int id;

        /**
         * @param time time in seconds
         * @param id   id of thread
         */
        Messenger(int time, int id) {
            this.time = time * 1000;
            this.id = id;
        }

        //@Override
        public void run() {

            Timer timer = new Timer();
            timer.schedule(new SayHello(id), 0, time);
        }

        class SayHello extends TimerTask {
            int id;

            SayHello(int id) {
                this.id = id;
            }

          //  @Override
            public void run() {
                System.out.printf("I'm thread with id=%d\n", id);
            }
        }
    }
}
