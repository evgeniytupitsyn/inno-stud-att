package ru.innopolis.course2.buildpatterns.singletone;

import static java.time.chrono.HijrahChronology.INSTANCE;

/**
 * Created by evgeniytupitsyn on 21/11/2016.
 */
public class CashSingletone {

/*    private static CashSingletone getInstance(){
        return InstanceHolder.INSTANCE;
    }

    public static synchronized CashSingletone getInstance(){
        if(INSTANCE == null)
            synchronized (CashSingletone.class){
                if (INSTANCE ==  null)
            }
            INSTANCE = new CashSingletone();
        return INSTANCE;
    }*/

    private CashSingletone(){

    }
}
