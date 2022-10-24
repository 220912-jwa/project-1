package dev.cox;//package com.revature;

import dev.cox.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingPlayground {

    // we use a LogManager to instantiate our Logger Object
    private static Logger log = LogManager.getLogger(LoggingPlayground.class);


    public static void main(String[] args) {

        log.trace("This is what a trace looks like.");
        log.debug("this is debug");
        log.info("Logging Playground program started.");

        log.debug("This is a DEBUG level log");


        int num;
        log.warn("This variable 'num' is never used...");


        try {

            int x = 1/0;

        } catch (ArithmeticException e) {
            log.error("Error message: " + e.getMessage());
        }


        log.fatal("LOOKOUT!");
    }


}
