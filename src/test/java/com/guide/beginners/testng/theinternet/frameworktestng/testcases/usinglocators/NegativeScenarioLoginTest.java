package com.guide.beginners.testng.theinternet.frameworktestng.testcases.usinglocators;

import com.guide.beginners.testng.theinternet.frameworktestng.hooks.HookupTests;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages.LoginPO;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages.SecureAreaPO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 01:28 PM
 */


/*
Using Page locators in com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pages;
We are building the page objects here in the test class by referring the locators in pages.
 */
public class NegativeScenarioLoginTest extends HookupTests {
    private LoginPO loginPO;
    private SecureAreaPO secureAreaPO;


    public NegativeScenarioLoginTest() {
        this.loginPO = new LoginPO( );
        this.secureAreaPO = new SecureAreaPO( );
    }

    @Parameters({"username", "invalidpassword", "failuremessagepassword"})
    @Test
    void invalidPasswordTest(String username, String password, String failuremessage) {
        logger.info("Entering UserName:" + username);
        logger.info("Entering password:" + password);
        logger.info("expected failuremessage:" + failuremessage);

        driver.findElement(loginPO.getFormFieldUserName( )).sendKeys(username);
        driver.findElement(loginPO.getFormFieldPassword( )).sendKeys(password);
        getWebDriverWait( ).until(ExpectedConditions.elementToBeClickable(loginPO.getLoginButton( ))).click( );
        assert ( getWebDriverWait( ).until(ExpectedConditions.visibilityOfElementLocated(loginPO.getFailuremessage( )))
                .getText().trim()
                .contains(failuremessage));

    }


    @Parameters({"invalidusername", "password", "failuremessageusername"})
    @Test
    void invalidusernameTest(String username, String password, String failuremessage) {
        logger.info("Entering UserName:" + username);
        logger.info("Entering password:" + password);
        logger.info("expected failuremessage:" + failuremessage);
        driver.findElement(loginPO.getFormFieldUserName( )).sendKeys(username);
        driver.findElement(loginPO.getFormFieldPassword( )).sendKeys(password);
        getWebDriverWait( ).until(ExpectedConditions.elementToBeClickable(loginPO.getLoginButton( ))).click( );
        assert ( getWebDriverWait( ).until(ExpectedConditions.visibilityOfElementLocated(loginPO.getFailuremessage( )))
                .getText().trim()
                .contains(failuremessage));
    }

    @Parameters({ "failuremessageusername"})
    @Test
    void invalidusernameTest(String failuremessage) {
        logger.info("Entering UserName:" + null);
        logger.info("Entering password:" + null);
        logger.info("expected failuremessage:" + failuremessage);
        driver.findElement(loginPO.getFormFieldUserName( )).sendKeys(Keys.TAB);
        driver.findElement(loginPO.getFormFieldPassword( )).sendKeys(Keys.TAB);
        getWebDriverWait( ).until(ExpectedConditions.elementToBeClickable(loginPO.getLoginButton( ))).click( );
        assert ( getWebDriverWait( ).until(ExpectedConditions.visibilityOfElementLocated(loginPO.getFailuremessage( )))
                .getText().trim()
                .contains(failuremessage));
    }
}
