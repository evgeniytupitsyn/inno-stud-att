package ru.innopolis.course2.java8;

/**
 * Created by evgeniytupitsyn on 06/12/2016.
 */
public class LambdaTest {

    public static void main(String[] args){
      //  new Thread(() –> System.out.println("1")).start()

        //v2
        int i = 0;

        test(() –> {
                System.out.println(i);
        });
    }

    public void test(FunctionalInterface functionalInterface){
        functionalInterface.doSome();
    }
}
