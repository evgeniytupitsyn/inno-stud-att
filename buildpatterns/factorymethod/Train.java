package ru.innopolis.uni.course2.buildpatterns.factorymethod;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class Train implements Transport {
    @Override
    public void transport(Object cargo) {
        System.out.println("This is the train!");
    }
}
