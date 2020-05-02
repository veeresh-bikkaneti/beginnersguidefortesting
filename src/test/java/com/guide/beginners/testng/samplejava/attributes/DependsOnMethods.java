package com.guide.beginners.testng.samplejava.attributes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DependsOnMethods {
    private static Logger logger = LogManager.getLogger(DependsOnMethods.class.getName( ));

    /*
    dependsOnMethods	-   The list of methods this method depends on.
    description	        -   The description for this method.
	groups              -   The list of groups this class/method belongs to.
	dependsOnGroups	    -   The list of groups this method depends on.
     */
    @Test(description = "demonstrating DependsOnMethod", alwaysRun = true,groups = "ui")
    void priority0() {
        logger.info("#priority = 0: Test");
    }

    @Test(description = "demonstrating DependsOnMethod", dependsOnMethods = "priority0",groups = "ui")
    void priority1() {
        logger.info("dependsOnMethods =\"priority0\"");
    }

    @Test(description = "demonstrating DependsOnMethod", dependsOnMethods = "priority1", dependsOnGroups = "ui")
    void priority2() {
        logger.info("dependsOnMethods =\"priority1\"+dependsOnGroups = \"ui\"");
    }


}
