package com.mezmo.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    static void doSomething() throws Exception {
        doSomethingElse();
    }

    static void doSomethingElse() throws Exception {
        throw new Exception("This is the exception");
    }

    public static void main(String[] args) {
        logger.debug("Hello world!");

        try {
            doSomething();
        } catch (Exception e) {
            logger.error("Exception occurred", e);
        }
    }
}