package com.guide.beginners.testng.theinternet.frameworktestng.testcases.usingpageobjects;

import com.guide.beginners.testng.theinternet.frameworktestng.hooks.HookupTests;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions.LoginPage;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions.SecureAreaPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 03:10 PM
 */
public class NegativeScenarios extends HookupTests {

    @Parameters({"username", "invalidpassword", "failuremessagepassword"})
    @Test
    void invalidPasswordTest(String username, String password, String failuremessage) {
        logger.info("Entering UserName:" + username);
        logger.info("Entering password:" + password);
        logger.info("expected failuremessage:" + failuremessage);
        LoginPage loginPage = new LoginPage(driver,logger);

        // execute negative login
        loginPage.negativeLogIn(username, password);

        // wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(message.contains(failuremessage), "Message doesn't contain expected text.");
    }


    @Parameters({"invalidusername", "password", "failuremessageusername"})
    @Test
    void invalidusernameTest(String username, String password, String failuremessage) {
        logger.info("Entering UserName:" + username);
        logger.info("Entering password:" + password);
        logger.info("expected failuremessage:" + failuremessage);
        LoginPage loginPage = new LoginPage(driver,logger);

        // execute negative login
        loginPage.negativeLogIn(username, password);

        // wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(message.contains(failuremessage), "Message doesn't contain expected text.");
    }

    @Parameters({ "failuremessageusername"})
    @Test
    void invalidusernameTest(String failuremessage) {
        logger.info("Entering UserName:" + null);
        logger.info("Entering password:" + null);
        logger.info("expected failuremessage:" + failuremessage);
        LoginPage loginPage = new LoginPage(driver,logger);

        // execute negative login
        loginPage.negativeLogIn("", "");

        // wait for error message
        loginPage.waitForErrorMessage();
        String message = loginPage.getErrorMessageText();

        // Verification
        Assert.assertTrue(message.contains(failuremessage), "Message doesn't contain expected text.");
    }
}
