package ru.innopolis.uni.course2.buildpatterns.abstractfactory.swt;

import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Input;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class SWTInput extends Input {
    @Override
    public void show() {
        System.out.println("This is the SWT input!");
    }
}
