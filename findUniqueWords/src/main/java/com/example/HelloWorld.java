package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Created by evgeniytupitsyn on 10/11/2016.
 */
public class HelloWorld {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    public static boolean test = false;
    public static void main(String[] args){
        try {
            MDC.put("username", "Admin");
            logger.error("Method main executed", new RuntimeException());
            test = new String("2").equals("14");
            //logger.error("Method main executed", ("2" > "14") );
            doSome();
        }finally {
            MDC.clear();
        }
    }

    private static void doSome() {
        //logger.error("Method doSome executed");
        logger.error("Method {} executed {}", "doSome", "!!");
    }
}
