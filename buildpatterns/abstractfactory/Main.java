package ru.innopolis.uni.course2.buildpatterns.abstractfactory;

import ru.innopolis.uni.course2.buildpatterns.abstractfactory.factory.SWTUIFactory;
import ru.innopolis.uni.course2.buildpatterns.abstractfactory.factory.UIFactory;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        UIFactory uiFactory = new SWTUIFactory();
        Button button = uiFactory.createButton();
        Label label = uiFactory.createLabel();
        Input input = uiFactory.createInput();
        button.show();
        label.show();
        input.show();
    }
}
