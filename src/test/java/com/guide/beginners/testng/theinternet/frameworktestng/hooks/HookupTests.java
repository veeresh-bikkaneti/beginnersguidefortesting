package com.guide.beginners.testng.theinternet.frameworktestng.hooks;
/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 12:34 PM
 */
import com.guide.beginners.testng.theinternet.frameworktestng.base.WaitForSync;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages.WelcomePO;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class HookupTests extends WaitForSync {
    @Parameters("url")
    @BeforeMethod(alwaysRun = true)
    public void launchTestUrl(@Optional("https://the-internet.herokuapp.com") String aut) {
        driver.get(aut);
        driver.manage( ).timeouts( ).pageLoadTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        driver.manage( ).timeouts( ).setScriptTimeout(MAX_TIMEOUT, TimeUnit.SECONDS);
        sleep(MAX_TIMEOUT);
        logger.info("launching url:" + aut);
        WelcomePO welcomePO=new WelcomePO();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(welcomePO.getFormAuthenticationLinkLocator())).click();
        logger.info("clicked on Authentication link locator");
    }

    @AfterMethod(alwaysRun = true)
    public void validateSessionRest() {
        logger.info("Refresh the session");
    }


}
