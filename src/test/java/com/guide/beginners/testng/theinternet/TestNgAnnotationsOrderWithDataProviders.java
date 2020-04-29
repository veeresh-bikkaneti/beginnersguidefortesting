package com.guide.beginners.testng.theinternet;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class TestNgAnnotationsOrderWithDataProviders {
    private static Logger logger = LogManager.getLogger(TestNgAnnotationsOrderWithDataProviders.class.getName( ));

    @DataProvider(name = "d1")
    Object[] DataProvider() {
        logger.info("---DataProvider--");
        return new String[]{"---DataProvider--"};
    }

    @BeforeSuite
    void BeforeSuite() {
        logger.info("#1: beforesuite");
    }

    @BeforeTest
    void BeforeTest() {
        logger.info("#2: BeforeTest");
    }

    @BeforeClass
    void BeforeClass() {
        logger.info("#3: BeforeClass");
    }

    @BeforeMethod
    void BeforeMethod() {
        logger.info("#4: BeforeMethod");
    }

    @Test(dataProvider = "d1")
    void actualTest(String[] a) {
        logger.info("#5: Test");
        logger.info(a[0].toString());
    }

    @AfterMethod
    void AfterMethod() {
        logger.info("#6: AfterMethod");
    }

    @AfterClass
    void AfterClass() {
        logger.info("#7: AfterClass");
    }

    @AfterTest
    void AfterTest() {
        logger.info("#8: AfterTest");
    }

    @AfterSuite
    void AfterSuite() {
        logger.info("#9: AfterSuite");
    }

}
