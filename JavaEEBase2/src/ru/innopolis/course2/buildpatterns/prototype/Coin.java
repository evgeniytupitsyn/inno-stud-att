package ru.innopolis.course2.buildpatterns.prototype;

/**
 * Created by evgeniytupitsyn on 21/11/2016.
 */
public class Coin implements Cloneable {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public Coin(int value){

    }
}
