package ru.innopolis.uni.course2.buildpatterns.factorymethod.factory;

import ru.innopolis.uni.course2.buildpatterns.factorymethod.Train;
import ru.innopolis.uni.course2.buildpatterns.factorymethod.Transport;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class TrainFactory implements TransportFactory{

    @Override
    public Transport factoryMethod() {
        return new Train();
    }
}
