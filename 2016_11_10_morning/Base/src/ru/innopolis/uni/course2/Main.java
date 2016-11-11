package ru.innopolis.uni.course2;

import java.io.IOException;

/**
 * Created by evgeniytupitsyn on 01/11/2016.
 */
public class Main implements FirstInterface, SecondInterface{


    //@Override
        public int doSome(int arg) throws IOException{
            Exception ex = null;
            ExceptionThrower exceptionThrower = new ExceptionThrower();
            try{
                exceptionThrower.throwEx();
                System.out.println("try block");
            }catch (IOException e) {
                System.out.println("catch block");
                ex = e;
                e.getStackTrace();
                throw e;
            }finally {
                System.out.println("finally block");
                throw new RuntimeException(ex);
            }

           // return arg;
        }

    @Override
    public void doSame(int arg) {
        return;
    }
}
