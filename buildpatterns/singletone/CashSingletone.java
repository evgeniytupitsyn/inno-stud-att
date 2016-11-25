package ru.innopolis.uni.course2.buildpatterns.singletone;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class CashSingletone {

    public static CashSingletone getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private CashSingletone() {
    }

    private static class InstanceHolder{
       private static final CashSingletone INSTANCE = new CashSingletone();
    }
}
