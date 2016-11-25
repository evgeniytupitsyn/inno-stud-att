package ru.innopolis.ioctest;

import ru.innopolis.ioctest.handler.DataHandler;

/**
 * Created by evgeniytupitsyn on 24/11/2016.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});

        //DataHandler dataHandler = new DataHandler();

        DataHandler dataHandler = (DataHandler) applicationContext.getBean("dataHandler");

        dataHandler.hadleData("someSrcPath", "someDestPath");
    }
}
