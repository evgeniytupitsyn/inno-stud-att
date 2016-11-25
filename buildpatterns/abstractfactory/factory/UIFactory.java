package ru.innopolis.uni.course2.buildpatterns.abstractfactory.factory;

import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Button;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Input;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Label;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public interface UIFactory {
    public Button createButton();
    public Label createLabel();
    public Input createInput();
}
