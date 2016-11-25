package ru.innopolis.uni.course2.buildpatterns.factorymethod;

import ru.innopolis.uni.course2.buildpatterns.factorymethod.factory.TrackFactory;
import ru.innopolis.uni.course2.buildpatterns.factorymethod.factory.TransportFactory;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class Ferm {
    private TransportFactory transportFactory;

    public Ferm(TransportFactory transportFactory ){
        this.transportFactory = transportFactory;
    }

    public static void main(String[] args) {
        Ferm ferm = new Ferm(new TrackFactory());
        ferm.start();
    }

    public void start() {
        /*создаем продукт*/
        Object cargo = createProduct();
        /*транспортируем*/
        this.transportFactory.factoryMethod().transport(cargo);
    }

    private Object createProduct() {
        /*Генерируем какие-то полезные действия*/
        return new Object();
    }

    public TransportFactory getTransportFactory() {
        return transportFactory;
    }

    public void setTransportFactory(TransportFactory transportFactory) {
        this.transportFactory = transportFactory;
    }
}
