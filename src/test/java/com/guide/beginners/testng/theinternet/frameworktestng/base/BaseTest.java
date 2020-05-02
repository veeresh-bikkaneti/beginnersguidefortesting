package com.guide.beginners.testng.theinternet.frameworktestng.base;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 12:34 PM
 */

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected final long MAX_TIMEOUT = 20l;
    protected Logger logger;
    protected WebDriver driver = null;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext ctx) {
        if (Objects.isNull(this.driver)) {
            String testName = ctx.getCurrentXmlTest( ).getName( );
            logger = LogManager.getLogger(testName);
            // Create driver
            BrowserFactory browserFactory = new BrowserFactory(browser, logger);
            this.driver = browserFactory.getWebDriver( );
            this.driver.manage( ).timeouts( ).implicitlyWait(MAX_TIMEOUT, TimeUnit.SECONDS);
            logger.info("WebDriver Setup");
        } else {
            logger.throwing(Level.FATAL, new NullPointerException( ));
        }
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser() {
        logger.info("Closing the WebDriver");
        driver.close( );
        logger.info("Quit the WebDriver");
        driver.quit( );
    }
}
