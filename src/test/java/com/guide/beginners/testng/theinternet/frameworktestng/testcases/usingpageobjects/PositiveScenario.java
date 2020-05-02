package com.guide.beginners.testng.theinternet.frameworktestng.testcases.usingpageobjects;

import com.guide.beginners.testng.theinternet.frameworktestng.hooks.HookupTests;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions.LoginPage;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions.SecureAreaPage;
import com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions.WelcomePageObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Veeresh Bikkaneti
 * Date: 05-02-2020
 * Time: 02:06 PM
 */
/*
Using Page locators in com.guide.beginners.testng.theinternet.frameworktestng.pagefactory.pageactions;
        We are building the page objects here in the test class by referring the locators in pages.
        */
public class PositiveScenario extends HookupTests {

    @Parameters({"username", "password", "successmessage"})
    @Test
    public void testLogin(String user, String pass, String flg) {
        LoginPage loginPage = new LoginPage(driver,logger);
        SecureAreaPage secureAreaPage = loginPage.logIn(user, pass);
        logger.info("flag:" + secureAreaPage.equals(flg));
    }
}
