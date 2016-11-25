package ru.innopolis.uni.course2.buildpatterns.prototype;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Coin coin = new Coin(5);
        Stanock stanock = new Stanock(coin);

        Coin firstClone = stanock.createCoin();
        Coin secondClone = stanock.createCoin();
        System.out.println("firstClone value = " + firstClone.getValue() + " firstClone = " + firstClone);
        System.out.println("secondClone value = " + secondClone.getValue() + " secondClone = " + secondClone);
    }
}
