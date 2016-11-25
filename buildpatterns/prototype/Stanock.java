package ru.innopolis.uni.course2.buildpatterns.prototype;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class Stanock {
    private Coin prototype;

    public Stanock(Coin prototype){
        this.prototype = prototype;
    }

    public Coin createCoin() throws CloneNotSupportedException {
        return (Coin) this.prototype.clone();
    }
}
