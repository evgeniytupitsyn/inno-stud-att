package ru.innopolis.course2.buildpatterns;

import ru.innopolis.course2.buildpatterns.abstractfactory.Button;
import ru.innopolis.course2.buildpatterns.abstractfactory.Input;
import ru.innopolis.course2.buildpatterns.abstractfactory.Label;
import ru.innopolis.course2.buildpatterns.abstractfactory.factory.SWTUIFactory;
import ru.innopolis.course2.buildpatterns.abstractfactory.factory.UIFactory;

/**
 * Created by evgeniytupitsyn on 21/11/2016.
 */
public class Main {
    public static void main(String[] args){
        UIFactory uiFactory = (UIFactory) new SWTUIFactory();
        Button button = uiFactory.createButton();
        Label label = uiFactory.createLabel();
        Input input = uiFactory.createInput();
        button.show();
        label.show();
        input.show();
    }
}
