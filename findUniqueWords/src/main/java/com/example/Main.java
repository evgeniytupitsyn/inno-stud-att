/**
 * Created by evgeniytupitsyn on 09/11/2016.
 */
package com.example;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Application started");
        System.out.println("I'm the main project");
        LOG.info("Application finished");
    }
}