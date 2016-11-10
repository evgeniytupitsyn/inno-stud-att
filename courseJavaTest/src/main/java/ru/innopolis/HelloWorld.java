package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Created by evgeniytupitsyn on 10/11/2016.
 */
public class HelloWorld {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args){
        try {
            MDC.put("username", "Admin");
            logger.error("Method main executed");
            doSome();
        }finally {
            MDC.clear();
        }
    }

    private static void doSome() {
        logger.error("Method doSome executed");
    }
}
