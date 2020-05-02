package com.guide.beginners.testng.theinternet.frameworktestng.hooks;

import com.guide.beginners.testng.theinternet.frameworktestng.base.WaitForSync;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class HookupTests extends WaitForSync {
    @Parameters("url")
    @BeforeMethod(alwaysRun = true)
    public void launchTestUrl(@Optional("https://the-internet.herokuapp.com/login") String aut) {
        driver.get(aut);
        driver.manage( ).timeouts( ).pageLoadTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        driver.manage( ).timeouts( ).setScriptTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        sleep(MAX_TIMEOUT);
        logger.info("launching url:" + aut);
    }

    @AfterMethod(alwaysRun = true)
    public void validateSessionRest() {
        logger.info("Refresh the session");
    }


}
