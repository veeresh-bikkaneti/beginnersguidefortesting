package com.guide.beginners.testng.samplejava.attributes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class PriorityAalwaysRun {
    private static Logger logger = LogManager.getLogger(PriorityAalwaysRun.class.getName( ));

    /*
    alwaysRun - 	If set to true, this test method will always be run even if it depends on a method that failed.
    priority - 	The priority for this test method. Lower priorities will be scheduled first.
     */
    @Test(alwaysRun = true, priority = 0)
    void priority0() {
        logger.info("#priority = 0: Test");
    }

    @Test(alwaysRun = true, priority = 2)
    void priority3() {
        logger.info("#priority = 2: Test");
    }

    @Test(alwaysRun = true, priority = 1)
    void priority1() {
        logger.info("#priority = 1: Test");
    }


}
