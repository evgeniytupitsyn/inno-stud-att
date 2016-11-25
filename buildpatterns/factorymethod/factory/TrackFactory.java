package ru.innopolis.uni.course2.buildpatterns.factorymethod.factory;

import ru.innopolis.uni.course2.buildpatterns.factorymethod.Track;
import ru.innopolis.uni.course2.buildpatterns.factorymethod.Transport;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class TrackFactory implements TransportFactory {
    @Override
    public Transport factoryMethod() {
        return new Track();
    }
}
