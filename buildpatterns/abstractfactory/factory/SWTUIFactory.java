package ru.innopolis.uni.course2.buildpatterns.abstractfactory.factory;

import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Button;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Input;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Label;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.swt.SWTButton;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.swt.SWTInput;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.swt.SWTLabel;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class SWTUIFactory implements UIFactory{

    @Override
    public Button createButton() {
        return new SWTButton();
    }

    @Override
    public Label createLabel() {
        return new SWTLabel();
    }

    @Override
    public Input createInput() {
        return new SWTInput();
    }
}
