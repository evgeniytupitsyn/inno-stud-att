package ru.innopolis.course2.buildpatterns;

import ru.innopolis.course2.buildpatterns.factory.TransportFactory;

/**
 * Created by evgeniytupitsyn on 21/11/2016.
 */
public class Ferm {

    private TransportFactory transportFactory;

    public Ferm(TransportFactory transportFactory){
        this.transportFactory = transportFactory;

    }

    public Ferm() {

    }

    public static void main(String[] args){     //точка входа
        Ferm ferm = new Ferm();     //создаём ферму
        ferm.start();
    }

    private void start() {
        /*создаём продукт и транспортируем его*/
        Object cargo = createProduct();
        this.transportFactory.factoryMethod().transport(cargo); //перевозим
    }

    private Object createProduct() {
        //полезные действия//
        return new Object();
    }
}
