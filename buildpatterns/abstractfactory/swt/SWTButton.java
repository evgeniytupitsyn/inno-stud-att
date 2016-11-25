package ru.innopolis.uni.course2.buildpatterns.abstractfactory.swt;

import ru.innopolis.uni.course2.buildpatterns.abstractfactory.Button;

/**
 * Created by d.sapaev on 21.11.2016.
 */
public class SWTButton extends Button {
    @Override
    public void show() {
        System.out.println("This is the SWT button!!");
    }
}
