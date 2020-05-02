package com.guide.beginners.testng.samplejava.attributes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExampl {
    /*
    Parameters  -   Describes how to pass parameters to a @Test method.
    value       -	The list of variables used to fill the parameters of this method.

      Parameters
        1 - Parameters from testng.xml
        2 - Parameters with DataProviders
        3 - Parameters in reports
     */
    private static Logger logger = LogManager.getLogger(ParametersExampl.class.getName( ));

    @Parameters({"test-param"})
    @Test
    public void testSingleString(@Optional("Passing Parameter") String firstName) {
        logger.info("Invoked testString =>" + firstName);
        assert "Passing Parameter".equals(firstName);
    }

    //This method will provide data to any test method that declares that its Data Provider
//is named "test1"
    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]
                {
                        {"Cedric", new Integer(36)},
                        {"Anne", new Integer(37)},
                };
    }

    /*This test method declares that its data should be supplied by the Data Provider
named "test1"*/
    @Test(dataProvider = "test1")
    public void verifyData1(String n1, Integer n2) {
        logger.info(":" + "\n " + n1 + "\n " + n2);
    }

}
